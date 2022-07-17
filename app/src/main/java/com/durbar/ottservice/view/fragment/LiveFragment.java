package com.durbar.ottservice.view.fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.durbar.ottservice.R;
import com.durbar.ottservice.adapter.RecommendedLiveAdapter;
import com.durbar.ottservice.databinding.FragmentLiveBinding;
import com.durbar.ottservice.utils.CallBack;


public class LiveFragment extends Fragment {


    //binding
    private FragmentLiveBinding binding;

    //OnClick
    //CallBack
    private final CallBack.TabOnClick callBack;

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

        binding.fragLiveRecommendedLiveRv.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        binding.fragLiveRecommendedLiveRv.setAdapter(new RecommendedLiveAdapter());

        binding.fragLiveTabHome.setOnClickListener(view1 -> {
            callBack.tabHomeOnClickCallBack();
        });
    }
}