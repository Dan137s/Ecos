package com.claseipst51android2021cl.grupo4;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivitySesion extends AppCompatActivity {
    //Son los campos de correo y contraseña para post validar
    EditText CampoCorreo, CampoContraseña;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_sesion);

        //Titulo de la aplicacion o action bar que lo centre
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.txt_titulo);

        //Parsear los campos con el id correspondiente
        CampoCorreo = (EditText) findViewById(R.id.txtCorreoSesion);
        CampoContraseña = (EditText) findViewById(R.id.txtContraseñaSesion);
    }



    //Cree 2 variables para devolver un verdadero o falso con la cadena de texto dentro de un if
    public boolean validar() {
        boolean retorno = true;
        String c1 = CampoCorreo.getText().toString();
        String c2 = CampoContraseña.getText().toString();
        if(c1.isEmpty())
        {
            CampoCorreo.setError("El campo correo no debe estar vacio");
            retorno=false;
        }
        if(c2.isEmpty())
        {
            CampoContraseña.setError("El campo contraseña no debe estar vacio");
            retorno=false;
        }
        return retorno;
    }


    //Btn ingresar y volver el btn ingresar valida y ejecuta mediante el boton el metodo validar
    public void ingresar(View v)
    {
        if(validar())
        {
            Intent is1 = new Intent(this, MenuActivity.class);
            Toast.makeText(getApplicationContext(), "Bienvenidos a ecos",
                    Toast.LENGTH_SHORT).show();
            startActivity(is1);
        }
    }
    //Este me devuelve a la pestaña anterior osea al inicio
    public void regresar(View view){
        Intent is2 = new Intent(this, MainActivityInicio.class);
        Toast.makeText(getApplicationContext(), "Back inicio",
                Toast.LENGTH_SHORT).show();
        startActivity(is2);
    }
}

















