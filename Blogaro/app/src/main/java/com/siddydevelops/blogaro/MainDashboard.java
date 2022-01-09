package com.siddydevelops.blogaro;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainDashboard extends AppCompatActivity implements NavigationBarView.OnItemSelectedListener {

    BottomNavigationView bottomNavigationView;

    FragmentHome fragmentHome = new FragmentHome();
    FragmentArticles fragmentArticles = new FragmentArticles();
    FragmentAddBlog fragmentAddBlog = new FragmentAddBlog();
    FragmentSearch fragmentSearch = new FragmentSearch();
    FragmentMenu fragmentMenu = new FragmentMenu();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_dashboard);

        bottomNavigationView = findViewById(R.id.bottom_navigation_main);
        bottomNavigationView.setItemIconTintList(null);

        bottomNavigationView.setOnItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.nav_home);

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch(item.getItemId())
        {
            case R.id.nav_home:
                getSupportFragmentManager().beginTransaction().replace(R.id.container,fragmentHome).commit();
                return true;
            case R.id.nav_articles:
                getSupportFragmentManager().beginTransaction().replace(R.id.container,fragmentArticles).commit();
                return true;
            case R.id.nav_addBlog:
                getSupportFragmentManager().beginTransaction().replace(R.id.container,fragmentAddBlog).commit();
                return true;
            case R.id.nav_search:
                getSupportFragmentManager().beginTransaction().replace(R.id.container,fragmentSearch).commit();
                return true;
            case R.id.nav_menu:
                getSupportFragmentManager().beginTransaction().replace(R.id.container,fragmentMenu).commit();
                return true;
        }

        return false;
    }
}