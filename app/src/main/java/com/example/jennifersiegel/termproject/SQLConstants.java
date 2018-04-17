package com.example.jennifersiegel.termproject;

/**
 * Created by Dana on 4/17/2018.
 */

public class SQLConstants {
    public static final String DATABASE_NAME = "users.db";
    public static final int DATABASE_VERSION = 1;
    public static final String TABLE_NAME = "registeredUsers";
    public static final String KEY_NAME = "email";
    public static final String KEY_Q = "points";
    public static final String KEY_ID = "id integer primary key autoincrement";
    public static final String CREATE_TABLE = "CREATE TABLE registeredUsers ("
            + SQLConstants.KEY_ID + "," + SQLConstants.KEY_NAME + " text,"
            + SQLConstants.KEY_Q + " integer);";
}
