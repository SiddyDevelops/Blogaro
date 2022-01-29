package com.siddydevelops.blogaro;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.siddydevelops.blogaro.NavFragments.FragmentAddBlog;
import com.siddydevelops.blogaro.NavFragments.FragmentArticles;
import com.siddydevelops.blogaro.NavFragments.FragmentHome;
import com.siddydevelops.blogaro.NavFragments.FragmentProfile;
import com.siddydevelops.blogaro.NavFragments.FragmentSearch;

public class MainDashboard extends AppCompatActivity implements NavigationBarView.OnItemSelectedListener {

    BottomNavigationView bottomNavigationView;
    ImageView ivAddBlog;

    FragmentHome fragmentHome = new FragmentHome();
    FragmentArticles fragmentArticles = new FragmentArticles();
    FragmentAddBlog fragmentAddBlog = new FragmentAddBlog();
    FragmentSearch fragmentSearch = new FragmentSearch();
    FragmentProfile fragmentProfile = new FragmentProfile();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_dashboard);

        bottomNavigationView = findViewById(R.id.bottom_navigation_main);
        bottomNavigationView.setItemIconTintList(null);

        bottomNavigationView.setOnItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.nav_home);

        ivAddBlog = findViewById(R.id.iv_addBlog);

        ivAddBlog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction().replace(R.id.container,fragmentAddBlog).commit();
                ivAddBlog.setImageDrawable(getResources().getDrawable(R.drawable.ic_multiply));
                ivAddBlog.setBackgroundResource(R.drawable.bg_center_nav_2);
            }
        });

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
                bottomNavigationView.setVisibility(View.GONE);
                ivAddBlog.setVisibility(View.GONE);
                ivAddBlog.setImageDrawable(getResources().getDrawable(R.drawable.ic_plus));
                ivAddBlog.setBackgroundResource(R.drawable.bg_center_nav);
                return true;
            case R.id.nav_addBlog:
                getSupportFragmentManager().beginTransaction().replace(R.id.container,fragmentAddBlog).commit();
                ivAddBlog.setImageDrawable(getResources().getDrawable(R.drawable.ic_multiply));
                ivAddBlog.setBackgroundResource(R.drawable.bg_center_nav_2);
                return true;
            case R.id.nav_search:
                getSupportFragmentManager().beginTransaction().replace(R.id.container,fragmentSearch).commit();
                ivAddBlog.setImageDrawable(getResources().getDrawable(R.drawable.ic_plus));
                ivAddBlog.setBackgroundResource(R.drawable.bg_center_nav);
                return true;
            case R.id.nav_profile:
                getSupportFragmentManager().beginTransaction().replace(R.id.container, fragmentProfile).commit();
                ivAddBlog.setImageDrawable(getResources().getDrawable(R.drawable.ic_plus));
                ivAddBlog.setBackgroundResource(R.drawable.bg_center_nav);
                return true;
        }

        return false;
    }
}