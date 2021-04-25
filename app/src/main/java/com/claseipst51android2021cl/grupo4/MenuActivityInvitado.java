package com.claseipst51android2021cl.grupo4;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MenuActivityInvitado extends AppCompatActivity {
    //Declaro las vbles, para usar los botones del menu_activity y llamar las sgtes act. dentro de un cardview
    CardView ubicacion, listadoeco, compartir, iniciarse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_invitado);

        //Titulo de la aplicacion o action bar que lo centre
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.txt_titulo);

        //castear referenciar las vbles con las del menu_activity por vble+id
        ubicacion = (CardView) findViewById(R.id.idcard1);
        listadoeco = (CardView) findViewById(R.id.idcard2);
        compartir = (CardView) findViewById(R.id.idcard3);
        iniciarse = (CardView) findViewById(R.id.idcard4);

        //Recordando que los CardView son las tarjetas o botones que enlazan"Botones del menú"

        //Llamo a los metodos
        getUbicacion();
        getListaEco();
        getCompartir();
        getIniciarSe();
    }

    private void getUbicacion() {
            ubicacion.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent im1 = new Intent(MenuActivityInvitado.this, MainActivityUbicacion.class);
                    Toast.makeText(getApplicationContext(), "Redirección a ubicación",
                            Toast.LENGTH_SHORT).show();
                    startActivity(im1);
                }
            });
        }

    private void getListaEco() {
            listadoeco.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent im3 = new Intent(MenuActivityInvitado.this, MainActivityListadoEco.class);
                    Toast.makeText(getApplicationContext(), "listado de ecos!",
                            Toast.LENGTH_SHORT).show();
                    startActivity(im3);
                }
            });
        }

    private void getCompartir() {
        compartir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent im3 = new Intent(MenuActivityInvitado.this, MainActivityCompartirApp.class);
                Toast.makeText(getApplicationContext(), "Ayudanos a compartir la app!",
                        Toast.LENGTH_SHORT).show();
                startActivity(im3);
            }
        });
    }

    private void getIniciarSe() {
        iniciarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent im3 = new Intent(MenuActivityInvitado.this, MainActivityLogin.class);
                Toast.makeText(getApplicationContext(), "Ayudanos a compartir la app!",
                        Toast.LENGTH_SHORT).show();
                startActivity(im3);
            }
        });
    }
    }