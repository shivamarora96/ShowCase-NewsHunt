package com.example.shivamarora.showcase_newshunt.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.example.shivamarora.showcase_newshunt.Adapters.ViewHolder.VideoRecycleViewHolder;
import com.example.shivamarora.showcase_newshunt.R;

import java.util.ArrayList;

/**
 * Created by ShivamArora on 04-12-2016.
 */

public class VideoRecyclerViewAdapter extends RecyclerView.Adapter<VideoRecycleViewHolder>{

    Context context ;
    ArrayList<String> data;

    public VideoRecyclerViewAdapter(Context context, ArrayList<String> data) {
        this.context = context;
        this.data = data;

    }

    @Override
    public VideoRecycleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

       View v =  LayoutInflater.from(context).inflate(R.layout.custom_recycler_view_child , parent , false) ;
        VideoRecycleViewHolder videoRecycleViewHolder = new VideoRecycleViewHolder(v) ;
        return videoRecycleViewHolder;
    }

    @Override
    public void onBindViewHolder(VideoRecycleViewHolder holder, int position) {

         String currentString =    data.get(position) ;
          holder.getTextView().setText("currentString");

    }


    @Override
    public int getItemCount() {
        return data.size();
    }
}
