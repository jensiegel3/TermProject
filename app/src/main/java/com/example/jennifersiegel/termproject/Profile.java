package com.example.jennifersiegel.termproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class Profile extends BaseActivity implements OnClickListener {

    private Button logout;
    private TextView name;
    private TextView points;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        name = (TextView) findViewById(R.id.userName);
        points = (TextView) findViewById(R.id.userPoints);
        name.setText(loggedInName);

        // set current activity name
        currentActivityName = "Profile";

        // set up listeners for the buttons
        logout = (Button) findViewById(R.id.logout);
        logout.setOnClickListener(this);

        // method to populate current points
        points.setText(Integer.toString(getPoints()));


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
