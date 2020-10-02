package com.project.techaract.amclub.Sliders;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import com.project.techaract.amclub.Form.Selector;
import com.project.techaract.amclub.R;
import com.project.techaract.amclub.databinding.ActivitySliderBinding;

public class SliderActivity extends AppCompatActivity {

    private ActivitySliderBinding binding;
    private SliderAdapter sliderAdapter;
    private int page = 0;
    private int delay = 2000; //milliseconds
    private Handler handler;

    private Runnable runnable = new Runnable() {
        public void run() {
            if (sliderAdapter.getItemCount() == page) {
                page = 0;
            } else {
                page++;
            }
            binding.sliderViewpager.setCurrentItem(page, true);
            handler.postDelayed(this, delay);
        }
    };

    private ViewPager2.OnPageChangeCallback onPageChangeCallback=new ViewPager2.OnPageChangeCallback() {
        @Override
        public void onPageSelected(int position) {
            super.onPageSelected(position);
            page=position;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySliderBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setupViews();
    }

    private void setupViews() {

        handler = new Handler(Looper.getMainLooper());

        sliderAdapter = new SliderAdapter(this);
        binding.sliderViewpager.setAdapter(sliderAdapter);

        binding.sliderViewpager.registerOnPageChangeCallback(onPageChangeCallback);

        binding.springDotsIndicator.setViewPager2(binding.sliderViewpager);

        binding.skipBtn.setOnClickListener(v -> {
            startActivity(new Intent(this, Selector.class));
        });
    }


    @Override
    protected void onResume() {
        super.onResume();
        handler.postDelayed(runnable,delay);
    }

    @Override
    protected void onPause() {
        super.onPause();
        handler.removeCallbacks(runnable);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        binding.sliderViewpager.unregisterOnPageChangeCallback(onPageChangeCallback);
    }
}