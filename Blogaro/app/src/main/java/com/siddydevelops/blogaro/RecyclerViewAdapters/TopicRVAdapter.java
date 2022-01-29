package com.siddydevelops.blogaro.RecyclerViewAdapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.siddydevelops.blogaro.R;
import com.yarolegovich.discretescrollview.DiscreteScrollView;

public class TopicRVAdapter extends RecyclerView.Adapter<TopicRVAdapter.TopicViewHolder> {

    private String[] topicText;
    private String[] topiCoverSrc;
    private DiscreteScrollView discreteScrollView;
    Context context;

    PassContextInterface listner;

    public TopicRVAdapter(String[] topicText, String[] topiCoverSrc, DiscreteScrollView discreteScrollView, PassContextInterface listner) {
        this.topicText = topicText;
        this.topiCoverSrc = topiCoverSrc;
        this.discreteScrollView = discreteScrollView;
        this.listner = listner;
    }

    @NonNull
    @Override
    public TopicViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        discreteScrollView.scrollToPosition(2);
        //discreteScrollView.smoothScrollToPosition(2);
        View view = inflater.inflate(R.layout.topic_item_layout, parent,false);
        return new TopicViewHolder(view,listner);
    }

    @Override
    public void onBindViewHolder(@NonNull TopicViewHolder holder, int position) {
        context = holder.itemView.getContext();
        holder.topicText.setText(topicText[position]);
        Glide.with(context).load(topiCoverSrc[position]).into(holder.topicCover);

        holder.topicItemCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Log.i("PostitionPlacement: ",position+"");
                listner.onItemClick(position);
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
        ImageView topicCover;
        PassContextInterface listner;

        public TopicViewHolder(@NonNull View itemView, PassContextInterface listner) {
            super(itemView);
            topicText = itemView.findViewById(R.id.topicText);
            topicItemCV = itemView.findViewById(R.id.topicItemCV);
            topicCover = itemView.findViewById(R.id.topicCover);
            this.listner = listner;
        }
    }

    public interface PassContextInterface
    {
        void onItemClick(Integer pos);
    }

}
