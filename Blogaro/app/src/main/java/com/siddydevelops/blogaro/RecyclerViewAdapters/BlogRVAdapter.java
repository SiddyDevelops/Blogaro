package com.siddydevelops.blogaro.RecyclerViewAdapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.siddydevelops.blogaro.R;

public class BlogRVAdapter extends RecyclerView.Adapter<BlogRVAdapter.BlogViewHolder> {

    private String[] heading;
    private String[] subHeading;

    public BlogRVAdapter(String[] heading, String[] subHeading) {
        this.heading = heading;
        this.subHeading = subHeading;
    }

    @NonNull
    @Override
    public BlogRVAdapter.BlogViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.article_item_layout, parent,false);
        return new BlogViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BlogRVAdapter.BlogViewHolder holder, int position) {
        holder.blogHeading.setText(heading[position]);
        holder.blogSubHeading.setText(subHeading[position]);

        holder.bookmarkIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view.isActivated())
                    view.setActivated(false);
                else
                    view.setActivated(true);
            }
        });

        holder.likeBlog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view.isActivated())
                    view.setActivated(false);
                else
                    view.setActivated(true);
            }
        });

    }

    @Override
    public int getItemCount() {
        return heading.length;
    }

    public class BlogViewHolder extends RecyclerView.ViewHolder
    {
        TextView blogHeading;
        TextView blogSubHeading;
        ImageView bookmarkIV;
        Button likeBlog;

        public BlogViewHolder(@NonNull View itemView) {
            super(itemView);
            blogHeading = itemView.findViewById(R.id.blogHeading);
            blogSubHeading = itemView.findViewById(R.id.blogSubHeading);
            bookmarkIV = itemView.findViewById(R.id.bookmarkIV);
            likeBlog = itemView.findViewById(R.id.likeBlogButton);
        }
    }

}
