package com.claseipst51android2021cl.grupo4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivityLogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_login);
    }

    public void ingresar(View view) {
        Intent i1 = new Intent(this, MainActivitySesion.class);
        Toast.makeText(getApplicationContext(), "Ingrese sus credenciales",
                Toast.LENGTH_SHORT).show();
        startActivity(i1);

    }

    public void registrar(View view) {
        Intent i2 = new Intent(this, MainActivityRegistrarse.class);

        startActivity(i2);

    }

    public void invitado(View view) {
        Intent i3 = new Intent(this, MenuActivityInvitado.class);
        startActivity(i3);
    }
}