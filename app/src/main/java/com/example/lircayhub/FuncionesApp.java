package com.example.lircayhub;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FuncionesApp extends AppCompatActivity {

    Button listaCompras;
    Button lugaresInteres;
    Button listaProductos;
    Button inventarioProductos;
    Button recordatorios;
    Button cerrarSesion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_funciones_app);
        listaCompras=(Button)findViewById(R.id.botonListaCompras);
        lugaresInteres=(Button)findViewById(R.id.button_lugares_interes);
        listaProductos=(Button)findViewById(R.id.button_lista_productos);
        inventarioProductos=(Button)findViewById(R.id.button_inventario_productos);
        recordatorios=(Button)findViewById(R.id.button_recordatorios);
        cerrarSesion=(Button)findViewById(R.id.buttonLogout);

        listaCompras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent botonListaCompras = new Intent(FuncionesApp.this, ActivityListaCompras.class);
                startActivity(botonListaCompras);
            }
        });

        lugaresInteres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent botonlugaresInteres = new Intent(FuncionesApp.this, Activity_lugares_interes.class);
                startActivity(botonlugaresInteres);
            }
        });

        listaProductos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent botonlistaProductos = new Intent(FuncionesApp.this, Activity_lista_productos.class);
                startActivity(botonlistaProductos);
            }
        });

        inventarioProductos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent botoninventarioProductos = new Intent(FuncionesApp.this, Activity_inventario_productos.class);
                startActivity(botoninventarioProductos);
            }
        });

        recordatorios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent botonrecordatorios = new Intent(FuncionesApp.this, Activity_recordatorios.class);
                startActivity(botonrecordatorios);
            }
        });

        cerrarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent botoncerrarSesion = new Intent(FuncionesApp.this, MainActivity.class);
                startActivity(botoncerrarSesion);
            }
        });

    }
}