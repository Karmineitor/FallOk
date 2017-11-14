package com.example.android.explicitintent;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Set;

/**
 * Created by dejee on 27/10/2017.
 */

public class Bluetooth extends AppCompatActivity {
    Button BtnApagarBt, BtnBuscaDispositivos;
    private BluetoothAdapter BA;
    private Set<BluetoothDevice> pairedDevices;
    ListView lv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Log.d("DEVICELIST", "Super called for DeviceListFragment onCreate\n");
        setContentView(R.layout.bluetooth);


        BA = BluetoothAdapter.getDefaultAdapter();
        lv = (ListView) findViewById(R.id.ListaDispositivosBt);
        EncenderBt();

        BtnApagarBt = (Button) findViewById(R.id.ApagarBt);
        BtnBuscaDispositivos = (Button) findViewById(R.id.BuscaDispositivos);
        BtnApagarBt.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                ApagarBt(v);
            }
        });
        BtnBuscaDispositivos.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                BuscaBt(v);
            }
        });
    }


    public void EncenderBt(){
        if(BA.disable()){
            BA.enable();
            Intent turnOn = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(turnOn, 0);
            Toast.makeText(getApplicationContext(),"Bluetooth activado", Toast.LENGTH_SHORT).show();
        }
//        else{
//            BA.enable();
//            Intent turnOn = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
//            startActivityForResult(turnOn, 0);
//            Toast.makeText(getApplicationContext(),"Encendido", Toast.LENGTH_LONG).show();
//        }
    }

    public void ApagarBt(View v){
        BA.disable();
        Toast.makeText(getApplicationContext(),"El Bluetooth se ha Apagado", Toast.LENGTH_SHORT).show();
    }

    public void VisibleBt(View v){
        BA.disable();
        Toast.makeText(getApplicationContext(),"Bluetooth visible", Toast.LENGTH_SHORT).show();

    }

    public void BuscaBt(View v){
        pairedDevices = BA.getBondedDevices();
        ArrayList list = new ArrayList();

        for(BluetoothDevice bt : pairedDevices)
            list.add(bt.getName());
//        Toast.makeText(getApplicationContext(), "Mostrando Dispositivos Encontrados", Toast.LENGTH_SHORT).show();

        final ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,list);
        lv.setAdapter(adapter);

        BA.startDiscovery();
    }

//    private void displayListOfFoundDevices()
//    { // start looking for bluetooth devices
//        BA.startDiscovery();

//        // Discover new devices
//        // Create a BroadcastReceiver for ACTION_FOUND
//        final BroadcastReceiver mReceiver = new BroadcastReceiver()
//        {
//            @Override
//            public void onReceive(Context context, Intent intent)
//            {
//                String action = intent.getAction();
//                // When discovery finds a device
//                if (BluetoothDevice.ACTION_FOUND.equals(action))
//                {
//                    // Get the bluetoothDevice object from the Intent
//                    BluetoothDevice device = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
//
//                    // Get the "RSSI" to get the signal strength as integer,
//                    // but should be displayed in "dBm" units
//                    int rssi = intent.getShortExtra(BluetoothDevice.EXTRA_RSSI,Short.MIN_VALUE);
//
//                    // Create the device object and add it to the arrayList of devices
//                    BluetoothObject bluetoothObject = new BluetoothObject();
//                    BluetoothDevice.setBluetooth_name();
//                    BluetoothDevice.setBluetooth_address(device.getAddress());
//                    BluetoothDevice.setBluetooth_state(device.getBondState());
//                    //BluetoothDevice.setBluetooth_type(device.getType());    // requires API 18 or higher
//                    BluetoothDevice.setBluetooth_uuids(device.getUuids());
//                    ;
//
//                    arrayOfFoundBTDevices.add(bluetoothObject);
//
//                    // 1. Pass context and data to the custom adapter
//                    FoundBTDevicesAdapter adapter = new FoundBTDevicesAdapter(getApplicationContext(), arrayOfFoundBTDevices);
//
//                    // 2. setListAdapter
//                    setListAdapter(adapter);
//                }
//            }
//        };
//        // Register the BroadcastReceiver
//        IntentFilter filter = new IntentFilter(BluetoothDevice.ACTION_FOUND);
//        registerReceiver(mReceiver, filter);
//    }


}