package com.theradikalsoftware.week5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import com.theradikalsoftware.week5.database.DBMascotas;

import java.util.ArrayList;

public class MascotasFavoritas extends AppCompatActivity {
    private RecyclerView recyclerV;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    ArrayList<MascotasData> mascData = new ArrayList();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        if(getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        GetDatabaseData();

        recyclerV = findViewById(R.id.activity_second_recyclerview);
        recyclerV.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerV.setLayoutManager(layoutManager);

        if(mascData.size() > 0){
            mAdapter = new MascotasAdapter(mascData);
            recyclerV.setAdapter(mAdapter);
        }else{
            mAdapter = new MascotasAdapter();
            recyclerV.setAdapter(mAdapter);
        }
    }

    private void GetDatabaseData(){
        MascotasData mData;
        SQLiteDatabase database = new DBMascotas(this).getReadableDatabase();

        Cursor cursor = database.rawQuery("SELECT * FROM rank", null);
        if(cursor != null){
            while(cursor.moveToNext()){
                mData = new MascotasData();
                mData.setId(cursor.getInt(1));
                mData.setNombre(cursor.getString(2));
                mData.setRanking(cursor.getInt(3));

                mascData.add(mData);
            }
            cursor.close();
        }
        database.close();
    }
}