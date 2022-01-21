package com.siddydevelops.blogaro.RecyclerViewAdapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.siddydevelops.blogaro.R;

public class TopicRVAdapter extends RecyclerView.Adapter<TopicRVAdapter.TopicViewHolder> {

    private String[] topicText;

    public TopicRVAdapter(String[] topicText) {
        this.topicText = topicText;
    }

    @NonNull
    @Override
    public TopicViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.topic_item_layout, parent,false);
        return new TopicViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TopicViewHolder holder, int position) {
        holder.topicText.setText(topicText[position]);
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
        }
    }
}
