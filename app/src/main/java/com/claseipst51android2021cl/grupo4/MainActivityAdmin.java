package com.claseipst51android2021cl.grupo4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.muddzdev.styleabletoast.StyleableToast;
import com.skydoves.elasticviews.ElasticCheckButton;

import dmax.dialog.SpotsDialog;

public class MainActivityAdmin extends AppCompatActivity {
    //Variables
    ElasticCheckButton recuperar, btnIn;
    TextInputEditText gmail, password;
    private FirebaseAuth mAuth;
    AlertDialog alerta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_admin);
        //Titulo de la aplicacion o action bar que lo centre
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.txt_titulo);


        mAuth = FirebaseAuth.getInstance();
        recuperar=(ElasticCheckButton) findViewById(R.id.btnRContraseña);
        btnIn=(ElasticCheckButton) findViewById(R.id.btnIn);

        gmail=findViewById(R.id.gmail);
        password=findViewById(R.id.password);

        alerta = new SpotsDialog.Builder().setContext(MainActivityAdmin.this).setMessage("Por favor espera...").build();

        getRecuperar();
        loginAdmin();
        limpiar();
    }

    private void limpiar() {
        gmail.setText("");
        password.setText("");
    }

    private void loginAdmin() {
        btnIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userE = gmail.getText().toString().trim();
                String passE = password.getText().toString().trim();
                if(TextUtils.isEmpty(userE)){
                    StyleableToast.makeText(getApplicationContext(), "Ingrese un usuario",
                            Toast.LENGTH_LONG, R.style.ColoredStroke).show();
                }else if(TextUtils.isEmpty(passE)){
                    StyleableToast.makeText(getApplicationContext(), "Ingrese una contraseña",
                        Toast.LENGTH_LONG, R.style.ColoredStroke).show();
                }else{
                    alerta.show();
                    mAuth.signInWithEmailAndPassword(userE, passE)
                            .addOnCompleteListener(MainActivityAdmin.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if(!task.isSuccessful()){
                                        StyleableToast.makeText(getApplicationContext(), "Credenciales erroneas",
                                                Toast.LENGTH_LONG, R.style.ColoredStroke).show();
                                    }else{
                                        limpiar();
                                        Intent i = new Intent(MainActivityAdmin.this, MenuActivity.class);
                                        startActivity(i);
                                    }
                                    alerta.dismiss();
                                }
                            });
                }
            }
        });
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



    public void invitado(View view) {
        Intent i3 = new Intent(this, MainActivityInicio.class);
        startActivity(i3);
    }
}