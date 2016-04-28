package com.vij.devicectrl.Ui;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.widget.Toast;

import com.vij.devicectrl.Interfaces.DataInterface;
import com.vij.devicectrl.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.OutputStream;

public class HomeScreen extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

    }
}