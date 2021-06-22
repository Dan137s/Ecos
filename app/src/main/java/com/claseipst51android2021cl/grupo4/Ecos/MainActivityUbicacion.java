package com.claseipst51android2021cl.grupo4.Ecos;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.claseipst51android2021cl.grupo4.Mapas.MapsActivity1;
import com.claseipst51android2021cl.grupo4.R;

public class MainActivityUbicacion extends AppCompatActivity {

    //Declaro e importo lo que usare "Botones"
    Button btnSitios, btnUbicacion, btnTipos;

    //Crear una alerta para encender gps
    AlertDialog alertaGPS = null;


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

        //Llamo a los metodos
        getAlertaNotGps();

        /**Eventos de botones **/

        //Ubicación
        btnUbicacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1 = new Intent (getApplicationContext(), MapsActivity1.class);
                startActivity(i1);
            }
        });

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

    //Alerta de gps apagado
    private void getAlertaNotGps() {

        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Por favor encienda el GPS. Desea activarlo?")
                .setCancelable(false)
                .setIcon(R.drawable.marca3)
                .setTitle("GPS")
                .setPositiveButton("Si", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(@SuppressWarnings("unused") final DialogInterface dialog, @SuppressWarnings("unused") final int id) {
                        startActivity(new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS));
                    }
                }).setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(final DialogInterface dialog, @SuppressWarnings("unused") final int id) {
                dialog.cancel();

            }
        });
        alertaGPS = builder.create();
        alertaGPS.show();

    }
}










