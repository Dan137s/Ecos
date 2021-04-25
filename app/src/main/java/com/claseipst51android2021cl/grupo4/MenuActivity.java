package com.claseipst51android2021cl.grupo4;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MenuActivity extends AppCompatActivity {
    //Declaro las vbles, para usar los botones del menu_activity y llamar las sgtes act. dentro de un cardview
    CardView creaeco, listadoeco, ubicacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        //Titulo de la aplicacion o action bar que lo centre
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.txt_titulo);

        //castear referenciar las vbles con las del menu_activity por vble+id
        creaeco = (CardView) findViewById(R.id.idcard1);
        listadoeco = (CardView) findViewById(R.id.idcard3);
        ubicacion = (CardView) findViewById(R.id.idcard4);

        //llamamos metodos que contiene cardview
        getCreaEco();
    }

    //Inicio metodo crea eco
    private void getCreaEco() {
        creaeco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1 = new Intent(MenuActivity.this, MainActivityCreaEco.class);
                startActivity(i1);
            }
        });
    }
    //Fin del metodo crea eco

}