package com.theradikalsoftware.week4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MascotasAdapter extends RecyclerView.Adapter<MyViewHolder> {
    private ArrayList<MascotasData> arrayMascotas = new ArrayList<>();
    private MascotasData mascotasData;

    public MascotasAdapter(){
        mascotasData = new MascotasData();
        mascotasData.nombre = "Pretty";
        mascotasData.ranking = 0;
        arrayMascotas.add(mascotasData);

        mascotasData = new MascotasData();
        mascotasData.nombre = "Terry";
        mascotasData.ranking = 0;
        arrayMascotas.add(mascotasData);

        mascotasData = new MascotasData();
        mascotasData.nombre = "Cokis";
        mascotasData.ranking = 0;
        arrayMascotas.add(mascotasData);

        mascotasData = new MascotasData();
        mascotasData.nombre = "Blacky";
        mascotasData.ranking = 0;
        arrayMascotas.add(mascotasData);

        mascotasData = new MascotasData();
        mascotasData.nombre = "Tom";
        mascotasData.ranking = 0;
        arrayMascotas.add(mascotasData);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_items, parent, false);

        return new MyViewHolder(v, parent.getContext(), arrayMascotas);
    }


    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.mascotaNombreTXV.setText(arrayMascotas.get(position).getNombre());
        holder.mascotaRankingTXV.setText(arrayMascotas.get(position).getRanking());
    }

    @Override
    public int getItemCount() {
        return arrayMascotas.size();
    }
}

class MyViewHolder extends RecyclerView.ViewHolder{
    public CardView mascotaCardview;
    public TextView mascotaNombreTXV, mascotaRankingTXV;
    public ImageView huesoLikeIMV;

    public MyViewHolder(@NonNull View itemView, final Context context, final ArrayList<MascotasData> arrayMascotas) {
        super(itemView);
        mascotaCardview = itemView.findViewById(R.id.rec_item_cardview);
        mascotaNombreTXV = itemView.findViewById(R.id.rec_item_textview_mascota_name);
        mascotaRankingTXV = itemView.findViewById(R.id.rec_item_textview_ranking);
        huesoLikeIMV = itemView.findViewById(R.id.rec_item_imageview_hueso_like);
        huesoLikeIMV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "Diste like a " + arrayMascotas.get(getAdapterPosition()).getNombre(), Toast.LENGTH_SHORT).show();
                int antRanking = Integer.parseInt(arrayMascotas.get(getAdapterPosition()).getRanking());
                arrayMascotas.get(getAdapterPosition()).setRanking(antRanking + 1);
            }
        });
    }
}
