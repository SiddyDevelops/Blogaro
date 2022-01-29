package com.siddydevelops.blogaro.RecyclerViewAdapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.google.android.material.imageview.ShapeableImageView;
import com.siddydevelops.blogaro.R;

public class BlogRVAdapter extends RecyclerView.Adapter<BlogRVAdapter.BlogViewHolder> {

    private String[] heading;
    private String[] subHeading;
    private String[] username;
    private String[] blogTime;
    private String[] profileIVSrc;
    private String[] blogCoverSrc;
    private String[] blogDesc;
    private String[] blogLikeCount;

    Context context;

    public BlogRVAdapter(String[] heading, String[] subHeading, String[] username, String[] blogTime, String[] profileIVSrc, String[] blogCoverSrc, String[] blogDesc, String[] blogLikeCount) {
        this.heading = heading;
        this.subHeading = subHeading;
        this.username = username;
        this.blogTime = blogTime;
        this.profileIVSrc = profileIVSrc;
        this.blogCoverSrc = blogCoverSrc;
        this.blogDesc = blogDesc;
        this.blogLikeCount = blogLikeCount;
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
        holder.username.setText(username[position]);
        holder.blogTime.setText(blogTime[position]);
        holder.likeBlog.setText(blogLikeCount[position]);
        holder.blogDesc.setText(blogDesc[position]);

        context = holder.itemView.getContext();

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

        Glide.with(context).load(profileIVSrc[position]).into(holder.profileImage);
        Glide.with(context).load(blogCoverSrc[position]).into(holder.blogCoverIV);

    }

    @Override
    public int getItemCount() {
        return heading.length;
    }

    public class BlogViewHolder extends RecyclerView.ViewHolder
    {
        TextView blogHeading;
        TextView blogSubHeading;
        TextView username;
        TextView blogTime;
        ImageView bookmarkIV;
        TextView blogDesc;
        ImageView profileImage;
        Button likeBlog;

        ShapeableImageView blogCoverIV;

        public BlogViewHolder(@NonNull View itemView) {
            super(itemView);
            blogHeading = itemView.findViewById(R.id.blogHeading);
            blogSubHeading = itemView.findViewById(R.id.blogSubHeading);
            bookmarkIV = itemView.findViewById(R.id.bookmarkIV);
            likeBlog = itemView.findViewById(R.id.likeBlogButton);
            username = itemView.findViewById(R.id.username);
            blogTime = itemView.findViewById(R.id.blogTime);
            blogDesc = itemView.findViewById(R.id.blogDesc);
            profileImage = itemView.findViewById(R.id.profile_image);
            blogCoverIV = itemView.findViewById(R.id.shapeableImageView);
        }
    }

}
