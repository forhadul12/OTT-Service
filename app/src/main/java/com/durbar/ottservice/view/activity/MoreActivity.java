package com.durbar.ottservice.view.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.durbar.ottservice.R;
import com.durbar.ottservice.adapter.SliderAdapter;
import com.durbar.ottservice.adapter.WatchTrailerAdapter;
import com.durbar.ottservice.databinding.ActivityMoreBinding;
import com.durbar.ottservice.utils.Constants;

import java.util.ArrayList;
import java.util.List;

public class MoreActivity extends AppCompatActivity {

    //ViewBinding
    private ActivityMoreBinding binding;

    //toolbar title
    private String toolbarTitle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMoreBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        toolbarTitle = getIntent().getStringExtra(Constants.TOOLBAR_TITLE_KEY);


        setSupportActionBar(binding.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(toolbarTitle);

        setTopSlider();


        //RecyclerView
        binding.watchTrailerRv.setLayoutManager(new GridLayoutManager(this, 2));
        binding.watchTrailerRv.setAdapter(new WatchTrailerAdapter());

    }

    private void setTopSlider()
    {
        List<String> images = new ArrayList<>();
        images.add("https://www.rabbitholebd.com/_next/image?url=https%3A%2F%2Fdidbxtymavoia.cloudfront.net%2Fcms%2Fvideos%2F1654438664_Final-260x372.png&w=1920&q=75");
        images.add("https://www.rabbitholebd.com/_next/image?url=https%3A%2F%2Fdidbxtymavoia.cloudfront.net%2Fcms%2Fvideos%2F1654438633_2nd-Qualifier-260x372.png&w=1920&q=75");
        images.add("https://www.rabbitholebd.com/_next/image?url=https%3A%2F%2Fdidbxtymavoia.cloudfront.net%2Fcms%2Fvideos%2F1654438556_Eliminator-260x372.png&w=1920&q=75");
        images.add("https://www.rabbitholebd.com/_next/image?url=https%3A%2F%2Fdidbxtymavoia.cloudfront.net%2Fcms%2Fvideos%2F1654438591_1st-Qualifier-260x372.png&w=1920&q=75");
        images.add("https://www.rabbitholebd.com/_next/image?url=https%3A%2F%2Fdidbxtymavoia.cloudfront.net%2Fcms%2Fvideos%2F1654437559_M29-260x372.png&w=1920&q=75");
        images.add("https://www.rabbitholebd.com/_next/image?url=https%3A%2F%2Fdidbxtymavoia.cloudfront.net%2Fcms%2Fvideos%2F1654437605_30th-Match--du-plessies-260x372.png&w=1920&q=75");
        SliderAdapter sliderAdapter = new SliderAdapter(binding.sliderVp, images);
        binding.sliderVp.setAdapter(sliderAdapter);
        binding.sliderVp.setClipToPadding(false);
        binding.sliderVp.setClipChildren(false);
        binding.sliderVp.setOffscreenPageLimit(3);
        binding.sliderVp.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);
        CompositePageTransformer compositePageTransformer = new CompositePageTransformer();
        compositePageTransformer.addTransformer(new MarginPageTransformer(10));
        compositePageTransformer.addTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
                float r = 1 - Math.abs(position);
                page.setScaleY(0.85f + r * 0.15f);
            }
        });
        binding.sliderVp.setPageTransformer(compositePageTransformer);
        binding.sliderVp.setCurrentItem(1);
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        onBackPressed();
        finish();
        return super.onOptionsItemSelected(item);
    }
}