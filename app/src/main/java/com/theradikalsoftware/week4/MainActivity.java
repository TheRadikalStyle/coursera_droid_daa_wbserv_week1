package com.theradikalsoftware.week4;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
    private final String FRAG_CONTACTO_TAG = "FRAG_CONTACTO";
    private final String FRAG_ACERCADE_TAG = "FRAG_ACERCADE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.action_contacto) {
            Fragment contactoFragment = ContactoFragment.newInstance();
            FragmentChanger(contactoFragment, FRAG_CONTACTO_TAG);
            return true;
        }
        if (id == R.id.action_acercade) {
            Fragment acercadeFragment = AcercadeFragment.newInstance("David Ochoa Gutierrez", "@theradikalstyle");
            FragmentChanger(acercadeFragment, FRAG_ACERCADE_TAG);
            return true;
        }

        if(id == R.id.action_favorites){
            startActivity(new Intent(this, MascotasFavoritas.class));
        }

        return super.onOptionsItemSelected(item);
    }

    private void FragmentChanger(Fragment fragment, String TAG){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.nav_host_fragment, fragment, TAG);
        fragmentTransaction.commit();
    }
}