package com.claseipst51android2021cl.grupo4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivityUbicacion extends AppCompatActivity {

    //Declaro e importo lo que usare "Botones"
    Button btnSitios, btnUbicacion, btnTipos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_ubicacion);

        //Titulo de la aplicacion o action bar que lo centre
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.txt_titulo);

        //Flecha volver
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Agrego los valores o casteo los botones por su id
        btnUbicacion = (Button) findViewById(R.id.btn_Ubicacion); //i1
        btnSitios = (Button) findViewById(R.id.btn_Sitios); //i2
        btnTipos = (Button) findViewById(R.id.btn_Tipos); //i3



        /**Eventos de botones **/

        //Ubicación
        btnUbicacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1 = new Intent (getApplicationContext(),MapsActivity1.class);
                startActivity(i1);
            }
        });
        //Sitios Turisticos
        btnSitios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2 = new Intent (getApplicationContext(),MapsActivity2.class);
                startActivity(i2);
            }
        });
    }

    //Este evento de boton esta afuera del OnCreate para crear mas codigo que usare + adelante
    public void MapaSitios(View v)
    {
        Intent i3 = new Intent (getApplicationContext(),MapsActivityTipos.class);
        startActivity(i3);
    }




    //Metodo para la flecha y volver atras
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}










