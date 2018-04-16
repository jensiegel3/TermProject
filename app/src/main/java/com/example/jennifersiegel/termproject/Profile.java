package com.example.jennifersiegel.termproject;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Profile extends Activity implements OnClickListener {

    private Button logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        // set up listeners for the buttons
        logout = (Button) findViewById(R.id.logout);
        logout.setOnClickListener(this);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.logout:
                Intent iLogout = new Intent(this, Login.class);
                startActivity(iLogout);
                break;

            default:
                throw new RuntimeException("Wrong button");
        }
    }

    // create back options menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.backmenu, menu);
        return true;
    }

    // add functionality to menu buttons
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){

            case R.id.homeMenu:
                finish();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
