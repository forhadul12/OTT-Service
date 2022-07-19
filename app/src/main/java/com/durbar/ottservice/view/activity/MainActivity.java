package com.durbar.ottservice.view.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.durbar.ottservice.R;
import com.durbar.ottservice.databinding.ActivityMainBinding;
import com.durbar.ottservice.utils.CallBack;
import com.durbar.ottservice.view.fragment.HomeFragment;
import com.durbar.ottservice.view.fragment.LiveFragment;
import com.durbar.ottservice.view.fragment.MoviesFragment;

public class MainActivity extends AppCompatActivity implements CallBack.TabOnClick {

    private ActivityMainBinding binding;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.bottomNav.setBackground(null);
        binding.bottomNav.setSelectedItemId(R.id.nav_home);
        binding.bottomNav.findViewById(R.id.nav_home).setEnabled(false);

        actionBarDrawerToggle = new ActionBarDrawerToggle(this, binding.drawerLayout, R.string.nav_open, R.string.nav_close);
        binding.drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        setSupportActionBar(binding.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment(this)).commit();

        binding.navDrawer.setNavigationItemSelectedListener(item -> {
            switch (item.getItemId()){
                case R.id.nav_account:
                    Toast.makeText(this, "account", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.nav_logout:
                    Toast.makeText(this, "logout", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.nav_settings:
                    Toast.makeText(this, "setting", Toast.LENGTH_SHORT).show();
                    break;
            }

            return true;
        });

        binding.bottomNav.setOnItemSelectedListener(item -> {
            switch (item.getItemId()){
                case R.id.nav_my_list:
                    Toast.makeText(this, "my list", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.nav_movies:
                    Toast.makeText(this, "movies", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.nav_tv:
                    Toast.makeText(this, "tv", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.nav_profile:
                    Toast.makeText(this, "profile", Toast.LENGTH_SHORT).show();
                    break;

            }
            return true;
        });


        binding.searchIv.setOnClickListener(view -> {
            Toast.makeText(this, "search", Toast.LENGTH_SHORT).show();
        });
        binding.premiumCrownIv.setOnClickListener(view -> {
            Toast.makeText(this, "premium", Toast.LENGTH_SHORT).show();
        });

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (actionBarDrawerToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void tabLiveOnClickCallBack() {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new LiveFragment(this)).commit();
    }

    @Override
    public void tabHomeOnClickCallBack() {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment(this)).commit();
    }

    @Override
    public void tabMovieOnClickCallBack() {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new MoviesFragment(this)).commit();
    }
}