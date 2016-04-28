package com.vij.devicectrl.Utilities;

/**
 * Created by joy on 15/7/15.
 */
public interface DbConstants {

    // Databse Values //
    public String DATABASE_NAME = "DevicesDB";
    public String USER_TABLE = "UsersList";

    public int DATABASE_VERSION = 1;

    // Main Table Fields //
    public String KEY_ID = "Id";
    public String KEY_USERNAME = "Username";
    public String KEY_MOBILE = "Mobile";

    public String KEY_DEVICE_NAME = "DeviceName";
    public String KEY_DEVICE_IP = "DeviceIp";
    public String KEY_MAC_ID = "MacId";
    public String KEY_OPERATOR = "Operator";

    public String KEY_CHANNEL = "Channel";

    public String KEY_COLOR = "Color";
    public String KEY_PIC = "ProfilePic";

    public String CREATE_TABLE_USERS = "create table " + USER_TABLE + "("
            + KEY_ID + " integer primary key autoincrement,"
            + KEY_USERNAME + " text not null,"
            + KEY_MOBILE + " text not null,"
            + KEY_DEVICE_NAME + " text not null,"
            + KEY_DEVICE_IP + " text not null,"
            + KEY_MAC_ID + " text not null,"
            + KEY_OPERATOR + " text not null,"
            + KEY_CHANNEL + " text not null,"
            + KEY_COLOR + " text not null,"
            + KEY_PIC + " text not null);";
}
