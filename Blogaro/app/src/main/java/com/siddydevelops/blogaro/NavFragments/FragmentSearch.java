package com.siddydevelops.blogaro.NavFragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.siddydevelops.blogaro.R;

public class FragmentSearch extends Fragment {

    ListView searchListView;
    String[] searchLV
            = { "Trending", "Most Read", "Machine Learning", "AI", "Data Structures",
            "Android Apps", "Figma", "Innovation" };

    public FragmentSearch() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        searchListView = view.findViewById(R.id.searchListView);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getActivity(),R.layout.list_view_item,searchLV);
        searchListView.setAdapter(arrayAdapter);

    }
}