package com.example.lircayhub;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.lircayhub.db.DbProductos;

public class lista_productos_db extends AppCompatActivity {

    EditText txtNombre, txtPrecio, txtCategoria;
    Button btnAgregar;

    Spinner scategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_productos_db);

        txtNombre = findViewById(R.id.txtNombre);
        txtPrecio = findViewById(R.id.txtPrecio);
        txtCategoria = findViewById(R.id.txtCategoria);
        scategory = findViewById(R.id.scategory);
        btnAgregar = findViewById(R.id.btnAgregar);
        scategory.setSelection(0);

        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DbProductos dbProductos = new DbProductos(lista_productos_db.this);
                long id = dbProductos.insertarProducto(txtNombre.getText().toString(), txtPrecio.getText().toString(), txtCategoria.getText().toString());

                if (id > 0){
                    Toast.makeText(lista_productos_db.this, "REGISTRO GUARDADO", Toast.LENGTH_SHORT).show();
                    limpiar();
                } else {
                    Toast.makeText(lista_productos_db.this, "ERROR AL GUARDAR REGISTRO", Toast.LENGTH_SHORT).show();

                }

            }
        });

    }

    private void limpiar(){
        txtNombre.setText("");
        txtPrecio.setText("");
        txtCategoria.setText("");
    }
}