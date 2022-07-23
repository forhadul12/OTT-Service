package com.durbar.ottservice.view.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;

import com.durbar.ottservice.R;
import com.durbar.ottservice.databinding.ActivityPremiumSignupBinding;

public class PremiumSignupActivity extends AppCompatActivity {

    private ActivityPremiumSignupBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPremiumSignupBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        String[] subsPlan = {"Weekly Plan","Monthly Plan", "Half-Yearly Plan", "Yearly Plan"};
        String[] payWith = {"Pay With bKash","Pay With Nagad", "Pay With Upay", "Pay With Card"};

        ArrayAdapter planAdapter = new ArrayAdapter(getApplicationContext()
        , R.layout.dropdown_item, subsPlan);
        ArrayAdapter paymentAdapter = new ArrayAdapter(getApplicationContext()
                , R.layout.dropdown_item, payWith);

        binding.signupLayout.planEdtx.setAdapter(planAdapter);
        binding.signupLayout.paymentMethodEdtx.setAdapter(paymentAdapter);
    }
}