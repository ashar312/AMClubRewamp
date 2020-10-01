package com.project.techaract.amclub;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import com.project.techaract.amclub.Form.Selector;

public class MainActivity extends AppCompatActivity {

    private int splashTimeout=3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView imageView = findViewById(R.id.imageView);
        imageView.animate().alpha(1f).setDuration(2000).start();


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(MainActivity.this, Selector.class));
                finish();
            }
        }, splashTimeout);
    }
}