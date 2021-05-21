package com.claseipst51android2021cl.grupo4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.muddzdev.styleabletoast.StyleableToast;
import com.skydoves.elasticviews.ElasticCheckButton;
import com.skydoves.elasticviews.ElasticFinishListener;

public class MainActivityRestablecerClave extends AppCompatActivity {
    private TextInputEditText gmail;
    private String correo;
    private ElasticCheckButton recuperar;
    private ProgressDialog progress;
    FirebaseAuth auth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_restablecer_clave);

        //Titulo de la aplicacion o action bar que lo centre
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.txt_titulo);

        //Flecha volver
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Casteo
        gmail = findViewById(R.id.gmail);
        recuperar = findViewById(R.id.btnRecuperar);

        //Instancia a firebase
        auth = FirebaseAuth.getInstance();
        progress = new ProgressDialog(this);
        getRecuperar();

    }
    //Metodo para recuperar contraseña al correo solicitado
    private void getRecuperar() {
        recuperar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                correo = gmail.getText().toString().trim();
                if(!correo.isEmpty()){
                    progress.setMessage("Espere un momento...");
                    progress.setCanceledOnTouchOutside(false);
                    progress.show();
                    getEnviarCorreo();
                }else
                    {
                        StyleableToast.makeText(getApplicationContext(), "El correo no se pudo enviar",
                                Toast.LENGTH_LONG, R.style.ColoredStroke).show();

                }
            }
        });
    }

    private void getEnviarCorreo(){
        auth.setLanguageCode("es");
        auth.sendPasswordResetEmail(correo).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful()) {
                    StyleableToast.makeText(getApplicationContext(), "Verifique su correo para restablecer contraseña",
                            Toast.LENGTH_LONG, R.style.ColoredStroke).show();
                    Intent i = new Intent(MainActivityRestablecerClave.this, MainActivityAdmin.class);
                    startActivity(i);
                    finish();
                }else{
                    StyleableToast.makeText(getApplicationContext(), "No se pudo enviar el correo",
                            Toast.LENGTH_LONG, R.style.ColoredStroke).show();
                }
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