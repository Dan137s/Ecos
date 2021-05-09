package com.claseipst51android2021cl.grupo4;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.muddzdev.styleabletoast.StyleableToast;

public class MainActivityLogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_login);

        //Titulo de la aplicación o actionbar que lo centre
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.txt_titulo);
    }

    public void ingresar(View view) {
        Intent i1 = new Intent(this, MainActivitySesion.class);

        StyleableToast.makeText(getApplicationContext(), "Ingrese sus credenciales",
                Toast.LENGTH_LONG, R.style.ColoredStroke).show();

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