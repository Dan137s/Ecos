package com.claseipst51android2021cl.grupo4.Ecos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.claseipst51android2021cl.grupo4.R;
import com.claseipst51android2021cl.grupo4.Clases.Usuario;
import com.claseipst51android2021cl.grupo4.Modelo.daoUsuario;
import com.muddzdev.styleabletoast.StyleableToast;

public class MainActivityRegistro extends AppCompatActivity implements View.OnClickListener{
    EditText us, pas, nom, ap;
    Button reg;
    daoUsuario dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_registro);
        us=(EditText)findViewById(R.id.RegUser);
        pas=(EditText)findViewById(R.id.RegPass);
        nom=(EditText)findViewById(R.id.RegNombre);
        ap=(EditText)findViewById(R.id.RegApellido);
        reg=(Button)findViewById(R.id.btnRegistrar);
        reg.setOnClickListener(this);
        dao=new daoUsuario(this);
    }

    public void cancelar(View view) {
        Intent im3 = new Intent(MainActivityRegistro.this, MainActivityInicio.class);
        StyleableToast.makeText(getApplicationContext(), "Bienvenidos a Ecos",
                Toast.LENGTH_LONG, R.style.ColoredStroke).show();
        startActivity(im3);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnRegistrar:
                Usuario u=new Usuario();
                u.setUsuario(us.getText().toString());
                u.setPassword(pas.getText().toString());
                u.setNombre(nom.getText().toString());
                u.setApellidos(ap.getText().toString());
                if(!u.isNull()) {
                    StyleableToast.makeText(getApplicationContext(), "Error: Campos vacios...",
                            Toast.LENGTH_LONG, R.style.ColoredStroke).show();
                }else if (dao.insertUsuario(u)) {
                    StyleableToast.makeText(getApplicationContext(), "Registro Exitoso!",
                            Toast.LENGTH_LONG, R.style.ColoredStroke).show();
                    Intent i2 = new Intent(MainActivityRegistro.this, MainActivityLogin.class);
                    startActivity(i2);
                    finish();
                }else{
                    StyleableToast.makeText(getApplicationContext(), "Este usuario ya esta registrado!",
                            Toast.LENGTH_LONG, R.style.ColoredStroke).show();
                }
                break;
        }
    }
}