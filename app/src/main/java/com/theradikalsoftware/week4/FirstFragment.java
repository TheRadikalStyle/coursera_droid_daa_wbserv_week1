package com.theradikalsoftware.week4;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class FirstFragment extends Fragment {
    private  RecyclerView recyclerV;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState ) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_first, container, false);

        recyclerV = root.findViewById(R.id.main_recyclerview_mascotas);
        recyclerV.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(getActivity());
        recyclerV.setLayoutManager(layoutManager);

        mAdapter = new MascotasAdapter();
        recyclerV.setAdapter(mAdapter);

        return root;
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }
}