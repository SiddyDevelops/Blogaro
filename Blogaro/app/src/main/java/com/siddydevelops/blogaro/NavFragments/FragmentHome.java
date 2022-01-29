package com.siddydevelops.blogaro.NavFragments;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.util.Log;
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

public class FragmentHome extends Fragment implements TopicRVAdapter.PassContextInterface {

    RecyclerView blogsRVHome;
    String[] topicText = {"Science","Movies","Technology","Education","News","Sports"};
    String[] topiCoverSrc = {"https://raw.githubusercontent.com/SiddyDevelops/Blogaro/main/Assets/Topic-Cover/cover01.jpg","https://raw.githubusercontent.com/SiddyDevelops/Blogaro/main/Assets/Topic-Cover/cover02.jpg","https://raw.githubusercontent.com/SiddyDevelops/Blogaro/main/Assets/Topic-Cover/cover03.jpeg","https://raw.githubusercontent.com/SiddyDevelops/Blogaro/main/Assets/Topic-Cover/cover04.jpg","https://raw.githubusercontent.com/SiddyDevelops/Blogaro/main/Assets/Topic-Cover/cover05.jpg","https://raw.githubusercontent.com/SiddyDevelops/Blogaro/main/Assets/Topic-Cover/cover06.jpg"};

    String[] titles0 = {"Brain & Behavior","Life & Non-Humans","Bacteira of Champions"};
    String[] subTitles0 = {"What is IQ and EQ?", "Recreating Life","Bacterias friend or foe?"};
    String[] blogPostSrc0 = {"https://e7.pngegg.com/pngimages/935/371/png-clipart-meditation-the-cartoon-animation-brain-people-computer-wallpaper.png","https://ggsc.s3.amazonaws.com/images/uploads/purpose-FB.jpg","https://st.depositphotos.com/1252248/3787/v/600/depositphotos_37873965-stock-illustration-the-accumulation-of-bacteria.jpg"};

    String[] titles1 = {"Top Netflix shows of 2021","Look behind the camera","The Witcher Season 2 Review","Book vs. film"};
    String[] subTitles1 = {"Binge Watch your favourites now", "Life on set and what happens BTS","Don't miss the action of Henry Cavil", "How J.K Rowling portrayed Harry Potter"};
    String[] blogPostSrc1 = {"https://static1.colliderimages.com/wordpress/wp-content/uploads/2020/11/Best-tv-shows-Netflix-V3.jpg","https://www.boredpanda.com/blog/wp-content/uuuploads/behind-the-scenes-from-famous-movies/behind-the-scenes-from-famous-movies-38b.jpg","https://upload.wikimedia.org/wikipedia/en/2/23/The_Witcher_Title_Card.png","https://pbs.twimg.com/profile_images/1480600300624826372/e1bYETBc.jpg"};

    String[] titles2 = {"Big Data", "UX Design", "Web Processes", "Design Thinking", "AI and ML", "Data and Configurations"};
    String[] subTitles2 = {"Why Big Data Needs Thick Data?", "Step Design sprint for UX beginner", "Beyond HTML and Javascript","Importance of DT in CS", "Beauty of Automated Tech", "Design DataBases and manage BigData"};
    String[] blogPostSrc2 = {"https://miro.medium.com/max/1024/0*QxsWlMTDGmTebavF.jpg","https://xd.adobe.com/ideas/wp-content/uploads/2020/11/ux_design_process.png","https://www.elegantthemes.com/blog/wp-content/uploads/2018/12/min21.png","https://t3.ftcdn.net/jpg/00/90/82/02/360_F_90820258_iwaPVoyal39p5giyEnaG8qXASSZ3LI7t.jpg","https://aeti.in/wp-content/uploads/group-avatars/4/5e81b08ce66fa-bpfull.png","https://png.pngtree.com/png-vector/20190115/ourlarge/pngtree-server-cartoon-database-the-internet-file-transfer-png-image_356844.jpg"};

    String[] titles3 = {"The Knowledge Tree","Digital Writing and Teaching","Easy school recipes","Student success stories"};
    String[] subTitles3 = {"A all in one book for students", "Technology affecting education","Healthy lunchbox ideas", "Spotlighting the success stories"};
    String[] blogPostSrc3 = {"https://t4.ftcdn.net/jpg/02/31/89/41/360_F_231894152_4pmzErlXAHx6JWYPOoAA2YQ7sE8hx18r.jpg","https://www.ibef.org//uploads/blog/10-8-2021_blog_digital_education.jpg","https://st3.depositphotos.com/12362248/15370/v/600/depositphotos_153705482-stock-illustration-lunchbox-with-food-meal-apple.jpg","https://images.squarespace-cdn.com/content/v1/5da9c262b178d1554e8b160e/1580471398808-DJCKU59YVNBHMJQP83ZQ/secret-to-success.jpg"};

    String[] titles4 = {"The COVID Effect","Rise of new technology","Feminism"};
    String[] subTitles4 = {"How Covid hit the World", "New tech, New Ambitions","What is feminism?"};
    String[] blogPostSrc4 = {"https://www.fhi.no/globalassets/bilder/korona/koronavirusbla-03.png","https://wallpaperaccess.com/full/210901.jpg","https://images.pexels.com/photos/3831881/pexels-photo-3831881.jpeg"};

    String[] titles5 = {"10 great squash courts","Advantages of Protein Supplements","Workout exercises for couples"};
    String[] subTitles5 = {"Hit and Reflect", "Health ~ Energy","Exercise with your loved one"};
    String[] blogPostSrc5 = {"https://i.pinimg.com/564x/b8/2c/b0/b82cb0994ca63126bfa8532994a523d9.jpg","https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/cropped-hand-holding-ground-protein-in-scoop-at-royalty-free-image-1589373439.jpg","https://thumbs.dreamstime.com/b/man-woman-exercising-set-fitness-couple-doing-exercise-gym-cartoon-vector-illustrations-man-woman-exercising-set-108425475.jpg"};

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
        scrollView.setAdapter(new TopicRVAdapter(topicText,topiCoverSrc,scrollView,this));

        blogsRVHome.setLayoutManager(new LinearLayoutManager(context));
        blogsRVHome.setAdapter(new ProfileRVAdapter(titles2, subTitles2,blogPostSrc2,1));
    }

    @Override
    public void onItemClick(Integer pos) {
        Log.i("ActivityPosition: ",pos.toString());
        switch(pos)
        {
            case 0: blogsRVHome.setAdapter(new ProfileRVAdapter(titles0, subTitles0,blogPostSrc0,1));  //SCIENCE
                break;
            case 1: blogsRVHome.setAdapter(new ProfileRVAdapter(titles1, subTitles1,blogPostSrc1,1)); //Movies
                break;
            case 2: blogsRVHome.setAdapter(new ProfileRVAdapter(titles2, subTitles2,blogPostSrc2,1)); //Technology
                break;
            case 3: blogsRVHome.setAdapter(new ProfileRVAdapter(titles3, subTitles3,blogPostSrc3,1)); //Education
                break;
            case 4: blogsRVHome.setAdapter(new ProfileRVAdapter(titles4, subTitles4,blogPostSrc4,1)); //Sports
                break;
            case 5: blogsRVHome.setAdapter(new ProfileRVAdapter(titles5, subTitles5,blogPostSrc5,1)); //News
                break;
        }
    }
}