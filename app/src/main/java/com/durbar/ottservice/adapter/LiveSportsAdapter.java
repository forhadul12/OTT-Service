package com.durbar.ottservice.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.durbar.ottservice.databinding.ProductWithPlayBtnForRvCardBinding;

import java.util.List;

public class LiveSportsAdapter extends RecyclerView.Adapter<LiveSportsAdapter.mViewHolder> {


    @NonNull
    @Override
    public mViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new mViewHolder(ProductWithPlayBtnForRvCardBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull mViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 5;
    }

    class mViewHolder extends RecyclerView.ViewHolder{
        ProductWithPlayBtnForRvCardBinding binding;
        public mViewHolder(@NonNull ProductWithPlayBtnForRvCardBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;
        }
    }
}
