package com.claseipst51android2021cl.grupo4;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivityRegistrarse extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_registrarse);

        //Titulo de la aplicacion o action bar que lo centre
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.txt_titulo);
    }
    public void ingresar(View view) {
        Intent i1 = new Intent(this, MainActivitySesion.class);
        Toast.makeText(getApplicationContext(), "Usuario registrado",
                Toast.LENGTH_SHORT).show();
        startActivity(i1);
    }
    public void regresar(View view){
        Intent i2 = new Intent(this, MainActivityLogin.class);
        Toast.makeText(getApplicationContext(), "Back inicio",
                Toast.LENGTH_SHORT).show();
        startActivity(i2);
    }
}