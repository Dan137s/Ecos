package com.claseipst51android2021cl.grupo4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.skydoves.elasticviews.ElasticCheckButton;

public class MainActivityAdmin extends AppCompatActivity {
    //Variables
    ElasticCheckButton recuperar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_admin);
        //Titulo de la aplicacion o action bar que lo centre
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.txt_titulo);

        //Flecha volver
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recuperar=(ElasticCheckButton) findViewById(R.id.btnRContraseña);
        getRecuperar();
    }

    //Metodo para el boton recuperar contraseña
    private void getRecuperar() {
        recuperar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivityAdmin.this, MainActivityRestablecerClave.class);
                Toast.makeText(getApplicationContext(), "Restablece tu clave",
                        Toast.LENGTH_SHORT).show();
                startActivity(i);
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
}