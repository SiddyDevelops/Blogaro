package com.siddydevelops.blogaro.RecyclerViewAdapters;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.siddydevelops.blogaro.R;

public class ProfileRVAdapter extends RecyclerView.Adapter<ProfileRVAdapter.ProfileViewHolder> {

    private String[] titles;
    private String[] subTitles;
    private int CV_LAYOUT;

    public ProfileRVAdapter(String[] titles, String[] subTitles, int CV_LAYOUT) {
        this.titles = titles;
        this.subTitles = subTitles;
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

        holder.bookmarkIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view.isActivated())
                    view.setActivated(false);
                else
                    view.setActivated(true);
            }
        });

        if(CV_LAYOUT == 1)
        {
            holder.layoutCV.setBackgroundColor(Color.WHITE);
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
        CardView layoutCV;

        public ProfileViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.title);
            subTitle = itemView.findViewById(R.id.subTitle);
            bookmarkIV = itemView.findViewById(R.id.bookmarkIV);
            layoutCV = itemView.findViewById(R.id.layoutCV);
        }
    }
}
