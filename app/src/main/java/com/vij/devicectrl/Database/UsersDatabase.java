package com.vij.devicectrl.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.vij.devicectrl.Utilities.DbConstants;

/**
 * Created by joy on 15/7/15.
 */
public class UsersDatabase implements DbConstants {

    private Context mContext = null;
    private DbHelper mDBHelper = null;
    private SQLiteDatabase mSQLiteDatabase = null;


    public UsersDatabase(Context ctx) {
        this.mContext = ctx;
        mDBHelper = new DbHelper(mContext);
    }

    public UsersDatabase OpenCon() {
        mSQLiteDatabase = mDBHelper.getWritableDatabase();
        return this;
    }

    public void CloseCon() {
        mSQLiteDatabase.close();
    }
}
