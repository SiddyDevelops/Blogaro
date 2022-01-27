package com.siddydevelops.blogaro.NavFragments;

import android.content.Context;
import android.content.Intent;
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

import com.siddydevelops.blogaro.MainDashboard;
import com.siddydevelops.blogaro.R;
import com.siddydevelops.blogaro.RecyclerViewAdapters.BlogRVAdapter;

public class FragmentArticles extends Fragment {

    Context context;
    ImageView backIV;
    RecyclerView blogRecyclerView;

    String[] heading = {"Android Cold Start and Buffer Screen", "Publishing android libraries to Jitpack with Gradle 7.+", "Top Android UI Libraries"};
    String[] subHeading = {"Create an efficient splash screen", "Deploying you own libs", "Libraries from Valhalla"};
    String[] blogCoverSrc = {"https://raw.githubusercontent.com/SiddyDevelops/Blogaro/main/Assets/Blog-Posts/blogpost1.jpeg","https://raw.githubusercontent.com/SiddyDevelops/Blogaro/main/Assets/Blog-Posts/blogpost2.png","https://raw.githubusercontent.com/SiddyDevelops/Blogaro/main/Assets/Blog-Posts/blogpost3.png"};
    String[] username = {"Siddharth Singh","Micheal Daze","Joseph Gonzalez"};
    String[] blogTime = {"1hr ago","6hr ago","Previous Day"};
    String[] profileIVSrc = {"https://raw.githubusercontent.com/SiddyDevelops/Blogaro/main/Assets/Profile-Images/me_photo.jpg","https://raw.githubusercontent.com/SiddyDevelops/Blogaro/main/Assets/Profile-Images/michael_daze.jpg","https://raw.githubusercontent.com/SiddyDevelops/Blogaro/main/Assets/Profile-Images/joseph_gonzalez.jpg"};
    String[] blogDesc = {"What makes an android app complete? Implementing functionalities, view, activities, using databases, adding animations, adding the perfect theme to go with the app, etc. might be the answer. But as developers, we always forget about one important thing, the first impression, i.e. Splash Screen. Even though some of us remember to implement it, we don’t like how a short-bright-white-screen ruins the splash screen, whenever we launch an android app. Have you ever wondered, why this white screen appears before the Splash-Screen? Refer to the blog below to learn more about a splash screen and how to create one.","Android frameworks and libraries (or just libraries in general) are a set of implementations of behaviour that are written in programming languages and have a well-defined interface. Android libraries are developed and published to help out the developers and ease the process of building android apps.\n" +
            "Gradle 7.+ is the next step in Gradle’s evolution in build automation and developer productivity. With the latest release of Gradle and its modules, the process of publishing an android library is slightly changed.","Have you ever wondered while developing apps, “How can I reach more people? How can I attract more users to use my app?” The answer is simple yet difficult to understand. Nowadays, users tend to prefer apps that have user-friendly interactions over old-age static apps. Besides, an interactive app would brighten up the user’s expectations while using the app.\n" +
            "Using libraries that are easily available over Github is one of the best ways to add interactive functionality and provide users with the missing element in the app."};
    String[] blogLikeCount = {"2.1K","12.3K","5.8K"};


    public FragmentArticles() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_articles, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        blogRecyclerView = view.findViewById(R.id.blogRecyclerView);
        backIV = view.findViewById(R.id.backIV);

        blogRecyclerView.setLayoutManager(new LinearLayoutManager(context));
        blogRecyclerView.setAdapter(new BlogRVAdapter(heading,subHeading,username,blogTime,profileIVSrc,blogCoverSrc,blogDesc,blogLikeCount));

        backIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), MainDashboard.class);
                startActivity(intent);
            }
        });
    }
}