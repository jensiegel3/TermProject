package com.example.jennifersiegel.termproject;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.MenuItem;

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
    public int getPoints(){
        db = openOrCreateDatabase(SQLConstants.DATABASE_NAME, Context.MODE_PRIVATE, null);
        String whereClause = SQLConstants.KEY_NAME + "= ?";
        String[] emailLogin = new String[] {loggedInName.toUpperCase()};
        cursor = db.query(SQLConstants.TABLE_NAME, new String[]{SQLConstants.KEY_Q}, whereClause, emailLogin,null, null, null);
        cursor.moveToNext();
        int intPoints = cursor.getInt(cursor.getColumnIndex(SQLConstants.KEY_Q));
        return intPoints;
    }

}
