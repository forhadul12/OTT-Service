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

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.durbar.ottservice.R;
import com.durbar.ottservice.adapter.NewsInsideTheCountryAdapter;
import com.durbar.ottservice.adapter.RecentlyAddedAdapter;
import com.durbar.ottservice.databinding.FragmentMoviesBinding;
import com.durbar.ottservice.utils.CallBack;

import java.util.ArrayList;
import java.util.List;


public class MoviesFragment extends Fragment {
    //ViewBinding
    private FragmentMoviesBinding binding;

    //OnClick
    //CallBack
    private CallBack.TabOnClick tabOnClick;
    private CallBack.MoreOnClick moreOnClick;

    public MoviesFragment(Context context) {
        // Required empty public constructor
        this.tabOnClick = (CallBack.TabOnClick) context;
        this.moreOnClick = (CallBack.MoreOnClick) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentMoviesBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        binding.tabContainer.tabMovies.setTextAppearance(getContext(), R.style.tabTextViewStyleActiveStyle);

        //set top movie viewpager
        setMoviesTopViewPager();

        //Dhallywood
        binding.dhallywoodRv.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL, false));
        binding.dhallywoodRv.setAdapter(new RecentlyAddedAdapter());
        binding.dhallywoodMoreTv.setOnClickListener(view1 -> {
            moreOnClick.moreOnClick(getContext().getResources().getString(R.string.dhallywood));
        });

        //Tamil
        binding.tamilRv.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL, false));
        binding.tamilRv.setAdapter(new RecentlyAddedAdapter());
        binding.tamilMoreTv.setOnClickListener(view1 -> {
            moreOnClick.moreOnClick(getContext().getResources().getString(R.string.tamil));
        });

        //Hindi
        binding.hindiRv.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL, false));
        binding.hindiRv.setAdapter(new RecentlyAddedAdapter());
        binding.hindiMoreTv.setOnClickListener(view1 -> {
            moreOnClick.moreOnClick(getContext().getResources().getString(R.string.hindi));
        });

        //Korean
        binding.koreanRv.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL, false));
        binding.koreanRv.setAdapter(new RecentlyAddedAdapter());
        binding.koreanMoreTv.setOnClickListener(view1 -> {
            moreOnClick.moreOnClick(getContext().getResources().getString(R.string.korean));
        });

        //English
        binding.englishRv.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL, false));
        binding.englishRv.setAdapter(new RecentlyAddedAdapter());
        binding.englishMoreTv.setOnClickListener(view1 -> {
            moreOnClick.moreOnClick(getContext().getResources().getString(R.string.english));
        });

        //Kolkata
        binding.kolkataRv.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL, false));
        binding.kolkataRv.setAdapter(new RecentlyAddedAdapter());
        binding.kolkataMoreTv.setOnClickListener(view1 -> {
            moreOnClick.moreOnClick(getContext().getResources().getString(R.string.kolkata));
        });

        binding.tabContainer.tabHome.setOnClickListener(view1 -> tabOnClick.tabHomeOnClickCallBack());
        binding.tabContainer.tabLive.setOnClickListener(view1 -> tabOnClick.tabLiveOnClickCallBack());
    }


    private void setMoviesTopViewPager(){
        List<String> images = new ArrayList<>();
        images.add("https://www.rabbitholebd.com/_next/image?url=https%3A%2F%2Fdidbxtymavoia.cloudfront.net%2Fcms%2Fseries%2F1654420205_1st-Test-525x285.png&w=1920&q=75");
        images.add("https://www.rabbitholebd.com/_next/image?url=https%3A%2F%2Fdidbxtymavoia.cloudfront.net%2Fcms%2Fseries%2F1654084987_1646055869_Web-CMN.png&w=1920&q=75");
        images.add("https://www.rabbitholebd.com/_next/image?url=https%3A%2F%2Fdidbxtymavoia.cloudfront.net%2Fcms%2Fseries%2F1654431987_CMN-525x285.jpg&w=1920&q=75");
        images.add("https://www.rabbitholebd.com/_next/image?url=https%3A%2F%2Fdidbxtymavoia.cloudfront.net%2Fcms%2Fseries%2F1654684945_Sports-CMN-525x285.jpg&w=1920&q=75");
        images.add("https://www.rabbitholebd.com/_next/image?url=https%3A%2F%2Fdidbxtymavoia.cloudfront.net%2Fcms%2Fseries%2F1657107170_CMN-525x285.jpg&w=1920&q=75");
        images.add("https://www.rabbitholebd.com/_next/image?url=https%3A%2F%2Fdidbxtymavoia.cloudfront.net%2Fcms%2Fseries%2F1657183463_CMN-525x285.jpg&w=1920&q=75");
        binding.moviesTopVp.setAdapter(new NewsInsideTheCountryAdapter(images));
        binding.moviesTopVp.setClipToPadding(false);
        binding.moviesTopVp.setClipChildren(false);
        binding.moviesTopVp.setOffscreenPageLimit(3);
        binding.moviesTopVp.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);

        CompositePageTransformer compositePageTransformer = new CompositePageTransformer();
        compositePageTransformer.addTransformer(new MarginPageTransformer(10));

        binding.moviesTopVp.setPageTransformer(compositePageTransformer);

    }
}