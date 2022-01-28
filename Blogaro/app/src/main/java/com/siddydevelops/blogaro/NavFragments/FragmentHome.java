package com.siddydevelops.blogaro.NavFragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.siddydevelops.blogaro.R;
import com.siddydevelops.blogaro.RecyclerViewAdapters.ProfileRVAdapter;
import com.siddydevelops.blogaro.RecyclerViewAdapters.TopicRVAdapter;
import com.yarolegovich.discretescrollview.DiscreteScrollView;
import com.yarolegovich.discretescrollview.transform.Pivot;
import com.yarolegovich.discretescrollview.transform.ScaleTransformer;

public class FragmentHome extends Fragment {

    RecyclerView blogsRVHome;
    String[] topicText = {"Science","Entertainment","Technology","Education","News","Sports"};
    String[] titles = {"Big Data", "UX Design", "Big Data", "UX Design", "Big Data", "UX Design"};
    String[] subTitles = {"Why Big Data Needs Thick Data?", "Step Design sprint for UX beginner", "Why Big Data Needs Thick Data?", "Step Design sprint for UX beginner","Why Big Data Needs Thick Data?", "Step Design sprint for UX beginner"};
    String[] blogPostSrc = {"https://raw.githubusercontent.com/SiddyDevelops/Blogaro/main/Assets/Blog-Posts/blogpost1.jpeg","https://raw.githubusercontent.com/SiddyDevelops/Blogaro/main/Assets/Blog-Posts/blogpost2.png","https://raw.githubusercontent.com/SiddyDevelops/Blogaro/main/Assets/Blog-Posts/blogpost3.png","https://raw.githubusercontent.com/SiddyDevelops/Blogaro/main/Assets/Blog-Posts/blogpost1.jpeg","https://raw.githubusercontent.com/SiddyDevelops/Blogaro/main/Assets/Blog-Posts/blogpost2.png","https://raw.githubusercontent.com/SiddyDevelops/Blogaro/main/Assets/Blog-Posts/blogpost3.png"};


    ImageView iv_addBlog;

    Context context;
    DiscreteScrollView scrollView;

    public FragmentHome() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        iv_addBlog = getActivity().findViewById(R.id.iv_addBlog);
        iv_addBlog.setImageDrawable(getResources().getDrawable(R.drawable.ic_plus));
        iv_addBlog.setBackgroundResource(R.drawable.bg_center_nav);

        blogsRVHome = view.findViewById(R.id.blogsRVHome);
        scrollView = view.findViewById(R.id.discreteSV);

        scrollView.setItemTransformer(new ScaleTransformer.Builder()
                .setMaxScale(1.0f)
                .setMinScale(0.8f)
                .setPivotX(Pivot.X.CENTER) // CENTER is a default one
                .setPivotY(Pivot.Y.BOTTOM) // CENTER is a default one
                .build());
        scrollView.setAdapter(new TopicRVAdapter(topicText,scrollView));

        blogsRVHome.setLayoutManager(new LinearLayoutManager(context));
        blogsRVHome.setAdapter(new ProfileRVAdapter(titles, subTitles,blogPostSrc,1));
    }
}