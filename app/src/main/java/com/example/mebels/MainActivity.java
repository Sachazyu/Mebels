package com.example.mebels;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNav = findViewById(R.id.bottomNavigationView);
        //kayae ini salah

        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView, new Homeku()).commit();
        bottomNav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selected_fragment = null;
                switch(item.getItemId()){
                    case R.id.nav_home:
                        selected_fragment = new Homeku();
                        break;
                    case R.id.nav_shop:
                        selected_fragment = new Shop();
                        break;
                    case R.id.nav_rating:
                        selected_fragment = new Penilaian();
                        break;
                    case R.id.nav_profile:
                        selected_fragment = new Profile();
                        break;
                }

                getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView, selected_fragment).commit();

                return true;
            }
        });
    }
}