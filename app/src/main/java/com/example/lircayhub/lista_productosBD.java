package com.example.lircayhub;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.SearchView;
import android.widget.Toast;

import com.example.lircayhub.adaptadores.ListaProductosAdapter;
import com.example.lircayhub.db.DbHelper;
import com.example.lircayhub.db.DbProductos;
import com.example.lircayhub.entidades.Productos;

import java.util.ArrayList;

public class lista_productosBD extends AppCompatActivity implements SearchView.OnQueryTextListener {

    SearchView txtBuscar;
    RecyclerView listaProductos;
    ArrayList<Productos> listaArrayProductos;
    ListaProductosAdapter adapter;

    Button btnAgregarProducto;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_productos_bd);
        listaProductos = findViewById(R.id.listaProductos);
        txtBuscar = findViewById(R.id.txtBuscar);

        listaProductos.setLayoutManager(new LinearLayoutManager(this));
        btnAgregarProducto = findViewById(R.id.btnAgregarProducto);

        btnAgregarProducto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent btnAgregarProducto = new Intent(lista_productosBD.this, lista_productos_db.class);
                startActivity(btnAgregarProducto);
            }
        });

        DbProductos dbProductos = new DbProductos(lista_productosBD.this);

        listaArrayProductos = new ArrayList<>();

        adapter = new ListaProductosAdapter(dbProductos.mostrarProductos());
        listaProductos.setAdapter(adapter);

        txtBuscar.setOnQueryTextListener(this);
    }

    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_principal, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.menuNuevo:
                nuevoRegistro();
                return true;

            default:
                return super.onOptionsItemSelected(item);

        }
    }

    private void nuevoRegistro(){
        Intent intent = new Intent(this,  lista_productos_db.class);
        startActivity(intent);
    }

    @Override
    public boolean onQueryTextSubmit(String s) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String s) {
        adapter.filtrado(s);
        return false;
    }
}