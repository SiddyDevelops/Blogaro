package com.siddydevelops.blogaro.RecyclerViewAdapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.siddydevelops.blogaro.R;

public class ProfileRVAdapter extends RecyclerView.Adapter<ProfileRVAdapter.ProfileViewHolder> {

    private String[] titles;
    private String[] subTitles;

    public ProfileRVAdapter(String[] titles, String[] subTitles) {
        this.titles = titles;
        this.subTitles = subTitles;
    }

    @NonNull
    @Override
    public ProfileRVAdapter.ProfileViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater =LayoutInflater.from(parent.getContext());
        View view= inflater.inflate(R.layout.profile_rv_item_layout, parent,false);
        return new ProfileViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProfileRVAdapter.ProfileViewHolder holder, int position) {
        holder.title.setText(titles[position]);
        holder.subTitle.setText(subTitles[position]);
    }

    @Override
    public int getItemCount() {
        return titles.length;
    }

    public class ProfileViewHolder extends RecyclerView.ViewHolder {

        TextView title;
        TextView subTitle;

        public ProfileViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.title);
            subTitle = itemView.findViewById(R.id.subTitle);

        }
    }
}
