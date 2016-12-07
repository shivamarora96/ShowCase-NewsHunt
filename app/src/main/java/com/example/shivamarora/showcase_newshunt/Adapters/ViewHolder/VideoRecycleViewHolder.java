package com.example.shivamarora.showcase_newshunt.Adapters.ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.example.shivamarora.showcase_newshunt.R;

import java.util.zip.Inflater;

/**
 * Created by ShivamArora on 04-12-2016.
 */

public class VideoRecycleViewHolder extends RecyclerView.ViewHolder {


    //TODO .. member of child view
    TextView  textView ;

    public VideoRecycleViewHolder(View itemView) {


        //TODO find child view by id

        super(itemView);

        textView = (TextView)itemView.findViewById(R.id.customTextView_child) ;

    }

    public TextView getTextView() {
        return textView;
    }

    public void setTextView(TextView textView) {
        this.textView = textView;
    }
}
