package com.theradikalsoftware.week5;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.theradikalsoftware.week5.database.DBMascotas;
import com.theradikalsoftware.week5.database.DBMascotasModel;

import java.util.ArrayList;

public class MascotasAdapter extends RecyclerView.Adapter<MyViewHolder> {
    private ArrayList<MascotasData> arrayMascotas = new ArrayList<>();
    private MascotasData mascotasData;

    public MascotasAdapter(){
        mascotasData = new MascotasData();
        mascotasData.id = 1;
        mascotasData.nombre = "Pretty";
        mascotasData.ranking = 0;
        arrayMascotas.add(mascotasData);

        mascotasData = new MascotasData();
        mascotasData.id = 2;
        mascotasData.nombre = "Terry";
        mascotasData.ranking = 0;
        arrayMascotas.add(mascotasData);

        mascotasData = new MascotasData();
        mascotasData.id = 3;
        mascotasData.nombre = "Cokis";
        mascotasData.ranking = 0;
        arrayMascotas.add(mascotasData);

        mascotasData = new MascotasData();
        mascotasData.id = 4;
        mascotasData.nombre = "Blacky";
        mascotasData.ranking = 0;
        arrayMascotas.add(mascotasData);

        mascotasData = new MascotasData();
        mascotasData.id = 5;
        mascotasData.nombre = "Tom";
        mascotasData.ranking = 0;
        arrayMascotas.add(mascotasData);
    }

    public MascotasAdapter(ArrayList list){
        this.arrayMascotas = list;
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
        holder.mascotaRankingTXV.setText(String.valueOf(arrayMascotas.get(position).getRanking()));
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
                int antRanking = arrayMascotas.get(getAdapterPosition()).getRanking();
                arrayMascotas.get(getAdapterPosition()).setRanking(antRanking + 1);
                SaveRanking(arrayMascotas.get(getAdapterPosition()).getId(),
                        arrayMascotas.get(getAdapterPosition()).getNombre(),
                        arrayMascotas.get(getAdapterPosition()).getRanking() + 1
                );
            }

            private void SaveRanking(int id, String nombre, int ranking) {
                SQLiteDatabase database = new DBMascotas(context).getWritableDatabase();

                ContentValues values = new ContentValues();
                values.put(DBMascotasModel.TableRank.COLUMN_NAME_MASC_ID, id);
                values.put(DBMascotasModel.TableRank.COLUMN_NAME_MASC_NOMBRE, nombre);
                values.put(DBMascotasModel.TableRank.COLUMN_NAME_MASC_RANK, ranking);

                //Si retorna 0 significa que no existe en base de datos, asi que inserta por primera vez
                if(database.update(DBMascotasModel.TableRank.TableName, values, DBMascotasModel.TableRank.COLUMN_NAME_MASC_ID+"="+id, null) == 0){
                    database.insert(DBMascotasModel.TableRank.TableName, null, values);
                }

                values.clear();
                database.close();
            }
        });
    }
}
