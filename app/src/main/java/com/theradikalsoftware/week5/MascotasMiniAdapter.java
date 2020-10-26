package com.theradikalsoftware.week5;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MascotasMiniAdapter extends RecyclerView.Adapter<MyMiniViewHolder> {
    private ArrayList<MascotasData> arrayMascotas = new ArrayList<>();
    private MascotasData mascotasData;

    public MascotasMiniAdapter(){
        mascotasData = new MascotasData();
        mascotasData.ranking = 10;
        arrayMascotas.add(mascotasData);

        mascotasData = new MascotasData();
        mascotasData.ranking = 9;
        arrayMascotas.add(mascotasData);

        mascotasData = new MascotasData();
        mascotasData.ranking = 0;
        arrayMascotas.add(mascotasData);

        mascotasData = new MascotasData();
        mascotasData.ranking = 8;
        arrayMascotas.add(mascotasData);

        mascotasData = new MascotasData();
        mascotasData.ranking = 3;
        arrayMascotas.add(mascotasData);

        mascotasData = new MascotasData();
        mascotasData.ranking = 0;
        arrayMascotas.add(mascotasData);

        mascotasData = new MascotasData();
        mascotasData.ranking = 0;
        arrayMascotas.add(mascotasData);
    }

    @NonNull
    @Override
    public MyMiniViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_items_mini, parent, false);

        return new MyMiniViewHolder(v, parent.getContext(), arrayMascotas);
    }


    @Override
    public void onBindViewHolder(@NonNull MyMiniViewHolder holder, int position) {
        holder.mascotaRankingTXV.setText(arrayMascotas.get(position).getRanking());
    }

    @Override
    public int getItemCount() {
        return arrayMascotas.size();
    }
}

class MyMiniViewHolder extends RecyclerView.ViewHolder{
    public CardView mascotaCardview;
    public TextView mascotaRankingTXV;

    public MyMiniViewHolder(@NonNull View itemView, final Context context, final ArrayList<MascotasData> arrayMascotas) {
        super(itemView);
        mascotaCardview = itemView.findViewById(R.id.rec_item_mini_cardview);
        mascotaRankingTXV = itemView.findViewById(R.id.rec_item_mini_textview_ranking);
    }
}
