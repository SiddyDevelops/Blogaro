package com.siddydevelops.blogaro.RecyclerViewAdapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.siddydevelops.blogaro.R;

public class FollRVAdapter extends RecyclerView.Adapter<FollRVAdapter.FollViewHolder> {

    private String[] userID;
    private String[] userName;
    private String[] userSpec;
    private String[] userProfileIV;
    Context context;

    public FollRVAdapter(String[] userID, String[] userName, String[] userSpec, String[] userProfileIV) {
        this.userID = userID;
        this.userName = userName;
        this.userSpec = userSpec;
        this.userProfileIV = userProfileIV;
    }

    @NonNull
    @Override
    public FollRVAdapter.FollViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater =LayoutInflater.from(parent.getContext());
        View view= inflater.inflate(R.layout.profile_foll_rv_item, parent,false);
        return new FollViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FollRVAdapter.FollViewHolder holder, int position) {
        context = holder.itemView.getContext();
        holder.userID.setText(userID[position]);
        holder.userName.setText(userName[position]);
        holder.userSpec.setText(userSpec[position]);
        Glide.with(context).load(userProfileIV[position]).into(holder.userprofileIV);
    }

    @Override
    public int getItemCount() {
        return userID.length;
    }


    public class FollViewHolder extends RecyclerView.ViewHolder
    {
        TextView userID;
        TextView userName;
        TextView userSpec;
        ImageView userprofileIV;

        public FollViewHolder(@NonNull View itemView) {
            super(itemView);
            userID = itemView.findViewById(R.id.userID);
            userName = itemView.findViewById(R.id.userName);
            userSpec = itemView.findViewById(R.id.userSpec);
            userprofileIV = itemView.findViewById(R.id.userprofileIV);
        }
    }

}
