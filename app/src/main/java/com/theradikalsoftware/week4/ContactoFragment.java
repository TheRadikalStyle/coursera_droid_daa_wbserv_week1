package com.theradikalsoftware.week4;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ContactoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ContactoFragment extends Fragment {
    EditText nombreEDTX, correoEDTX, mensajeEDTX;
    Button sendComentario;

    public ContactoFragment() {
        // Required empty public constructor
    }

    public static ContactoFragment newInstance() {
        ContactoFragment fragment = new ContactoFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_contacto, container, false);

        nombreEDTX = v.findViewById(R.id.frag_contacto_edittext_nombre);
        correoEDTX = v.findViewById(R.id.frag_contacto_edittext_correo);
        mensajeEDTX= v.findViewById(R.id.frag_contacto_edittext_mensaje);
        sendComentario = v.findViewById(R.id.frag_contacto_button_enviar);
        sendComentario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                
            }
        });

        return v;
    }
}