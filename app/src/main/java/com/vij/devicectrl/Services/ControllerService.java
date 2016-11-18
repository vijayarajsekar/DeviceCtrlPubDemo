package com.vij.devicectrl.Services;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.PowerManager;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import android.widget.Toast;

import com.pubnub.api.Callback;
import com.pubnub.api.Pubnub;
import com.pubnub.api.PubnubException;
import com.vij.devicectrl.Operations.Controller;
import com.vij.devicectrl.Receivers.DataReceiver;
import com.vij.devicectrl.Utilities.AccessKeys;
import com.vij.devicectrl.Utilities.Config;
import com.vij.devicectrl.Utilities.NotificationUtils;

import org.json.JSONException;
import org.json.JSONObject;

public class ControllerService extends Service implements AccessKeys {

    private String TAG = ControllerService.class.getSimpleName();

    private String channel = KEY_CHANNEL;
    private Pubnub pubnub = new Pubnub(KEY_PUB, KEY_SUB, false);
    private PowerManager.WakeLock wl = null;

    private Context mContext;

    private void notifyUser(Object message) {

        try {

            final String obj = (String) message;
            Log.i("Received msg : ", obj.toString());

            Intent resultIntent = new Intent(getApplicationContext(), ControllerService.class);
            resultIntent.putExtra("message", obj);
            showNotificationMessage(obj, resultIntent);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onCreate() {
        super.onCreate();

        mContext = this;

        PowerManager pm = (PowerManager) getSystemService(Context.POWER_SERVICE);
        wl = pm.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, "SubscribeAtBoot");

        if (wl != null) {
            wl.acquire();
            Log.i("PUBNUB", "Partial Wake Lock : " + wl.isHeld());
        }

        Log.i("PUBNUB", "ControllerService created...");

        try {

            pubnub.subscribe(new String[]{channel}, new Callback() {

                public void connectCallback(String channel) {
                    notifyUser("CONNECT on channel:" + channel);
                }

                public void disconnectCallback(String channel) {
                    notifyUser("DISCONNECT on channel:" + channel);
                }

                public void reconnectCallback(String channel) {
                    notifyUser("RECONNECT on channel:" + channel);
                }

                @Override
                public void successCallback(String channel, Object message) {
                    notifyUser(message.toString());
                }

                @Override
                public void errorCallback(String channel, Object message) {
                    notifyUser(channel + " " + message.toString());
                }
            });

        } catch (PubnubException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onDestroy() {

        super.onDestroy();

        if (wl != null) {
            wl.release();
            Log.i("PUBNUB", "Partial Wake Lock : " + wl.isHeld());
            wl = null;
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int onStartCommand(final Intent intent, final int flags,
                              final int startId) {

        return Service.START_STICKY;
    }

    @Override
    public void onTaskRemoved(Intent rootIntent) {
        super.onTaskRemoved(rootIntent);
    }

    private void showNotificationMessage(String _data, Intent intent) {

        NotificationUtils notificationUtils = new NotificationUtils(mContext);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

        try {

            JSONObject data = new JSONObject(_data).getJSONObject("data");

            String title = data.getString("title");
            String message = data.getString("message");
            String imageUrl = data.getString("image");
            String timestamp = data.getString("timestamp");

            Log.e(TAG, "title: " + title);
            Log.e(TAG, "message: " + message);
            Log.e(TAG, "imageUrl: " + imageUrl);
            Log.e(TAG, "timestamp: " + timestamp);

            if (imageUrl.toString().length() != 0) {
                notificationUtils.showNotificationMessage(title, message, timestamp, intent, imageUrl);
            } else {
                notificationUtils.showNotificationMessage(title, message, timestamp, intent);
            }

        } catch (JSONException ex) {
            Log.e(TAG, ex.getMessage().toString());
        }
    }
}