package com.theradikalsoftware.week5;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;
import com.theradikalsoftware.week5.fragments.MascotasFragment;
import com.theradikalsoftware.week5.fragments.ProfileFragment;

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
    private final String FRAG_FIRST_TAG = "FRAG_FIRST";
    private final String FRAG_PROFILE_TAG = "FRAG_PROFILE";
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        tabLayout = findViewById(R.id.main_tab_layout);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()){
                    case 0:
                        FragmentChanger(new MascotasFragment(), FRAG_FIRST_TAG);
                        tab.select();
                        break;

                    case 1:
                        FragmentChanger(new ProfileFragment(), FRAG_PROFILE_TAG);
                        tab.select();
                        break;
                    default:
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        FragmentChanger(new MascotasFragment(), FRAG_FIRST_TAG);
        tabLayout.getTabAt(0).select();
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
            startActivity(new Intent(this, ActivityContacto.class));
            return true;
        }
        if (id == R.id.action_acercade) {
            startActivity(new Intent(this, AcercaDeActivity.class));
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