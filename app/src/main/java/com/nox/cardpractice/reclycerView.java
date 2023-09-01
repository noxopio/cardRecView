package com.nox.cardpractice;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class reclycerView extends AppCompatActivity {


    RecyclerView lista;
    LinearLayoutManager contenedor;
    String[] nombres = {"Manzana", "Fresa", "Kiwi", "Naranja", "Mango"};
    int[] precios = {2500, 6800, 9100, 4200, 3750};

    int[] imagenes = {R.drawable.manzana, R.drawable.fresa, R.drawable.kiwi, R.drawable.naranja, R.drawable.mango};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reclycer_view);
        lista = findViewById(R.id.lerList);
        contenedor = new LinearLayoutManager(this);
        lista.setLayoutManager(contenedor);
        lista.setAdapter(new FrutasAdapter());
    }

    private class FrutasAdapter extends RecyclerView.Adapter<FrutasAdapterHolder> {


        @NonNull
        @Override
        public FrutasAdapterHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new FrutasAdapterHolder(getLayoutInflater().inflate(R.layout.tarjeta_frutas,parent,false));
        }

        @Override
        public void onBindViewHolder(@NonNull FrutasAdapterHolder holder, int position) {
            holder.imprimir(position);

        }

        @Override
        public int getItemCount() {
            return nombres.length;
        }
    }

    private class FrutasAdapterHolder extends RecyclerView.ViewHolder {
        ImageView imagen;
        TextView nombre, precio;

        public FrutasAdapterHolder(@NonNull View itemView) {
            super(itemView);
            imagen = itemView.findViewById(R.id.foto);
            nombre = itemView.findViewById(R.id.nombre);
            precio = itemView.findViewById(R.id.precio);

        }

        public void imprimir(int position) {
            imagen.setImageResource(imagenes[position]);

            nombre.setText(nombres[position]);
            precio.setText(String.valueOf(precios[position]));
        }
    }
}