package com.example.jennifersiegel.termproject;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
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

        // set up database and query to populate current points
        db = openOrCreateDatabase(SQLConstants.DATABASE_NAME, Context.MODE_PRIVATE, null);
        String whereClause = SQLConstants.KEY_NAME + "= ?";
        String[] emailLogin = new String[] {loggedInName.toUpperCase()};
        cursor = db.query(SQLConstants.TABLE_NAME, new String[]{SQLConstants.KEY_Q}, whereClause, emailLogin,null, null, null);
        cursor.moveToNext();
        int intPoints = cursor.getInt(cursor.getColumnIndex(SQLConstants.KEY_Q));
        points.setText(Integer.toString(intPoints));

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
