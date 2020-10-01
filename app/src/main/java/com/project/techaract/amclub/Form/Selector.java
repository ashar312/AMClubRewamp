package com.project.techaract.amclub.Form;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.project.techaract.amclub.R;
import com.project.techaract.amclub.databinding.ActivitySelectorBinding;

public class Selector extends AppCompatActivity {
    private ActivitySelectorBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySelectorBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.ref.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Selector.this,Registration.class));
            }
        });

        binding.simple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Selector.this,SimpleForm.class));
            }
        });

    }
}