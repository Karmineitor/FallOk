package com.example.android.explicitintent;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by grecia on 25/06/2017.
 */

public class Carga_Numeros extends AppCompatActivity{

    private TextView mDisplayText;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.carga_numeros);

        /* Typical usage of findViewById... */
        mDisplayText = (TextView) findViewById(R.id.Numeros);
    }
}
