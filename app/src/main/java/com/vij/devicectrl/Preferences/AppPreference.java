package com.vij.devicectrl.Preferences;

import android.content.Context;
import android.content.SharedPreferences;

import com.vij.devicectrl.AppController;

/**
 * Created by vijayarajsekar on 26/4/16.
 */
public class AppPreference extends PrefConstants {

    private static final String TAG = AppPreference.class.getSimpleName();

    private static SharedPreferences mPreferences;

    private SharedPreferences.Editor mEditor;

    private Context mContext;

    private int PRIVATE_MODE = 0;

    private static AppPreference instance;

    public static final synchronized AppPreference instance() {
        if (instance == null) {
            instance = new AppPreference();
        }
        return instance;
    }

    public AppPreference() {
        this.mContext = AppController.getInstance();
        mPreferences = mContext.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        mEditor = mPreferences.edit();
    }

    public boolean getTutorialStatus() {
        return mPreferences.getBoolean(IS_SPLASH_SCREEN, false);
    }

    public void setTutorialStatus(boolean values) {
        mEditor.putBoolean(IS_SPLASH_SCREEN, values);
        mEditor.commit();
    }
}
