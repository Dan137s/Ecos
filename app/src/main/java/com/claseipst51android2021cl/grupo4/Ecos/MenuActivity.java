package com.claseipst51android2021cl.grupo4.Ecos;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.claseipst51android2021cl.grupo4.R;
import com.claseipst51android2021cl.grupo4.Clases.Usuario;
import com.claseipst51android2021cl.grupo4.Modelo.daoUsuario;
import com.muddzdev.styleabletoast.StyleableToast;

public class MenuActivity extends AppCompatActivity {
    //Declaro las vbles, para usar los botones del menu_activity y llamar las sgtes act. dentro de un cardview
    CardView creaeco, listadoeco, ubicacion, cerrar;
    TextView nombre;
    int id=0;
    Usuario u;
    daoUsuario dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        nombre=(TextView)findViewById(R.id.nombrU);

        //Titulo de la aplicacion o action bar que lo centre
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.txt_titulo);

        //castear referenciar las vbles con las del menu_activity por vble+id
        creaeco = (CardView) findViewById(R.id.idcard1);
        cerrar = (CardView) findViewById(R.id.idcard2);
        listadoeco = (CardView) findViewById(R.id.idcard3);
        ubicacion = (CardView) findViewById(R.id.idcard4);

        //llamamos metodos que contiene cardview
        getCreaEco();
        getCerrarSesion();
        getListaEco();
        getUbicacion();

        Bundle b=getIntent().getExtras();
        id=b.getInt("id");
        dao=new daoUsuario(this);
        u=dao.getUsuarioById(id);
        nombre.setText("Usuario: "+u.getNombre()+" "+u.getApellidos());


    }

    public void converter(View view) {
        Intent im3 = new Intent(MenuActivity.this, MainActivityConverteEco.class);
        StyleableToast.makeText(getApplicationContext(), "Proximamente aun no disponible",
                Toast.LENGTH_LONG, R.style.ColoredStroke).show();
        startActivity(im3);
    }

    //Inicio metodo crea eco
    private void getCreaEco() {
        creaeco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent im1 = new Intent(MenuActivity.this, MainActivityGrabadora1.class);
                StyleableToast.makeText(getApplicationContext(), "Presione el boton para grabar",
                        Toast.LENGTH_LONG, R.style.ColoredStroke).show();
                startActivity(im1);
            }
        });
    }
    //Fin del metodo crea eco

    //Inicio metodo cerrar sesion
    private void getCerrarSesion() {
        cerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent im2 = new Intent(MenuActivity.this, MainActivityInicio.class);
                StyleableToast.makeText(getApplicationContext(), "Re-direccion al home",
                        Toast.LENGTH_LONG, R.style.ColoredStroke).show();
                startActivity(im2);
                finish();
            }
        });
    }
    //Fin del metodo


    //Inicio metodo
    private void getListaEco() {
        listadoeco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent im3 = new Intent(MenuActivity.this, MainActivityListadoEco.class);
                StyleableToast.makeText(getApplicationContext(), "Lista de ecos",
                        Toast.LENGTH_LONG, R.style.ColoredStroke).show();
                startActivity(im3);
            }
        });
    }

    //Inicio metodo
    private void getUbicacion() {
        ubicacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent im4 = new Intent(MenuActivity.this, MainActivityUbicacion.class);
                StyleableToast.makeText(getApplicationContext(), "Re-direcci??n a ubicaci??n",
                        Toast.LENGTH_LONG, R.style.ColoredStroke).show();
                startActivity(im4);
            }
        });
    }
    //Fin metodo
}
