package com.durbar.ottservice.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.durbar.ottservice.R;
import com.durbar.ottservice.adapter.RecentlyAddedAdapter;
import com.durbar.ottservice.adapter.SliderAdapter;
import com.durbar.ottservice.databinding.FragmentHomeBinding;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;


    //slider
    private SliderAdapter sliderAdapter;
    private Handler sliderHandler = new Handler();


    public HomeFragment() {
        // Required empty public constructor
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setSlider();

        binding.recentlyAddedRv.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL, false));
        binding.recentlyAddedRv.setAdapter(new RecentlyAddedAdapter());

        binding.dhallywoodRv.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL, false));
        binding.dhallywoodRv.setAdapter(new RecentlyAddedAdapter());

        binding.tamilRv.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL, false));
        binding.tamilRv.setAdapter(new RecentlyAddedAdapter());

        binding.englilshRv.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL, false));
        binding.englilshRv.setAdapter(new RecentlyAddedAdapter());

        binding.tvSeriesRv.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL, false));
        binding.tvSeriesRv.setAdapter(new RecentlyAddedAdapter());

        binding.popularDramaRv.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL, false));
        binding.popularDramaRv.setAdapter(new RecentlyAddedAdapter());


    }


    private void setSlider(){
        List<String> images = new ArrayList<>();
        images.add("https://images.pexels.com/photos/12498564/pexels-photo-12498564.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1");
        images.add("https://images.pexels.com/photos/9136582/pexels-photo-9136582.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1");
        images.add("https://images.pexels.com/photos/12645600/pexels-photo-12645600.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1");
        images.add("https://images.pexels.com/photos/3185041/pexels-photo-3185041.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1");
        images.add("https://images.pexels.com/photos/12319685/pexels-photo-12319685.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1");
        images.add("https://images.pexels.com/photos/5714602/pexels-photo-5714602.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1");
        sliderAdapter = new SliderAdapter(binding.homeSliderVp, images);
        binding.homeSliderVp.setAdapter(sliderAdapter);
        binding.homeSliderVp.setClipToPadding(false);
        binding.homeSliderVp.setClipChildren(false);
        binding.homeSliderVp.setOffscreenPageLimit(3);
        binding.homeSliderVp.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);
        CompositePageTransformer compositePageTransformer = new CompositePageTransformer();
        compositePageTransformer.addTransformer(new MarginPageTransformer(10));
        compositePageTransformer.addTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
                float r = 1 - Math.abs(position);
                page.setScaleY(0.85f + r * 0.15f);
            }
        });
        binding.homeSliderVp.setPageTransformer(compositePageTransformer);
        binding.homeSliderVp.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                sliderHandler.removeCallbacks(sliderRunnable);
                sliderHandler.postDelayed(sliderRunnable, 3000);
            }
        });
    }
    private Runnable sliderRunnable = new Runnable() {
        @Override
        public void run() {
           /* int current = binding.homeSliderVp.getCurrentItem();
            Toast.makeText(getActivity(), current+" th", Toast.LENGTH_SHORT).show();
            if (current>3)
                binding.homeSliderVp.setCurrentItem(0);
            else*/
            binding.homeSliderVp.setCurrentItem(binding.homeSliderVp.getCurrentItem()+1);
        }
    };
}