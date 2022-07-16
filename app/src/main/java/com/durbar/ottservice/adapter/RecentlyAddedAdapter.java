package com.durbar.ottservice.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.durbar.ottservice.databinding.MainProductCardBinding;

public class RecentlyAddedAdapter extends RecyclerView.Adapter<RecentlyAddedAdapter.mViewHolder> {

    @NonNull
    @Override
    public mViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_product_cart, parent, false);
        //MainProductCartBinding binding = MainProductCartBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new mViewHolder(MainProductCardBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull mViewHolder holder, int position) {
        holder.binding.thumbnailIv.setClipToOutline(true);

      /*  String image = "https://images.unsplash.com/photo-1503023345310-bd7c1de61c7d?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=465&q=80";

        Picasso.get().load(image).fit().into(holder.binding.thumbnailIv);
*/

    }

    @Override
    public int getItemCount() {
        return 5;
    }

    class mViewHolder extends RecyclerView.ViewHolder{
        MainProductCardBinding binding;
        public mViewHolder(MainProductCardBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;
        }
    }
}
