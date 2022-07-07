package com.durbar.ottservice.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.durbar.ottservice.R;

public class RecentlyAddedAdapter extends RecyclerView.Adapter<RecentlyAddedAdapter.mViewHolder> {

    @NonNull
    @Override
    public mViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_product_cart, parent, false);
        return new mViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull mViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 5;
    }

    class mViewHolder extends RecyclerView.ViewHolder{

        public mViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
