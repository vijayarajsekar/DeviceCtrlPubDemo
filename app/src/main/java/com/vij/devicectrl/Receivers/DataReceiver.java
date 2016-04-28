package com.vij.devicectrl.Receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.vij.devicectrl.Ui.HomeScreen;

/**
 * Created by joy on 14/7/15.
 */
public class DataReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        Toast.makeText(context, intent.getExtras().getString("CMD"), Toast.LENGTH_SHORT).show();

        if (intent != null) {
            String mData = intent.getExtras().getString("CMD");

            System.out.println("~~~~~~~~~" + mData);

//            if (HomeScreen.getListener() != null) {
//                HomeScreen.getListener().ProcessCommand(mData);
//            }

//            HomeScreen.captureScreenshot();
        }
    }
}
