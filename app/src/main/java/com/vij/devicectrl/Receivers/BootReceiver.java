package com.vij.devicectrl.Receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.vij.devicectrl.Services.ControllerService;

public class BootReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent arg1) {
        Log.i("ControllerService", "PubNub BootReceiver Starting");
        Intent intent = new Intent(context, ControllerService.class);
        context.startService(intent);
        Log.i("ControllerService", "PubNub BootReceiver Started");
    }
}
