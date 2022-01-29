package com.siddydevelops.blogaro.NavFragments;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import com.hootsuite.nachos.NachoTextView;
import com.hootsuite.nachos.terminator.ChipTerminatorHandler;
import com.siddydevelops.blogaro.MainDashboard;
import com.siddydevelops.blogaro.R;

public class FragmentAddBlog extends Fragment {

    ImageView iv_addBlog;
    NachoTextView tagChip;

    String[] suggestions = new String[]{"Lifestyle", "ML", "WebDev", "Android", "Sports", "Technology","Art","Design","Culture","Production"};

    public FragmentAddBlog() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_blog, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        iv_addBlog = getActivity().findViewById(R.id.iv_addBlog);
        iv_addBlog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), MainDashboard.class);
                startActivity(intent);
                getActivity().finish();
            }
        });


        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), R.layout.suggestion_chip, suggestions);

        tagChip = view.findViewById(R.id.tagChip);
        tagChip.setAdapter(adapter);
        tagChip.setChipTextColor(Color.WHITE);
        tagChip.addChipTerminator(' ', ChipTerminatorHandler.BEHAVIOR_CHIPIFY_TO_TERMINATOR);

    }

}