package com.theradikalsoftware.week4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MascotasFavoritas extends AppCompatActivity {
    private RecyclerView recyclerV;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        if(getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        recyclerV = findViewById(R.id.activity_second_recyclerview);
        recyclerV.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerV.setLayoutManager(layoutManager);

        mAdapter = new MascotasAdapter();
        recyclerV.setAdapter(mAdapter);
    }
}