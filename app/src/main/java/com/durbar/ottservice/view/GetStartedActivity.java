package com.durbar.ottservice.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.durbar.ottservice.R;

public class GetStartedActivity extends AppCompatActivity {

    private ConstraintLayout constraintLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_started);
        constraintLayout = findViewById(R.id.constraintLayout);

        constraintLayout.setOnClickListener(view -> {
            gotoMainActivity();
        });

    }

    private void gotoMainActivity() {
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
        this.finish();
    }
}