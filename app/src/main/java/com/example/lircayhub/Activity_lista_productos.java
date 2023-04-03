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

public class Activity_lista_productos extends AppCompatActivity {

    String []nombres={"TV '50","Sillon","Cocina","Refrigerador","Escritorio"};
    int []precios={300000,150000,200000,250000,150000};
    int []fotos={R.drawable.tv,R.drawable.sillon,R.drawable.cocina,R.drawable.refrigerador,R.drawable.escritorio};
    RecyclerView recv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_productos);
        recv1=findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        recv1.setLayoutManager(linearLayoutManager);
        recv1.setAdapter(new AdaptadorFrutas());
    }

    private class AdaptadorFrutas extends RecyclerView.Adapter<AdaptadorFrutas.AdaptadorFrutasHolder> {
        @NonNull
        @Override
        public AdaptadorFrutas.AdaptadorFrutasHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new AdaptadorFrutas.AdaptadorFrutasHolder(getLayoutInflater().inflate(R.layout.itemlistaproductos,parent,false));
        }

        @Override
        public void onBindViewHolder(@NonNull AdaptadorFrutas.AdaptadorFrutasHolder holder, int position) {
            holder.imprimir(position);
        }

        @Override
        public int getItemCount() {
            return nombres.length;
        }

        private class AdaptadorFrutasHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
            TextView tvw_1, tvw_2;
            ImageView ivw_1;
            public AdaptadorFrutasHolder(@NonNull View itemView) {
                super(itemView);
                ivw_1=itemView.findViewById(R.id.imageView3);
                tvw_1=itemView.findViewById(R.id.tv_5);
                tvw_2=itemView.findViewById(R.id.tv_6);
                itemView.setOnClickListener(this);
            }

            public void imprimir(int position) {
                ivw_1.setImageResource(fotos[position]);
                tvw_1.setText(nombres[position]);
                tvw_2.setText(String.valueOf(precios[position]));
            }

            @Override
            public void onClick(View view) {
                Toast.makeText(Activity_lista_productos.this, nombres[getLayoutPosition()], Toast.LENGTH_SHORT).show();
            }
        }
    }
}