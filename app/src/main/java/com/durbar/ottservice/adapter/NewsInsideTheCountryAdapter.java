package com.durbar.ottservice.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.durbar.ottservice.databinding.ProductWithPlayBtnForViewpagerCardBinding;
import com.squareup.picasso.Picasso;

import java.util.List;

public class NewsInsideTheCountryAdapter extends RecyclerView.Adapter<NewsInsideTheCountryAdapter.mViewHolder> {
    private List<String> images;

    public NewsInsideTheCountryAdapter(List<String> images) {
        this.images = images;
    }

    @NonNull
    @Override
    public mViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new mViewHolder(ProductWithPlayBtnForViewpagerCardBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull mViewHolder holder, int position) {
        holder.binding.thumbnailIv.setClipToOutline(true);
        Picasso.get().load(images.get(position)).fit().into(holder.binding.thumbnailIv);
    }

    @Override
    public int getItemCount() {
        return images != null ? images.size() : 0;
    }

    class mViewHolder extends RecyclerView.ViewHolder{

        ProductWithPlayBtnForViewpagerCardBinding binding;
        public mViewHolder(@NonNull ProductWithPlayBtnForViewpagerCardBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;
        }
    }
}
