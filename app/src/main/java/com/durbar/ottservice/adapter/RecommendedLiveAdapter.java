package com.durbar.ottservice.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.durbar.ottservice.databinding.RecommendedLiveCardBinding;

public class RecommendedLiveAdapter extends RecyclerView.Adapter<RecommendedLiveAdapter.mViewHolder> {


    @NonNull
    @Override
    public mViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new mViewHolder(RecommendedLiveCardBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull mViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 5;
    }

    class mViewHolder extends RecyclerView.ViewHolder{
        RecommendedLiveCardBinding binding;
        public mViewHolder(@NonNull RecommendedLiveCardBinding itemView) {
            super(itemView.getRoot());
            this.binding = itemView;
        }
    }
}
