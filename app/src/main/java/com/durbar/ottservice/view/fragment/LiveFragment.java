package com.durbar.ottservice.view.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import com.durbar.ottservice.R;
import com.durbar.ottservice.adapter.BottomProductsAdapter;
import com.durbar.ottservice.adapter.LiveSportsAdapter;
import com.durbar.ottservice.adapter.NewsInsideTheCountryAdapter;
import com.durbar.ottservice.adapter.RecommendedLiveAdapter;
import com.durbar.ottservice.databinding.FragmentLiveBinding;
import com.durbar.ottservice.utils.CallBack;
import com.durbar.ottservice.utils.Constants;
import com.durbar.ottservice.view.activity.MoreActivity;

import java.util.ArrayList;
import java.util.List;


public class LiveFragment extends Fragment {


    //binding
    private FragmentLiveBinding binding;

    //OnClick
    //CallBack
    private final CallBack.TabOnClick callBack;

    //News Inside the Country recyclerView
    private NewsInsideTheCountryAdapter newsInsideTheCountryAdapter;


    //Live sports recyclerView
    private LiveSportsAdapter liveSportsAdapter;


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

        binding.tabContainer.tabLive.setTextAppearance(getActivity(), R.style.tabTextViewStyleActiveStyle);
        //Recommended Live recyclerView
        binding.recommendedLiveRv.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        binding.recommendedLiveRv.setAdapter(new RecommendedLiveAdapter());

        //News Inside the country using viewPager2
        setNewsInsideTheCountry(binding.newsInsideCountryVp, 1);


        //Live Sports RecyclerView
        binding.liveSportsRv.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        liveSportsAdapter = new LiveSportsAdapter();
        binding.liveSportsRv.setAdapter(liveSportsAdapter);

        //set Tv shows
        setNewsInsideTheCountry(binding.tvShowsVp, 0);


        //set Bottom Products
        binding.bottomProductRv.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        binding.bottomProductRv.setAdapter(new BottomProductsAdapter());


        //Tab Home OnClick
        binding.tabContainer.tabHome.setOnClickListener(view1 -> {
            callBack.tabHomeOnClickCallBack();
        });
        //Tab movie OnClick
        binding.tabContainer.tabMovies.setOnClickListener(view1 -> {
            callBack.tabMovieOnClickCallBack();
        });

        binding.recommendedLiveMoreTv.setOnClickListener(view1 -> startActivity(new Intent(getActivity(), MoreActivity.class).putExtra(Constants.TOOLBAR_TITLE_KEY, "Recommended Live")));
        binding.newsInsideCountryMoreTv.setOnClickListener(view1 -> startActivity(new Intent(getActivity(), MoreActivity.class).putExtra(Constants.TOOLBAR_TITLE_KEY, "News Inside The Country")));
        binding.liveSportsMoreTv.setOnClickListener(view1 -> startActivity(new Intent(getActivity(), MoreActivity.class).putExtra(Constants.TOOLBAR_TITLE_KEY, "Live Sports")));
        binding.tvShowsMoreTv.setOnClickListener(view1 -> startActivity(new Intent(getActivity(), MoreActivity.class).putExtra(Constants.TOOLBAR_TITLE_KEY, "TV Shows")));


    }


    private void setNewsInsideTheCountry(ViewPager2 vp, int n) {
        List<String> images = new ArrayList<>();
        if (n == 1) {
            images.add("https://www.rabbitholebd.com/_next/image?url=https%3A%2F%2Fdidbxtymavoia.cloudfront.net%2Fcms%2Fseries%2F1655379262_sa-v-ban-525.jpg&w=1920&q=75");
            images.add("https://www.rabbitholebd.com/_next/image?url=https%3A%2F%2Fdidbxtymavoia.cloudfront.net%2Fcms%2Fseries%2F1654670937_CMN-525x285.jpg&w=1920&q=75");
            images.add("https://www.rabbitholebd.com/_next/image?url=https%3A%2F%2Fdidbxtymavoia.cloudfront.net%2Fcms%2Fseries%2F1656499914_BAN-V-SA-2017-525-X-285.jpg&w=1920&q=75");
        }else {
            images.add("https://www.rabbitholebd.com/_next/image?url=https%3A%2F%2Fdidbxtymavoia.cloudfront.net%2Fcms%2Fseries%2F1656845726_525x285.jpg&w=1920&q=75");
            images.add("https://www.rabbitholebd.com/_next/image?url=https%3A%2F%2Fdidbxtymavoia.cloudfront.net%2Fcms%2Fseries%2F1657178524_CMN-525x285.jpg&w=1920&q=75");
            images.add("https://www.rabbitholebd.com/_next/image?url=https%3A%2F%2Fdidbxtymavoia.cloudfront.net%2Fcms%2Fseries%2F1655379262_sa-v-ban-525.jpg&w=1920&q=75");
        }
        newsInsideTheCountryAdapter = new NewsInsideTheCountryAdapter(images);
        vp.setAdapter(newsInsideTheCountryAdapter);
        vp.setClipToPadding(false);
        vp.setClipChildren(false);
        vp.setOffscreenPageLimit(3);
        vp.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);

        CompositePageTransformer compositePageTransformer = new CompositePageTransformer();
        compositePageTransformer.addTransformer(new MarginPageTransformer(10));

        compositePageTransformer.addTransformer((page, position) -> {
            float r = 1 - Math.abs(position);
            if (n == 1)
                page.setScaleY(0.85f + r * 0.10f);
        });
        vp.setPageTransformer(compositePageTransformer);
    }
}