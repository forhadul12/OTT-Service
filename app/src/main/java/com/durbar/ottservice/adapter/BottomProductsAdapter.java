package com.durbar.ottservice.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.durbar.ottservice.databinding.ProductWithDirectorAndWatchingCardBinding;

public class BottomProductsAdapter extends RecyclerView.Adapter<BottomProductsAdapter.mViewHolder> {

    @NonNull
    @Override
    public mViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new mViewHolder(ProductWithDirectorAndWatchingCardBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull mViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 20;
    }

    class mViewHolder extends RecyclerView.ViewHolder{
        ProductWithDirectorAndWatchingCardBinding binding;
        public mViewHolder(@NonNull ProductWithDirectorAndWatchingCardBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;
        }
    }
}
