package com.claseipst51android2021cl.grupo4;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.view.WindowManager;

//En esta activity es la principal donde empieza con un splash screen
public class MainActivity extends AppCompatActivity {
    //Tiempo de duración del gift
    private final int DURACION_SPLASH = 5000;

    //Crear una alerta para conectar el "wifi" internet
    AlertDialog alertaINT = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Titulo de la aplicacion o action bar que lo centre
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.txt_titulo);


        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSplash();
        getAlertaNotInternet();
    }
    private void getAlertaNotInternet() {

        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Hola bienvenid@s a ecos. Revisar tu conexion a internet?")
                .setCancelable(false)
                .setIcon(R.drawable.iconturist)
                .setTitle("Wifi")
                .setPositiveButton("Si", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(@SuppressWarnings("unused") final DialogInterface dialog, @SuppressWarnings("unused") final int id) {
                        startActivity(new Intent(Settings.ACTION_WIFI_SETTINGS));
                    }
                }).setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(final DialogInterface dialog, @SuppressWarnings("unused") final int id) {
                dialog.cancel();

            }
        });
        alertaINT = builder.create();
        alertaINT.show();

    }
//Este es el metodo para pasar del splash screen a la parte login
    private void getSplash() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i1 = new Intent(MainActivity.this, MenuActivityInvitado.class);
                startActivity(i1);
                finish();
            }
        }, DURACION_SPLASH);
    }
}





















