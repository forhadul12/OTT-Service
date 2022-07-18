package com.durbar.ottservice.view.fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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

import com.durbar.ottservice.adapter.RecentlyAddedAdapter;
import com.durbar.ottservice.adapter.SliderAdapter;
import com.durbar.ottservice.databinding.FragmentHomeBinding;
import com.durbar.ottservice.utils.CallBack;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;


    //slider
    private SliderAdapter sliderAdapter;
    private Handler sliderHandler = new Handler();
    private List<String> images = new ArrayList<>();
    private boolean inc = true;

    //CallBack
    private CallBack.TabOnClick callBack;


    public HomeFragment(Context context) {
        // Required empty public constructor
        this.callBack = (CallBack.TabOnClick) context;
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

        binding.tabLive.setOnClickListener(view1 -> {
            callBack.tabLiveOnClickCallBack();
        });


    }


    private void setSlider(){
        images.add("https://www.rabbitholebd.com/_next/image?url=https%3A%2F%2Fdidbxtymavoia.cloudfront.net%2Fcms%2Fvideos%2F1654083046_Qualifier-2-260x372.png&w=1920&q=75");
        images.add("https://www.rabbitholebd.com/_next/image?url=https%3A%2F%2Fdidbxtymavoia.cloudfront.net%2Fcms%2Fvideos%2F1654438633_2nd-Qualifier-260x372.png&w=1920&q=75");
        images.add("https://www.rabbitholebd.com/_next/image?url=https%3A%2F%2Fdidbxtymavoia.cloudfront.net%2Fcms%2Fvideos%2F1654438664_Final-260x372.png&w=1920&q=75");
        images.add("https://www.rabbitholebd.com/_next/image?url=https%3A%2F%2Fdidbxtymavoia.cloudfront.net%2Fcms%2Fvideos%2F1655215270_BAN-V-PAK-12TH-MATCH.jpg&w=1920&q=75");
        images.add("https://www.rabbitholebd.com/_next/image?url=https%3A%2F%2Fdidbxtymavoia.cloudfront.net%2Fcms%2Fvideo_poster%2F1631021370_web.jpeg&w=1920&q=75");
        images.add("https://www.rabbitholebd.com/_next/image?url=https%3A%2F%2Fdidbxtymavoia.cloudfront.net%2Fcms%2Fvideo_poster%2F1630568700_web.jpeg&w=1920&q=75");
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
           int current = binding.homeSliderVp.getCurrentItem();
           if (current==images.size()-1){
               inc = false;
           }
           if (current == 0)
               inc = true;
                //binding.homeSliderVp.setCurrentItem(0);
            if (inc)
            binding.homeSliderVp.setCurrentItem(current+1);
            else binding.homeSliderVp.setCurrentItem(current-1);
        }
    };
}