package com.example.moneypeer;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.Manifest;
import android.content.pm.PackageManager;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Set;

public class BluetoothActivity extends AppCompatActivity {

    private static final int REQUEST_ENABLE_BT = 0;
    private static final int REQUEST_DISCOVER_BT = 1;
    private static final int PERMISSION_REQUEST_CODE = 123;

    private TextView mstatusTv, mpairedTv;
    ImageView mBlueTv;
    Button mOnBtn, mOffBtn, mSucheBtn, mPairedBtn;
    BluetoothAdapter bluetoothAdpt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_nearby_device);

        mstatusTv = findViewById(R.id.deviceNameTextView);
        mpairedTv = findViewById(R.id.pairTv);
        mBlueTv = findViewById(R.id.bluetoothTv);
        mOnBtn = findViewById(R.id.onButton);
        mOffBtn = findViewById(R.id.offButton);
        mSucheBtn = findViewById(R.id.sucheButton);
        mPairedBtn = findViewById(R.id.verbundenButton);

        bluetoothAdpt = BluetoothAdapter.getDefaultAdapter();

        if (bluetoothAdpt == null) {
            mstatusTv.setText("Bluetooth is not available");
        } else {
            mstatusTv.setText("Bluetooth is available");
        }

        if (bluetoothAdpt.isEnabled()) {
            mBlueTv.setImageResource(R.drawable.bluetooth_on);
        } else {
            mBlueTv.setImageResource(R.drawable.bluetooth_off);
        }

        mOnBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!bluetoothAdpt.isEnabled()) {
                    // Check for BLUETOOTH_ADMIN permission before attempting to enable Bluetooth
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        if (checkSelfPermission(Manifest.permission.BLUETOOTH_ADMIN) == PackageManager.PERMISSION_GRANTED) {
                            showToast("Turning on Bluetooth...");
                            Intent intent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                            startActivity(intent);
                        } else {
                            // Handle the case where permission is not granted
                            showToast("Bluetooth permission not granted");
                        }
                    }
                } else {
                    showToast("Bluetooth is already on");
                }
            }
        });

        mSucheBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (bluetoothAdpt.isEnabled()) {
                    // Check for BLUETOOTH_ADVERTISE permission before attempting to make the device discoverable
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        if (checkSelfPermission(Manifest.permission.BLUETOOTH_ADVERTISE) == PackageManager.PERMISSION_GRANTED) {
                            showToast("Making your device Discoverable");
                            Intent intent = new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
                            startActivityForResult(intent, REQUEST_DISCOVER_BT);
                        } else {
                            // Handle the case where permission is not granted
                            showToast("Bluetooth advertise permission not granted");
                        }
                    }
                } else {
                    showToast("Bluetooth is not enabled");
                }
            }
        });


        mOffBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (bluetoothAdpt.isEnabled()) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        if (checkSelfPermission(Manifest.permission.BLUETOOTH_ADMIN) == PackageManager.PERMISSION_GRANTED) {
                            showToast("Turning off Bluetooth...");
                            Intent intent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                            startActivity(intent);
                            mBlueTv.setImageResource(R.drawable.bluetooth_off);
                        } else {
                            showToast("Bluetooth permission not granted");
                        }
                    } else {
                        showToast("Bluetooth is already off");
                    }
                    }
                }
        });

        mPairedBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    if (checkSelfPermission(Manifest.permission.BLUETOOTH) == PackageManager.PERMISSION_GRANTED &&
                            checkSelfPermission(Manifest.permission.BLUETOOTH_ADMIN) == PackageManager.PERMISSION_GRANTED) {
                        // Bluetooth permissions are granted
                        if (bluetoothAdpt.isEnabled()) {
                            mpairedTv.setText("Verbundene Geräte");
                            Set<BluetoothDevice> devices = bluetoothAdpt.getBondedDevices();

                            for (BluetoothDevice device : devices) {
                                mpairedTv.append("\n Device: " + device.getName() + ", " + device);
                            }
                        } else {
                            showToast("Turn On Bluetooth to get paired devices");
                        }
                    } else {
                        // Bluetooth permissions are not granted, request them
                        requestPermissions(new String[]{Manifest.permission.BLUETOOTH, Manifest.permission.BLUETOOTH_ADMIN}, PERMISSION_REQUEST_CODE);
                    }
                }
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        switch(requestCode) {
            case REQUEST_ENABLE_BT:
                    if(resultCode== RESULT_OK) {
                        mBlueTv.setImageResource(R.drawable.bluetooth_on);
                        showToast("Bluetooth is on");
                    } else {
                        showToast("Bluetooth is off");
                    }
                    break;
        }

        super.onActivityResult(requestCode, resultCode, data);

    }

    private void showToast(String msg) {
        Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_SHORT).show();
    }
}
