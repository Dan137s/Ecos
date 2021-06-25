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

public class MainActivityLogin extends AppCompatActivity implements View.OnClickListener {
    EditText user, pass;
    Button btnEntrar;
    daoUsuario dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_login);

        user=(EditText)findViewById(R.id.User);
        pass=(EditText)findViewById(R.id.Pass);
        btnEntrar=(Button)findViewById(R.id.btnEntrar);

        btnEntrar.setOnClickListener(this);
        dao=new daoUsuario(this);
    }
    public void registrarv(View view) {
        Intent i2 = new Intent(this, MainActivityRegistro.class);
        startActivity(i2);

    }
    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.btnEntrar:
                String u=user.getText().toString();
                String p=pass.getText().toString();
                if(u.equals("")&&p.equals("")){
                    StyleableToast.makeText(getApplicationContext(), "Ingrese sus {{credenciales}} correctamente",
                            Toast.LENGTH_LONG, R.style.ColoredStroke).show();
                }else if(dao.login(u,p)==1) {
                    Usuario ux = dao.getUsuario(u, p);

                    StyleableToast.makeText(getApplicationContext(), "Hola... Listo para crear tus ecos?",
                            Toast.LENGTH_LONG, R.style.ColoredStroke).show();
                    Intent i2 = new Intent(MainActivityLogin.this, MenuActivity.class);
                    i2.putExtra("id", ux.getId());
                    startActivity(i2);
                    finish();
                }else{
                    StyleableToast.makeText(getApplicationContext(), "Credenciales incorrectas",
                            Toast.LENGTH_LONG, R.style.ColoredStroke).show();
                }
                break;

        }

    }

}