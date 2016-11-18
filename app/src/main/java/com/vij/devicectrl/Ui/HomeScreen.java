package com.vij.devicectrl.Ui;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.content.LocalBroadcastManager;
import android.widget.Toast;

import com.vij.devicectrl.Interfaces.DataInterface;
import com.vij.devicectrl.R;
import com.vij.devicectrl.Utilities.Config;
import com.vij.devicectrl.Utilities.NotificationUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.OutputStream;

public class HomeScreen extends Activity {

//    private BroadcastReceiver mRegistrationBroadcastReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

//        mRegistrationBroadcastReceiver = new BroadcastReceiver() {
//            @Override
//            public void onReceive(Context context, Intent intent) {
//
//                if (intent.getAction().equals(Config.PUSH_NOTIFICATION)) {
//
//                    String message = intent.getStringExtra("message");
//
//                    Intent resultIntent = new Intent(getApplicationContext(), HomeScreen.class);
//                    resultIntent.putExtra("message", message);
//
//                    showNotificationMessage(HomeScreen.this, "Hi", message, "2016-10-12 14:52:21", resultIntent);
//                }
//            }
//        };
    }

//    private void showNotificationMessage(Context context, String title, String message, String timeStamp, Intent intent) {
//        NotificationUtils notificationUtils = new NotificationUtils(context);
//        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
//        notificationUtils.showNotificationMessage(title, message, timeStamp, intent);
//    }
//
//    @Override
//    protected void onResume() {
//        super.onResume();
//
//        // register GCM registration complete receiver
//        LocalBroadcastManager.getInstance(this).registerReceiver(mRegistrationBroadcastReceiver,
//                new IntentFilter(Config.REGISTRATION_COMPLETE));
//
//        // register new push message receiver
//        // by doing this, the activity will be notified each time a new message arrives
//        LocalBroadcastManager.getInstance(this).registerReceiver(mRegistrationBroadcastReceiver,
//                new IntentFilter(Config.PUSH_NOTIFICATION));
//
//        // clear the notification area when the app is opened
//        NotificationUtils.clearNotifications(getApplicationContext());
//    }
//
//    @Override
//    protected void onPause() {
//        LocalBroadcastManager.getInstance(this).unregisterReceiver(mRegistrationBroadcastReceiver);
//        super.onPause();
//    }
}