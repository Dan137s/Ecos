package com.claseipst51android2021cl.grupo4.Ecos;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.claseipst51android2021cl.grupo4.Clases.Usuario;
import com.claseipst51android2021cl.grupo4.Ecos.MenuActivity;
import com.claseipst51android2021cl.grupo4.Modelo.daoUsuario;
import com.claseipst51android2021cl.grupo4.R;
import com.muddzdev.styleabletoast.StyleableToast;

public class MainActivityConverteEco extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_converte_eco);

        //Titulo de la aplicacion o action bar que lo centre
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.txt_titulo);

        //Flecha volver
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void toastmsj(View view) {
        StyleableToast.makeText(getApplicationContext(), "Proximamente aun no disponible",
                Toast.LENGTH_LONG, R.style.ColoredStroke).show();

    }

}