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

public class Profile extends BaseActivity implements OnClickListener {

    private Button logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        // set current activity name
        currentActivityName = "Profile";

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

}
