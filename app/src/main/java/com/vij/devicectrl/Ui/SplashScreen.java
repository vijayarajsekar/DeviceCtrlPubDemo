package com.vij.devicectrl.Ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.vij.devicectrl.Database.UsersDatabase;
import com.vij.devicectrl.Preferences.AppPreference;
import com.vij.devicectrl.R;
import com.vij.devicectrl.Services.ControllerService;
import com.vij.devicectrl.Utilities.ArcProgress;

import java.util.Timer;
import java.util.TimerTask;


public class SplashScreen extends Activity {

    private String TAG = SplashScreen.class.getSimpleName();

    private Timer mTimer;
    private ArcProgress mArcProgress;

    private int mMaxProgress = 100;

    private UsersDatabase mUsersDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);

        InitService();

        mArcProgress = (ArcProgress) findViewById(R.id.arc_progress);

        mTimer = new Timer();

        if (!AppPreference.instance().getTutorialStatus()) {

            AppPreference.instance().setTutorialStatus(true);

            mTimer.schedule(new TimerTask() {
                @Override
                public void run() {

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            mArcProgress.setProgress(mArcProgress.getProgress() + 1);

                            if (mArcProgress.getProgress() == mMaxProgress) {
                                mTimer.cancel();

                                startActivity(new Intent(SplashScreen.this, HomeScreen.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));

                                finish();
                            }
                        }
                    });
                }
            }, 1000, 100);

        } else {
            startActivity(new Intent(SplashScreen.this, HomeScreen.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
        }
    }

    private void InitService() {

//        mUsersDatabase = new UsersDatabase(this);

        Intent serviceIntent = new Intent(this, ControllerService.class);
        startService(serviceIntent);
        Log.i(TAG, "PubNub Activity Started!");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mTimer != null)
            mTimer.cancel();
    }
}