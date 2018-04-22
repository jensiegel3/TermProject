package com.example.jennifersiegel.termproject;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

/**
 * Created by Anton on 4/18/2018.
 */

public class BaseActivity extends Activity {

    protected static String currentActivityName;
    protected static String loggedInName;

    // SQLite variables
    protected SQLiteDatabase db;
    protected ContentValues values;
    protected Cursor cursor;

    // create options menu
    // does this have to go on every page?
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    // add functionality to menu buttons
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){

            case R.id.loginMenu:
                Intent iLogin = new Intent(this, Login.class);
                startActivity(iLogin);
                return true;

            case R.id.profileMenu:
                // don't start the same activity again
                if (!currentActivityName.equals("Profile")){
                    Intent iProfile = new Intent(this, Profile.class);
                    startActivity(iProfile);
                }
                return true;

            case R.id.materialsMenu:
                // don't start the same activity again
                if (!currentActivityName.equals("Materials")){
                    Intent iMaterials = new Intent(this, Materials.class);
                    startActivity(iMaterials);
                }
                return true;

            case R.id.findABinMenu:
                // don't start the same activity again
                if (!currentActivityName.equals("FindABin")){
                    Intent iFindABin = new Intent(this, FindABin.class);
                    startActivity(iFindABin);
                }
                return true;

            case R.id.scanCodeMenu:
                scanBarcode(getWindow().getDecorView().getRootView());
                return true;

            case R.id.aboutMenu:
                // don't start the same activity again
                if (!currentActivityName.equals("AboutUs")){
                    Intent iAbout = new Intent(this, AboutUs.class);
                    startActivity(iAbout);
                }
                return true;

            case R.id.incentiveMenu:
                // don't start the same activity again
                if (!currentActivityName.equals("Incentive")){
                    Intent iIncentive = new Intent(this, Incentive.class);
                    startActivity(iIncentive);
                }
                return true;

//            case R.id.exit:
//                finish();
//                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    // Global method to get user's ponts
    public int getPoints(){
        db = openOrCreateDatabase(SQLConstants.DATABASE_NAME, Context.MODE_PRIVATE, null);
        String whereClause = SQLConstants.KEY_NAME + "= ?";
        String[] emailLogin = new String[] {loggedInName.toUpperCase()};
        cursor = db.query(SQLConstants.TABLE_NAME, new String[]{SQLConstants.KEY_Q}, whereClause, emailLogin,null, null, null);
        cursor.moveToNext();
        int intPoints = cursor.getInt(cursor.getColumnIndex(SQLConstants.KEY_Q));
        return intPoints;
    }


    ////////////////////////////////////////////////////////
    // QR Code scanning methods
    ////////////////////////////////////////////////////////

    public void scanBarcode(View view) {
        // This code will go into the "onActivityResult" method in production version
        // Code lives here for testing ONLY
        // increasing points by 1
        values = new ContentValues();
        String pointIncrease = String.valueOf(getPoints()+1);
        values.put(SQLConstants.KEY_Q, pointIncrease);
        db.update(SQLConstants.TABLE_NAME, values, SQLConstants.KEY_NAME + "=?",
                new String[]{loggedInName});
        // end of update sql code
        //

        IntentIntegrator integrator = new IntentIntegrator(this);
        integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE);
        integrator.setPrompt("Please scan the QR code on the recycling bin!");
        integrator.setOrientationLocked(false);
        integrator.setBeepEnabled(true);
        integrator.initiateScan();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if(result != null) {
            if(result.getContents() == null) {
                Toast.makeText(this, "Cancelled", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, "Scanned: " + result.getContents(), Toast.LENGTH_LONG).show();



            }
        } else {
            // This is important, otherwise the result will not be passed to the fragment
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

}
