package com.example.jennifersiegel.termproject;

import android.view.Menu;
import android.view.MenuItem;
import android.app.Activity;
import android.os.Bundle;
import android.database.*;
import android.database.sqlite.*;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.content.*;
import android.widget.Toast;

/**
 * Created by Dana on 4/3/2018.
 */

public class Login extends BaseActivity {

    private Button login;
    private Button createNew;
    private EditText loginName;

// This variable used only when creating a new table
    private final String create = SQLConstants.CREATE_TABLE;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Button to initiate login check
        login = (Button) findViewById(R.id.login);
        // Button to create a new profile (register)
        createNew = (Button) findViewById(R.id.createNew);
        // edit text for user's login
        loginName = (EditText) findViewById(R.id.profileId);

        // create database and table
        db = openOrCreateDatabase(SQLConstants.DATABASE_NAME,
                Context.MODE_PRIVATE, null);

        ///////////////////////////////////////////////////////////////
        // remove code to keep database static
        if (!logInCheck("danafshay@gmail.com")){
            db.execSQL("DROP TABLE IF EXISTS " + SQLConstants.TABLE_NAME);
            db.execSQL(create);
        }
        ///////////////////////////////////////////////////////////////

        // check if records exist
        // insert records
        if (!logInCheck("danafshay@gmail.com")){
            createProfile("danafshay@gmail.com", 9);
            //displayProfile("danafshay@gmail.com");
        }

        if (!logInCheck("antonbagayev@gmail.com")) {
            createProfile("antonbagayev@gmail.com", 23);
            //displayProfile("antonbagayev@gmail.com");
        }

        if (!logInCheck("jensiegel3@gmail.com")){
            createProfile("jensiegel3@gmail.com", 13);
            //displayProfile("jensiegel3@gmail.com");
        }

        if (!logInCheck("mileskap@gmail.com")){
            createProfile("mileskap@gmail.com", 37);
            //displayProfile("mileskap@gmail.com");
       }

        // LogIn button listener
        login.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                String s = loginName.getText().toString().toUpperCase();

                if (logInCheck(s)) {
                    Toast.makeText(getApplicationContext(), "Found Profile", Toast.LENGTH_LONG).show();
                    loggedInName = s;
                    endLoginActivity();
                }
                else {
                    Toast.makeText(getApplicationContext(), "No Profile Found", Toast.LENGTH_LONG).show();
                }
            }
        });

        // Create Profile button listener
        createNew.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                String s = loginName.getText().toString().toUpperCase();

                if (logInCheck(s)){
                    Toast.makeText(getApplicationContext(), "Profile Already Exists", Toast.LENGTH_LONG).show();
                }
                else {
                    createProfile(s,0);
                    Toast.makeText(getApplicationContext(), "Profile Created", Toast.LENGTH_LONG).show();
                    loggedInName = s;
                    endLoginActivity();
                }
            }
        });
    }

    // Login Check method
    public boolean logInCheck (String login){
        boolean result = false;
        String whereClause = SQLConstants.KEY_NAME + "= ?";
        String[] emailLogin = new String[] {login.toUpperCase()};
        try {
            cursor = db.query(SQLConstants.TABLE_NAME, new String[]{/*KEY_ID,*/ SQLConstants.KEY_NAME,
                            SQLConstants.KEY_Q}, whereClause, emailLogin,
                    null, null, null);
            // check for profile and write contents of Cursor to screen
            if (cursor.moveToNext()) result = true;
        } catch (SQLiteException e) {}
        return result;
    }

    // Create Profile method
    public void createProfile (String login, int points) {
        // set profile with points passed
        values = new ContentValues();
        values.put(SQLConstants.KEY_NAME, login.toUpperCase());
        values.put(SQLConstants.KEY_Q, points);
        db.insert(SQLConstants.TABLE_NAME, null, values);
    }

    // Method that ends login activity and moves the user to Home Page
    public boolean endLoginActivity(){
        Intent iHome = new Intent(this, HomePage.class);
        startActivityForResult(iHome, 1);
        return true;
    }

    // close database
    @Override
    protected void onPause() {
        super.onPause();
        if (db != null)
            db.close();
    }

    // create empty options menu (overriding the regular gloabl menu in BaseActivity)
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    // add functionality to menu buttons
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}