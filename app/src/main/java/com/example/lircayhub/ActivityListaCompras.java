package com.example.lircayhub;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ActivityListaCompras extends AppCompatActivity {
    String []nombres={"Queso 500gr","Palta 1kg","Tomate 1kg","Yogurt x8","Manzana 1kg"};
    int []precios={5000,4800,1800,1500,1600};
    int []fotos={R.drawable.queso,R.drawable.palta,R.drawable.tomate,R.drawable.yogurt,R.drawable.manzana};
    RecyclerView rv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_compras);
        rv1=findViewById(R.id.rv1);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        rv1.setLayoutManager(linearLayoutManager);
        rv1.setAdapter(new AdaptadorFrutas());
    }

    private class AdaptadorFrutas extends RecyclerView.Adapter<AdaptadorFrutas.AdaptadorFrutasHolder> {

        @NonNull
        @Override
        public AdaptadorFrutasHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new AdaptadorFrutasHolder(getLayoutInflater().inflate(R.layout.itempersona,parent,false));
        }

        @Override
        public void onBindViewHolder(@NonNull AdaptadorFrutasHolder holder, int position) {
            holder.imprimir(position);
        }

        @Override
        public int getItemCount() {
            return nombres.length;
        }

        private class AdaptadorFrutasHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
            TextView tv1,tv2;
            ImageView iv1;
            public AdaptadorFrutasHolder(@NonNull View itemView) {
                super(itemView);
                iv1=itemView.findViewById(R.id.imageView);
                tv1=itemView.findViewById(R.id.tv_nombre);
                tv2=itemView.findViewById(R.id.tv_precio);
                itemView.setOnClickListener(this);
            }

            public void imprimir(int position) {
                iv1.setImageResource(fotos[position]);
                tv1.setText(nombres[position]);
                tv2.setText(String.valueOf(precios[position]));
            }

            @Override
            public void onClick(View view) {
                Toast.makeText(ActivityListaCompras.this, nombres[getLayoutPosition()], Toast.LENGTH_SHORT).show();

            }
        }
    }
    }