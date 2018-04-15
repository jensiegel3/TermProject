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

public class Login extends Activity {

    private Button login;
    private TextView text;
    private EditText loginName;
    private SQLiteDatabase db;
    private ContentValues values;
    private Cursor cursor;
    private int idKey;

    public static final String DATABASE_NAME = "users.db";
    public static final int DATABASE_VERSION = 1;
    public static final String TABLE_NAME = "registeredUsers";
    public static final String KEY_NAME = "email";
    public static final String KEY_Q = "points";
    public static final String KEY_ID = "id integer primary key autoincrement";
    public static final String CREATE_TABLE = "CREATE TABLE registeredUsers ("
            + KEY_ID + "," + KEY_NAME + " text,"
            + KEY_Q + " integer);";

    private final String create = CREATE_TABLE;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Button to initiate login check
        login = (Button) findViewById(R.id.login);

        text = (TextView) findViewById(R.id.loginResult);
        loginName = (EditText) findViewById(R.id.profileId);

        // create database and table
        db = openOrCreateDatabase(DATABASE_NAME,
                Context.MODE_PRIVATE, null);

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        db.execSQL(create);


        // check if records exist
        // insert records
        values = new ContentValues();
        values.put(KEY_NAME, "danafshay@gmail.com".toUpperCase());
        values.put(KEY_Q, 4);
        db.insert(TABLE_NAME, null, values);


        values = new ContentValues();
        values.put(KEY_NAME, "antonbagayev@gmail.com".toUpperCase());
        values.put(KEY_Q, 23);
        db.insert(TABLE_NAME, null, values);

        values = new ContentValues();
        values.put(KEY_NAME, "jensiegel3@gmail.com".toUpperCase());
        values.put(KEY_Q, 13);
        db.insert(TABLE_NAME, null, values);

        values = new ContentValues();
        values.put(KEY_NAME, "mileskap@gmail.com".toUpperCase());
        values.put(KEY_Q, 37);
        db.insert(TABLE_NAME, null, values);



        //insert a record with SQL
        //db.execSQL("INSERT INTO" + TABLE_NAME + "(" + KEY_NAME + ", " + KEY_Q + ") VALUES(" + loginName + ",0);");

        // query table and set sort order
        /*
        cursor = db.query(TABLE_NAME, new String[]{KEY_NAME, KEY_Q}, null, null, null, null, KEY_Q);
        while (cursor.moveToNext()) {
            String str = cursor.getString(cursor.getColumnIndex(KEY_NAME));
            int count = cursor.getInt(cursor.getColumnIndex(KEY_Q));
            text.append(str + " " + Integer.toString(count) + "\n");
        }
        */

        // LogIn button listener
        login.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){

                String s = loginName.getText().toString().toUpperCase();

                if (logInCheck(s)) {
                    Toast.makeText(getApplicationContext(), "Found Profile", Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(getApplicationContext(), "No Profile Found", Toast.LENGTH_LONG).show();
                    // make create button separate from login button
                    Toast.makeText(getApplicationContext(), "New Profile Generated", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    // Login Check method
    public boolean logInCheck (String login){
        boolean result = false;
        String whereClause = KEY_NAME + "= ?";
        String[] emailLogin = new String[] {login};

        cursor = db.query(TABLE_NAME, new String[]{/*KEY_ID,*/ KEY_NAME, KEY_Q}, whereClause, emailLogin,null, null, null);

        // check for profile and write contents of Cursor to screen
        while (cursor.moveToNext()) {
            result = true;
            //idKey = cursor.getInt(cursor.getColumnIndex(KEY_ID));
            String str = cursor.getString(cursor.getColumnIndex(KEY_NAME));
            int count = cursor.getInt(cursor.getColumnIndex(KEY_Q));
            text.append(
//                    Integer.toString(idKey) + " " +
                            str + " " + Integer.toString(count) + "\n");
        }

        if (result == false) {
            // set profile with 0 points
            values = new ContentValues();
            values.put(KEY_NAME, login.toUpperCase());
            values.put(KEY_Q, 0);
            db.insert(TABLE_NAME, null, values);
        }
        return result;
    }

    // close database
    @Override
    protected void onPause() {
        super.onPause();
        if (db != null)
            db.close();
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
                Intent iHome = new Intent(this, HomePage.class);
                startActivity(iHome);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}