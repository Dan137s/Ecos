package com.claseipst51android2021cl.grupo4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.muddzdev.styleabletoast.StyleableToast;

import java.util.HashMap;
import java.util.Map;

public class MainActivityResgistroUser extends AppCompatActivity {
    //Variables de los campos nombre, correo y contraseña
    private EditText mEditTextName;
    private EditText mEditTextEmail;
    private EditText mEditTextPassword;

    //Objeto button para registrar
    private Button mButtonRegister;

    //Variable de los datos a registrar
    private String name = "";
    private String email = "";
    private String password = "";

    FirebaseAuth mAuth;
    DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_resgistro_user);

        //Titulo de la aplicacion o action bar que lo centre
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.txt_titulo);

        //Creando la instancia con la variable de firebase
        mAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference();

        //Casteo de las variables
        mEditTextName = (EditText) findViewById(R.id.edtNombre);
        mEditTextEmail = (EditText) findViewById(R.id.edtEmail);
        mEditTextPassword = (EditText) findViewById(R.id.edtPassword);
        mButtonRegister = (Button) findViewById(R.id.btnRegistroUser);

        //Evento onclick cuando el usuario presione el boton registrarse
        mButtonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name = mEditTextName.getText().toString();
                email = mEditTextEmail.getText().toString();
                password = mEditTextPassword.getText().toString();

                //Validacion de los valores no esten vacios
                if (!name.isEmpty()&& !email.isEmpty() && !password.isEmpty()){

                    //Esta validación es por que firebase exige 6 caracteres como minimo en la password
                    if(password.length() >= 6){
                        registerUser();
                    }
                    else{
                        StyleableToast.makeText(getApplicationContext(), "El password debe tener al menos 6 caracteres",
                                Toast.LENGTH_LONG, R.style.ColoredStroke).show();

                    }
                }
                else {
                    StyleableToast.makeText(getApplicationContext(), "Debe completar los campos",
                            Toast.LENGTH_LONG, R.style.ColoredStroke).show();
                }

            }
        });

        //Flecha atras
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    //Metodo para volver atras de la flechita back
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void registerUser(){
        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    //Creo el mapa de valores
                    Map<String, Object> map = new HashMap<>();
                    map.put("name", name);
                    map.put("name", email);
                    map.put("name", password);

                    String id = mAuth.getCurrentUser().getUid();
                    //Creo un nodo dentro de firebase "hijo" llamado users para guardar los usuarios registrados y paso el map de valores
                    mDatabase.child("Users").child(id).setValue(map).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task2) {
                            if (task2.isSuccessful()){
                                startActivity(new Intent(MainActivityResgistroUser.this, MainActivityInicio.class));
                                finish();
                                StyleableToast.makeText(getApplicationContext(), "Usuario Registrado",
                                        Toast.LENGTH_LONG, R.style.ColoredStroke).show();
                            }
                            else{
                                StyleableToast.makeText(getApplicationContext(), "No se puedieron crear los datos correctamente!",
                                        Toast.LENGTH_LONG, R.style.ColoredStroke).show();
                            }
                        }
                    });
                }
                else{
                    StyleableToast.makeText(getApplicationContext(), "No se pudo registrar este usuario",
                            Toast.LENGTH_LONG, R.style.ColoredStroke).show();

                }
            }
        });
    }
}