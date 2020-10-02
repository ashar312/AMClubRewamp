package com.project.techaract.amclub.Sliders;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.project.techaract.amclub.Sliders.fragments.Slider1Fragment;
import com.project.techaract.amclub.Sliders.fragments.Slider2Fragment;
import com.project.techaract.amclub.Sliders.fragments.Slider3Fragment;

public class SliderAdapter extends FragmentStateAdapter {


    public SliderAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {

        switch (position){
            case 0:
                return new Slider1Fragment();
            case 1:
                return new Slider2Fragment();
            case 2:
                return new Slider3Fragment();
        }
        return null;

    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
