package com.vij.devicectrl.Operations;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.os.AsyncTask;

import com.vij.devicectrl.Services.ControllerService;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by vijayarajsekar on 26/4/16.
 */
public class Controller {

    private ControllerService mService;
    private Context mContext;

    private BluetoothAdapter mBluetoothAdapter;
    private JSONObject mJsonObject;
    private String mReceivedCommand;

    public Controller(ControllerService pubnubService) {

        this.mService = pubnubService;
        this.mContext = pubnubService;
    }

    public void BlueTooth(String _cmd) {

        try {

            mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

            mJsonObject = new JSONObject(_cmd);
            mReceivedCommand = mJsonObject.getString("cmd");

            new CommandAsync().execute();

        } catch (JSONException ex) {

        }

    }

    class CommandAsync extends AsyncTask<String, String, String> {

        @Override
        protected String doInBackground(String... params) {

            if (mBluetoothAdapter.isEnabled()) {

                mBluetoothAdapter.disable();
                return "Yes";
            } else {
                mBluetoothAdapter.enable();
                return "No";
            }
        }

        @Override
        protected void onPostExecute(final String str) {
            super.onPostExecute(str);

            System.out.println("~~~~~~~~~~~~~ Status ~~~ DONE~~~~~" + str);

        }
    }
}
