package com.example.eop;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    RecruitmentFragment recruitmentFragment;
    ApplyFragment applyFragment;
    InformationFragment informationFragment;
    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recruitmentFragment=new RecruitmentFragment();
        applyFragment=new ApplyFragment();
        informationFragment=new InformationFragment();
        bottomNavigationView=findViewById(R.id.bottomNavigation);

        slectedbottomNavigationView(bottomNavigationView);

        getSupportFragmentManager().beginTransaction().replace(R.id.container,applyFragment).commit();
    }

    public void slectedbottomNavigationView(BottomNavigationView bottomNavigationView){
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            Fragment selectedFragment=null;
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId()==R.id.apply){
                    selectedFragment=applyFragment;
                }
                else if(item.getItemId()==R.id.recruitment){
                    selectedFragment=recruitmentFragment;
                }
                else if(item.getItemId()==R.id.information){
                    selectedFragment=informationFragment;
                }

                getSupportFragmentManager().beginTransaction().replace(R.id.container,selectedFragment).commit();

                return true;
            }
        });
    }
}