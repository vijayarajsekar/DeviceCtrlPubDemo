package com.vij.devicectrl;

import android.app.Application;

/**
 * Created by vijayarajsekar on 26/4/16.
 */
public class AppController extends Application {

    public static final String TAG = AppController.class
            .getSimpleName();

    private static AppController mInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
    }

    public static synchronized AppController getInstance() {
        return mInstance;
    }
}