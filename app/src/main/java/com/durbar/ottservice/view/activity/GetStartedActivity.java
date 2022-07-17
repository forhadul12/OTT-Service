package com.durbar.ottservice.view.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.durbar.ottservice.databinding.ActivityGetStartedBinding;
import com.durbar.ottservice.view.activity.MainActivity;

public class GetStartedActivity extends AppCompatActivity {


    private ActivityGetStartedBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityGetStartedBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        binding.constraintLayout.setOnClickListener(view -> {
            gotoMainActivity();
        });
        binding.getStartedTv.setOnClickListener(view -> {
            gotoMainActivity();
        });

    }

    private void gotoMainActivity() {
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
        this.finish();
    }
}