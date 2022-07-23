 package com.durbar.ottservice.view.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.durbar.ottservice.R;
import com.durbar.ottservice.databinding.ActivityLoginBinding;

 public class LoginActivity extends AppCompatActivity {

     private ActivityLoginBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        binding.signUpTv.setOnClickListener(view -> {
            startActivity(new Intent(getApplicationContext(), PremiumSignupActivity.class));
        });


        binding.loginWithPhone.loginWithPasswordTv.setOnClickListener(view -> {
            binding.loginWithPhoneContainer.setVisibility(View.GONE);
            binding.loginWithPassContainer.setVisibility(View.VISIBLE);
        });
        binding.loginWithPassword.loginWithPhoneTv.setOnClickListener(view -> {
            binding.loginWithPassContainer.setVisibility(View.GONE);
            binding.loginWithPhoneContainer.setVisibility(View.VISIBLE);
        });
    }
}