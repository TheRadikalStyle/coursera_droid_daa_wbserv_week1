package com.theradikalsoftware.week5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ConfigurarCuentaActivity extends AppCompatActivity {
    Button saveButton;
    EditText text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configurar_cuenta);

        if(getSupportActionBar() != null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        text = findViewById(R.id.setaccount_edittext_username);
        saveButton = findViewById(R.id.setaccount_button_save);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(text.getText() != null && !String.valueOf(text.getText()).isEmpty()){
                    SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(ConfigurarCuentaActivity.this);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("insta_username", String.valueOf(text.getText()));
                    editor.commit();
                    Toast.makeText(ConfigurarCuentaActivity.this, "Guardado con exito", Toast.LENGTH_SHORT).show();
                    finish();
                }else{
                    Toast.makeText(ConfigurarCuentaActivity.this, "El campo está vacio", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}