package com.siddydevelops.blogaro.RecyclerViewAdapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
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
        View view = inflater.inflate(R.layout.topic_item_layout, parent,false);
        return new TopicViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TopicViewHolder holder, int position) {
        holder.topicText.setText(topicText[position]);
        discreteScrollView.smoothScrollToPosition(2);
    }

    @Override
    public int getItemCount() {
        return topicText.length;
    }

    public class TopicViewHolder extends RecyclerView.ViewHolder
    {
        TextView topicText;
        public TopicViewHolder(@NonNull View itemView) {
            super(itemView);
            topicText = itemView.findViewById(R.id.topicText);
            discreteScrollView.smoothScrollToPosition(2);
        }
    }
}
