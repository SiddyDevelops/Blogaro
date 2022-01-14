package com.siddydevelops.blogaro.RecyclerViewAdapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.siddydevelops.blogaro.R;

public class FollRVAdapter extends RecyclerView.Adapter<FollRVAdapter.FollViewHolder> {

    private String[] userID;
    private String[] userName;
    private String[] userSpec;

    public FollRVAdapter(String[] userID, String[] userName, String[] userSpec) {
        this.userID = userID;
        this.userName = userName;
        this.userSpec = userSpec;
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
        holder.userID.setText(userID[position]);
        holder.userName.setText(userName[position]);
        holder.userSpec.setText(userSpec[position]);
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
        public FollViewHolder(@NonNull View itemView) {
            super(itemView);
            userID = itemView.findViewById(R.id.userID);
            userName = itemView.findViewById(R.id.userName);
            userSpec = itemView.findViewById(R.id.userSpec);
        }
    }

}
