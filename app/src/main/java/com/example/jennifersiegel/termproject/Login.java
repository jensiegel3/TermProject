package com.example.jennifersiegel.termproject;

import android.content.Intent;
import android.provider.SyncStateContract;
import android.view.Menu;
import android.view.MenuItem;
import android.app.Activity;
import android.os.Bundle;
import android.database.*;
import android.database.sqlite.*;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;
import android.content.*;

/**
 * Created by Dana on 4/3/2018.
 */

public class Login extends Activity {

    private TextView text;
    private EditText loginName;
    private SQLiteDatabase db;
    private ContentValues values;
    private Cursor cursor;

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
        setContentView(R.layout.main);

        text = (TextView) findViewById(R.id.loginResult);
        loginName = (EditText) findViewById(R.id.profileId);

        // create database and table
        db = openOrCreateDatabase(DATABASE_NAME,
                Context.MODE_PRIVATE, null);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        db.execSQL(create);

        // insert records
        values = new ContentValues();
        values.put(KEY_NAME, "danafshay@gmail.com");
        values.put(KEY_Q, 4);
        db.insert(TABLE_NAME, null, values);

        values = new ContentValues();
        values.put(KEY_NAME, "antonbagayev@gmail.com");
        values.put(KEY_Q, 23);
        db.insert(TABLE_NAME, null, values);

        values = new ContentValues();
        values.put(KEY_NAME, "jensiegel3@gmail.com");
        values.put(KEY_Q, 13);
        db.insert(TABLE_NAME, null, values);

        values = new ContentValues();
        values.put(KEY_NAME, "mileskap@gmail.com");
        values.put(KEY_Q, 37);
        db.insert(TABLE_NAME, null, values);

        //
        // NEED TO CREATE ONCLICKLISTENER to run query if no result, then insert
        //
        //insert a record with SQL
        //db.execSQL("INSERT INTO" + TABLE_NAME + "(" + KEY_NAME + ", " + KEY_Q + ") VALUES(" + loginName + ",0);");

        // query table and set sort order
        //cursor = db.query(TABLE_NAME, new String[]{KEY_NAME, KEY_Q}, null, null, null, null, "email");

        // write contents of Cursor to screen
        /*
        while (cursor.moveToNext()) {
            String str = cursor.getString(cursor
                    .getColumnIndex(KEY_NAME));
            int count = cursor.getInt(cursor.getColumnIndex(KEY_Q));
            text.append(str + " " + Integer.toString(count) + "\n");
        }*/
    }

    // close database
    @Override
    protected void onPause() {
        super.onPause();
        if (db != null)
            db.close();
    }

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
        switch (item.getItemId()) {

            case R.id.loginMenu:
                Intent iLogin = new Intent(this, Login.class);
                startActivity(iLogin);
                return true;

            case R.id.profileMenu:
                Intent iProfile = new Intent(this, Profile.class);
                startActivity(iProfile);
                return true;

            case R.id.materialsMenu:
                // can I use the same name?
                Intent iMaterials = new Intent(this, Materials.class);
                startActivity(iMaterials);
                return true;

            case R.id.incentiveMenu:
                // can I use the same name?
                Intent iIncentive = new Intent(this, Incentive.class);
                startActivity(iIncentive);
                return true;

            case R.id.contactMenu:
                // can I use the same name?
                Intent iContact = new Intent(this, ContactUs.class);
                startActivity(iContact);
                return true;

            case R.id.exit:
                finish();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
