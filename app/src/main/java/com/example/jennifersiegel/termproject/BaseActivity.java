package com.example.jennifersiegel.termproject;

import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;

/**
 * Created by Anton on 4/18/2018.
 */

public class BaseActivity extends Activity {

    protected String currentActivityName;

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

}
