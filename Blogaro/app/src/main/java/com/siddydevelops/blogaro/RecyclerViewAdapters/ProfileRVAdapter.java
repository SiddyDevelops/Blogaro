package com.siddydevelops.blogaro.RecyclerViewAdapters;

import android.content.Context;
import android.graphics.Color;
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

public class ProfileRVAdapter extends RecyclerView.Adapter<ProfileRVAdapter.ProfileViewHolder> {

    private String[] titles;
    private String[] subTitles;
    private String[] blogPostSrc;
    private int CV_LAYOUT;

    Context context;

    public ProfileRVAdapter(String[] titles, String[] subTitles, String[] blogPostSrc, int CV_LAYOUT) {
        this.titles = titles;
        this.subTitles = subTitles;
        this.blogPostSrc = blogPostSrc;
        this.CV_LAYOUT = CV_LAYOUT;
    }

    @NonNull
    @Override
    public ProfileRVAdapter.ProfileViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.profile_rv_item_layout, parent,false);
        return new ProfileViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProfileRVAdapter.ProfileViewHolder holder, int position) {
        holder.title.setText(titles[position]);
        holder.subTitle.setText(subTitles[position]);

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

        Glide.with(context).load(blogPostSrc[position]).into(holder.blogPostIV);

        if(CV_LAYOUT == 1)
        {
            holder.layoutCV.setCardBackgroundColor(Color.WHITE);
        }

    }

    @Override
    public int getItemCount() {
        return titles.length;
    }

    public class ProfileViewHolder extends RecyclerView.ViewHolder {

        TextView title;
        TextView subTitle;
        ImageView bookmarkIV;
        ImageView blogPostIV;
        CardView layoutCV;

        public ProfileViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.title);
            subTitle = itemView.findViewById(R.id.subTitle);
            bookmarkIV = itemView.findViewById(R.id.bookmarkIV);
            blogPostIV = itemView.findViewById(R.id.blogPostIV);
            layoutCV = itemView.findViewById(R.id.layoutCV);
        }
    }
}
