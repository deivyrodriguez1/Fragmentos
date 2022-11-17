package com.example.fragmentos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.Button;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {

    Button cargar1, cargar2;
    FrameLayout miMarco;
    Fragment f1, f2;
    FragmentManager miAdministrador;
    FragmentTransaction miTransaccion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        miMarco = findViewById(R.id.frameLayout);
        cargar1 = findViewById(R.id.btnCarga1);
        cargar2 = findViewById(R.id.btnCarga2);
        f1 = new Fragmento1();
        f2 = new Fragmento2();

        //Se requiere un FragmentManager
        //Se requiere un gestor de transacciones
        miAdministrador = getSupportFragmentManager();
        miTransaccion = miAdministrador.beginTransaction();
        miTransaccion.add(R.id.frameLayout, f1);
        miTransaccion.commit();

        cargar1.setOnClickListener(
                (v)->{
                    miTransaccion = miAdministrador.beginTransaction();
                    miTransaccion.replace(R.id.frameLayout, f1);
                    miTransaccion.commit();
                }
        );

        cargar2.setOnClickListener(
                (v)->{
                    miTransaccion = miAdministrador.beginTransaction();
                    miTransaccion.replace(R.id.frameLayout, f2);
                    miTransaccion.commit();
                }
        );
    }
}