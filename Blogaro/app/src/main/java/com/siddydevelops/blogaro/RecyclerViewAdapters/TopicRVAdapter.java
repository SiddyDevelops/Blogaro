package com.siddydevelops.blogaro.RecyclerViewAdapters;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.siddydevelops.blogaro.R;
import com.yarolegovich.discretescrollview.DiscreteScrollView;

public class TopicRVAdapter extends RecyclerView.Adapter<TopicRVAdapter.TopicViewHolder> {

    private String[] topicText;
    private DiscreteScrollView discreteScrollView;

    public TopicRVAdapter(String[] topicText, DiscreteScrollView discreteScrollView) {
        this.topicText = topicText;
        this.discreteScrollView = discreteScrollView;
    }

    @NonNull
    @Override
    public TopicViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        discreteScrollView.scrollToPosition(2);
        //discreteScrollView.smoothScrollToPosition(2);
        View view = inflater.inflate(R.layout.topic_item_layout, parent,false);
        return new TopicViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TopicViewHolder holder, int position) {
        holder.topicText.setText(topicText[position]);

        holder.topicItemCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("PostitionPlacement: ",position+"");
            }
        });

    }

    @Override
    public int getItemCount() {
        return topicText.length;
    }

    public class TopicViewHolder extends RecyclerView.ViewHolder
    {
        TextView topicText;
        CardView topicItemCV;
        public TopicViewHolder(@NonNull View itemView) {
            super(itemView);
            topicText = itemView.findViewById(R.id.topicText);
            topicItemCV = itemView.findViewById(R.id.topicItemCV);
        }
    }
}
