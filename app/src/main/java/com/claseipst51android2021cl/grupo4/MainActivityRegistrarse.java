package com.claseipst51android2021cl.grupo4;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivityRegistrarse extends AppCompatActivity {
    //Son los campos de registro nombre, correo y contraseña para post validar
    EditText CampoNombre, CampoCorreo, CampoContraseña;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_registrarse);

        //Titulo de la aplicacion o action bar que lo centre
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.txt_titulo);

        //Parsear los campos con el id correspondiente
        CampoNombre =(EditText) findViewById(R.id.txtNombreRegistrese);
        CampoCorreo = (EditText) findViewById(R.id.txtCorreoRegistrese);
        CampoContraseña = (EditText) findViewById(R.id.txtContraseñaRegistrese);
    }

    //Cree 3 variables para devolver un verdadero o falso con la cadena de texto dentro de un if en los campos
    public boolean validarR() {
        boolean retorno = true;
        String c1 = CampoNombre.getText().toString();
        String c2 = CampoCorreo.getText().toString();
        String c3 = CampoContraseña.getText().toString();
        if(c1.isEmpty())
        {
            CampoNombre.setError("El campo nombre no debe estar vacio");
            retorno=false;
        }
        if(c2.isEmpty())
        {
            CampoCorreo.setError("El campo correo no debe estar vacio");
            retorno=false;
        }
        if(c3.isEmpty())
        {
            CampoContraseña.setError("El campo contraseña no debe estar vacio");
            retorno=false;
        }
        return retorno;
    }

    //Btn ingresar y volver el btn ingresar valida y ejecuta mediante el boton el metodo validar
    public void ingresar(View v)
    {
        if(validarR())
        {
            Intent i1 = new Intent(this, MainActivitySesion.class);
            Toast.makeText(getApplicationContext(), "Usuario registrado",
                    Toast.LENGTH_SHORT).show();
            startActivity(i1);
        }
    }
    // btn volver me regresa hasta login
    public void regresar(View view){
        Intent i2 = new Intent(this, MainActivityLogin.class);
        Toast.makeText(getApplicationContext(), "Back inicio",
                Toast.LENGTH_SHORT).show();
        startActivity(i2);
    }
}