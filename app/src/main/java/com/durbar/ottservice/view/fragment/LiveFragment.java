package com.durbar.ottservice.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import com.durbar.ottservice.adapter.NewsInsideTheCountryAdapter;
import com.durbar.ottservice.adapter.RecommendedLiveAdapter;
import com.durbar.ottservice.adapter.SliderAdapter;
import com.durbar.ottservice.databinding.FragmentLiveBinding;
import com.durbar.ottservice.utils.CallBack;

import java.util.ArrayList;
import java.util.List;


public class LiveFragment extends Fragment {


    //binding
    private FragmentLiveBinding binding;

    //OnClick
    //CallBack
    private final CallBack.TabOnClick callBack;

    //News Inside the Country
    private NewsInsideTheCountryAdapter newsInsideTheCountryAdapter;
    private List<String> images = new ArrayList<>();

    public LiveFragment(Context context) {
        // Required empty public constructor
        this.callBack = (CallBack.TabOnClick) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentLiveBinding.inflate(inflater, container, false);
        // Inflate the layout for this fragment
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.recommendedLiveRv.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        binding.recommendedLiveRv.setAdapter(new RecommendedLiveAdapter());

        setSlider();

        binding.tabHome.setOnClickListener(view1 -> {
            callBack.tabHomeOnClickCallBack();
        });
    }



    private void setSlider(){
        images.add("https://www.rabbitholebd.com/_next/image?url=https%3A%2F%2Fdidbxtymavoia.cloudfront.net%2Fcms%2Fseries%2F1655379262_sa-v-ban-525.jpg&w=1920&q=75");
        images.add("https://www.rabbitholebd.com/_next/image?url=https%3A%2F%2Fdidbxtymavoia.cloudfront.net%2Fcms%2Fseries%2F1654670937_CMN-525x285.jpg&w=1920&q=75");
        images.add("https://www.rabbitholebd.com/_next/image?url=https%3A%2F%2Fdidbxtymavoia.cloudfront.net%2Fcms%2Fseries%2F1656499914_BAN-V-SA-2017-525-X-285.jpg&w=1920&q=75");
        images.add("https://www.rabbitholebd.com/_next/image?url=https%3A%2F%2Fdidbxtymavoia.cloudfront.net%2Fcms%2Fseries%2F1656845726_525x285.jpg&w=1920&q=75");
        images.add("https://www.rabbitholebd.com/_next/image?url=https%3A%2F%2Fdidbxtymavoia.cloudfront.net%2Fcms%2Fseries%2F1657178524_CMN-525x285.jpg&w=1920&q=75");
        images.add("https://www.rabbitholebd.com/_next/image?url=https%3A%2F%2Fdidbxtymavoia.cloudfront.net%2Fcms%2Fseries%2F1655379262_sa-v-ban-525.jpg&w=1920&q=75");
        newsInsideTheCountryAdapter = new NewsInsideTheCountryAdapter(images);
        binding.newsInsideCountryVp.setAdapter(newsInsideTheCountryAdapter);
        binding.newsInsideCountryVp.setClipToPadding(false);
        binding.newsInsideCountryVp.setClipChildren(false);
        binding.newsInsideCountryVp.setOffscreenPageLimit(3);
        binding.newsInsideCountryVp.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);

        CompositePageTransformer compositePageTransformer = new CompositePageTransformer();
        compositePageTransformer.addTransformer(new MarginPageTransformer(10));

        compositePageTransformer.addTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
                float r = 1 - Math.abs(position);
                page.setScaleY(0.85f + r * 0.10f);
            }
        });
        binding.newsInsideCountryVp.setPageTransformer(compositePageTransformer);
    }
}