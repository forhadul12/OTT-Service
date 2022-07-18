package com.durbar.ottservice.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.durbar.ottservice.databinding.HomeSliderCardBinding;
import com.squareup.picasso.Picasso;

import java.util.List;

public class SliderAdapter extends RecyclerView.Adapter<SliderAdapter.mViewHolder> {
    private ViewPager2 viewPager2;
    private List<String> images;

    public SliderAdapter(ViewPager2 viewPager2, List<String> images) {
        this.viewPager2 = viewPager2;
        this.images = images;
    }

    @NonNull
    @Override
    public mViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new mViewHolder(HomeSliderCardBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull mViewHolder holder, int position) {

        Picasso.get().load(images.get(position)).fit().into(holder.binding.sliderThumbnailIv);

        /*if (position == images.size() - 2){
            viewPager2.post(runnable);
        }*/

    }

    @Override
    public int getItemCount() {
        return images != null ? images.size():0;
    }

    class mViewHolder extends RecyclerView.ViewHolder{
        HomeSliderCardBinding binding;
       public mViewHolder(@NonNull HomeSliderCardBinding itemView) {
           super(itemView.getRoot());
           binding = itemView;
       }
   }



   /*private Runnable runnable = new Runnable() {
       @Override
       public void run() {
           images.addAll(images);
           notifyDataSetChanged();
       }
   };*/
}
