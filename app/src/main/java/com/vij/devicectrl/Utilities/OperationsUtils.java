package com.vij.devicectrl.Utilities;

import org.json.JSONObject;

/**
 * Created by joy on 14/7/15.
 */
public class OperationsUtils implements DbConstants {

    public static String GetDeviceDetails() {

        JSONObject mJsonObject = new JSONObject();

        try {

            mJsonObject.put(KEY_USERNAME, "");
            mJsonObject.put(KEY_MOBILE, "");
            mJsonObject.put(KEY_DEVICE_NAME, "");
            mJsonObject.put(KEY_DEVICE_IP, "");
            mJsonObject.put(KEY_MAC_ID, "");
            mJsonObject.put(KEY_OPERATOR, "");
            mJsonObject.put(KEY_CHANNEL, "");
            mJsonObject.put(KEY_COLOR, "");
            mJsonObject.put(KEY_PIC, "");

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return mJsonObject.toString();

    }
}
