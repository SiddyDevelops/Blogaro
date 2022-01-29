package com.siddydevelops.blogaro;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.siddydevelops.blogaro.RecyclerViewAdapters.FollRVAdapter;
import com.siddydevelops.blogaro.RecyclerViewAdapters.ProfileRVAdapter;
import java.util.Objects;

public class BottomSheetDialog extends BottomSheetDialogFragment {

    TextView bottomSheetHeading;
    RecyclerView profile_rv;
    Context context;

    String[] titles = {"NPM Modules & Activities", "UX Design", "Big Data"};
    String[] subTitles = {"Introduction to NPM and its Use", "Step Design sprint for UX beginner", "Why Big Data Needs Thick Data?"};
    String[] blogPostSrc = {"https://raw.githubusercontent.com/SiddyDevelops/Blogaro/main/Assets/Buffer-BlogPosts/post01.jpg","https://raw.githubusercontent.com/SiddyDevelops/Blogaro/main/Assets/Buffer-BlogPosts/post02.jpg","https://raw.githubusercontent.com/SiddyDevelops/Blogaro/main/Assets/Buffer-BlogPosts/post03.png"};

    String[] userID = {"@SiddyDevelops","@MikyDaze","@UncleFifi","@tyler_nix","@usman_yousaf"};
    String[] userName = {"Siddharth Singh","Micheal Daze","Joseph Gonzalez","Tyler Nix","Usman Yousaf"};
    String[] userSpec = {"Android Developer","Lifestyle Entrepreneur","Financial Advisor","Marketing Salesman","Web Designer"};
    String[] userProfileIV = {"https://raw.githubusercontent.com/SiddyDevelops/Blogaro/main/Assets/Profile-Images/me_photo.jpg","https://raw.githubusercontent.com/SiddyDevelops/Blogaro/main/Assets/Profile-Images/michael_daze.jpg","https://raw.githubusercontent.com/SiddyDevelops/Blogaro/main/Assets/Profile-Images/joseph_gonzalez.jpg","https://raw.githubusercontent.com/SiddyDevelops/Blogaro/main/Assets/Profile-Images/tyler_nix.jpg","https://raw.githubusercontent.com/SiddyDevelops/Blogaro/main/Assets/Profile-Images/usman_yousaf.jpg"};

    String[] userIDF = {"@SiddyDevelops","@ali_morshedlou","@ayo_ogunseinde","@ben_den_engelsen","@ben_parker","@christina","@christina_lewis","@luis_villasmil","@roland_cousins"};
    String[] userNameF = {"Siddharth Singh","Ali Morshedlou","Ayo Ogunseinde","Ben Den Engelsen","Ben Parker","Christina","Christina Lewis","Luis Villasmil","Roland Cousins"};
    String[] userSpecF = {"Android Developer","UI/UX Designer","Infulencer","Interior Designer","LGTBQ Activist","Nature Lover","Chef","Sportsman","Comics Writer"};
    String[] userProfileIVF = {"https://raw.githubusercontent.com/SiddyDevelops/Blogaro/main/Assets/Profile-Images/me_photo.jpg","https://raw.githubusercontent.com/SiddyDevelops/Blogaro/main/Assets/Profile-Images/ali_morshedlou.jpg","https://raw.githubusercontent.com/SiddyDevelops/Blogaro/main/Assets/Profile-Images/ayo_ogunseinde.jpg","https://raw.githubusercontent.com/SiddyDevelops/Blogaro/main/Assets/Profile-Images/ben_den_engelsen.jpg","https://raw.githubusercontent.com/SiddyDevelops/Blogaro/main/Assets/Profile-Images/ben_parker.jpg","https://raw.githubusercontent.com/SiddyDevelops/Blogaro/main/Assets/Profile-Images/christina.jpg","https://raw.githubusercontent.com/SiddyDevelops/Blogaro/main/Assets/Profile-Images/christina_lewis.jpg","https://raw.githubusercontent.com/SiddyDevelops/Blogaro/main/Assets/Profile-Images/luis_villasmil.jpg","https://raw.githubusercontent.com/SiddyDevelops/Blogaro/main/Assets/Profile-Images/roland_cousins.jpg"};


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.profile_bottom_sheet,container,false);
        bottomSheetHeading = view.findViewById(R.id.bottomSheetHeading);
        profile_rv = view.findViewById(R.id.bottomSheetRV);
        profile_rv.setLayoutManager(new LinearLayoutManager(context));

        switch(Objects.requireNonNull(getTag())) {
            case "BottomSheetPost":
                bottomSheetHeading.setText(R.string.post);
                profile_rv.setAdapter(new ProfileRVAdapter(titles, subTitles,blogPostSrc,0));
                break;
            case "BottomSheetPostFollowing":
                bottomSheetHeading.setText(R.string.following);
                profile_rv.setAdapter(new FollRVAdapter(userID,userName,userSpec,userProfileIV));
                break;
            case "BottomSheetFollowers":
                bottomSheetHeading.setText(R.string.followers);
                profile_rv.setAdapter(new FollRVAdapter(userIDF,userNameF,userSpecF,userProfileIVF));
                break;
            default:
                bottomSheetHeading.setText(R.string.app_name);
        }
        return view;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        //return super.onCreateDialog(savedInstanceState);
        Dialog dialog = super.onCreateDialog(savedInstanceState);
        dialog.getWindow().setGravity(Gravity.BOTTOM);
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        dialog.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
        return dialog;
    }
}
