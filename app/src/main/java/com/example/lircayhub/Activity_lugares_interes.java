package com.example.lircayhub;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Activity_lugares_interes extends AppCompatActivity {

    String []nombres={"Jumbo","Lider","Santa Isabel"};
    String []precios={"Calle 30 Ote, Talca","Camino Las Rastras 1800","Av Camilo Henrique 627, Curicó"};
    int []fotos={R.drawable.jumbo,R.drawable.lider,R.drawable.santaisabel};
    RecyclerView rv_1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lugares_interes);
        rv_1=findViewById(R.id.rev1);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        rv_1.setLayoutManager(linearLayoutManager);
        rv_1.setAdapter(new AdaptadorFrutas());
    }

    private class AdaptadorFrutas extends RecyclerView.Adapter<AdaptadorFrutas.AdaptadorFrutasHolder> {

        @NonNull
        @Override
        public AdaptadorFrutasHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new AdaptadorFrutasHolder(getLayoutInflater().inflate(R.layout.itemlugaresinteres,parent,false));
        }

        @Override
        public void onBindViewHolder(@NonNull AdaptadorFrutasHolder holder, int position) {
            holder.imprimir(position);
        }

        @Override
        public int getItemCount() {
            return nombres.length;
        }

        private class AdaptadorFrutasHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
            TextView tv_1, tv_2;
            ImageView iv_1;
            public AdaptadorFrutasHolder(@NonNull View itemView) {
                super(itemView);
                iv_1=itemView.findViewById(R.id.imageView4);
                tv_1=itemView.findViewById(R.id.tv_nombre);
                tv_2=itemView.findViewById(R.id.tv_precio);
                itemView.setOnClickListener(this);
            }

            public void imprimir(int position) {
                iv_1.setImageResource(fotos[position]);
                tv_1.setText(nombres[position]);
                tv_2.setText(precios[position]);
            }

            @Override
            public void onClick(View view) {
                Toast.makeText(Activity_lugares_interes.this, nombres[getLayoutPosition()], Toast.LENGTH_SHORT).show();
            }
        }
    }
}