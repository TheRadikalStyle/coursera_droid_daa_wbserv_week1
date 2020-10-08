package com.theradikalsoftware.week4;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AcercadeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AcercadeFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_DEV_NAME = "dev_name";
    private static final String ARG_DEV_USERNAME = "dev_username";

    // TODO: Rename and change types of parameters
    private String developerName;
    private String developerUsername;

    public AcercadeFragment() {
        // Required empty public constructor
    }

    public static AcercadeFragment newInstance(String param1, String param2) {
        AcercadeFragment fragment = new AcercadeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_DEV_NAME, param1);
        args.putString(ARG_DEV_USERNAME, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            developerName = getArguments().getString(ARG_DEV_NAME);
            developerUsername = getArguments().getString(ARG_DEV_USERNAME);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_acercade, container, false);

        TextView devNameTXV = v.findViewById(R.id.frag_acercade_textview_devname);
        devNameTXV.setText(developerName);
        TextView devUsernameTXV = v.findViewById(R.id.frag_acercade_textview_devusername);
        devUsernameTXV.setText(developerUsername);

        return v;
    }
}