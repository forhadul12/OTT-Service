package com.durbar.ottservice.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.durbar.ottservice.databinding.MainProductWithTextForGridCardBinding;

public class WatchTrailerAdapter extends RecyclerView.Adapter<WatchTrailerAdapter.mViewHolder> {

    @NonNull
    @Override
    public mViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new mViewHolder(MainProductWithTextForGridCardBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull mViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 20;
    }

    class mViewHolder extends RecyclerView.ViewHolder{
        MainProductWithTextForGridCardBinding binding;
        public mViewHolder(@NonNull MainProductWithTextForGridCardBinding itemView) {
            super(itemView.getRoot());
        }
    }
}
