package com.claseipst51android2021cl.grupo4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.claseipst51android2021cl.grupo4.Clases.Usuario;
import com.claseipst51android2021cl.grupo4.Ecos.MenuActivity;
import com.claseipst51android2021cl.grupo4.Modelo.daoUsuario;

public class MainActivityLogin extends AppCompatActivity implements View.OnClickListener {
    EditText user, pass;
    Button btnEntrar, btnRegistrar;
    daoUsuario dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_login);

        user=(EditText)findViewById(R.id.User);
        pass=(EditText)findViewById(R.id.Pass);
        btnEntrar=(Button)findViewById(R.id.btnEntrar);
        btnRegistrar=(Button)findViewById(R.id.btnRegistrar);
        btnEntrar.setOnClickListener(this);
        btnRegistrar.setOnClickListener(this);
        dao=new daoUsuario(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.btnEntrar:
                String u=user.getText().toString();
                String p=pass.getText().toString();
                if(u.equals("")&&p.equals("")){
                    Toast.makeText(this, "Error: Campos vacios", Toast.LENGTH_LONG).show();
                }else if(dao.login(u,p)==1) {
                    Usuario ux = dao.getUsuario(u, p);
                    Toast.makeText(this, "Datos correctos", Toast.LENGTH_LONG).show();
                    Intent i2 = new Intent(MainActivityLogin.this, MenuActivity.class);
                    i2.putExtra("id", ux.getId());
                    startActivity(i2);
                    finish();
                }else{
                    Toast.makeText(this, "Credenciales incorrectas", Toast.LENGTH_LONG).show();

                }
                break;

            case R.id.btnRegistrar:
                Intent i = new Intent(MainActivityLogin.this, MainActivityRegistro.class);
                startActivity(i);
                break;

        }

    }
}



















