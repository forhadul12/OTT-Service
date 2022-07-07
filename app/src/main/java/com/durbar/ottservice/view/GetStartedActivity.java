package com.durbar.ottservice.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.Toast;

import com.durbar.ottservice.R;
import com.durbar.ottservice.databinding.ActivityGetStartedBinding;

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