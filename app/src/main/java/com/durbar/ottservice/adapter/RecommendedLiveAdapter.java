package com.durbar.ottservice.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.durbar.ottservice.databinding.MainProductWithoutTextCardBinding;

public class RecommendedLiveAdapter extends RecyclerView.Adapter<RecommendedLiveAdapter.mViewHolder> {


    @NonNull
    @Override
    public mViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new mViewHolder(MainProductWithoutTextCardBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull mViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 5;
    }

    class mViewHolder extends RecyclerView.ViewHolder{
        MainProductWithoutTextCardBinding binding;
        public mViewHolder(@NonNull MainProductWithoutTextCardBinding itemView) {
            super(itemView.getRoot());
            this.binding = itemView;
        }
    }
}
