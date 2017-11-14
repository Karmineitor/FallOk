/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.explicitintent;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    /* Variables con nuestros TextEdit y boton */


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
         *Identificamos el boton con su id, lo que nos permite controlar sus acciones
         */
        Button mDoSomethingCoolButton = (Button) findViewById(R.id.b_do_something_cool);
        Button mCarga_Numeros = (Button) findViewById(R.id.b_NConfianza);
        Button mDatos = (Button) findViewById(R.id.b_Datos);
        EditText mNombre = (EditText)findViewById(R.id.Nombre_User);
        Button mGDatos = (Button)findViewById(R.id.b_GuardarDatos);

        /* Configuramos un Listener para hacer cosas cuando el botón es presionado */
        mDoSomethingCoolButton.setOnClickListener(new OnClickListener() {

            /**
             * El metodo Onclick se activa cuando el boton es presionado
             *
             * @param v Es la vista clickeada. En este casi es el boton mDoSomethingCoolButton.
             */
            @Override
            public void onClick(View v) {

                Context context = MainActivity.this;

                Class destinationActivity = Bluetooth.class;

                Intent startChildActivityIntent = new Intent(context, destinationActivity);

                startActivity(startChildActivityIntent);
            }

        });

        mCarga_Numeros.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = MainActivity.this;
                Class destinationActivity = Carga_Numeros.class;
                Intent startCarga_NumerosIntent = new Intent(context, destinationActivity);
                startActivity(startCarga_NumerosIntent);

            }
        });

        mDatos.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iDatos= new Intent(MainActivity.this, Datos.class);
                startActivity(iDatos);
            }
        });

    }
    public void onClickOpenRegistoButton(View v) {

        String urlAsString = "http://www.udacity.com";
        openWebPage(urlAsString);
    }
    public void onClickOpenNumerosButton(View v) {

        Intent num = new Intent(this, Carga_Numeros.class);
        startActivity(num);
    }

    private void openWebPage(String url) {

        Uri webpage = Uri.parse(url);


        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);


        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

}

