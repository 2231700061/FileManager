package com.filemanager.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.filemanager.R;
import com.filemanager.adapter.WordAdapter;
import com.filemanager.util.FileUtil;

import java.io.File;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class WordFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private List<File> mFiles;
    private WordAdapter mAdapter;


    public WordFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View ret = inflater.inflate(R.layout.fragment_word, container, false);
        mFiles = FileUtil.getSpecificTypeOfFile(getContext(),new String[]{".doc","txt"});
        mRecyclerView = (RecyclerView) ret.findViewById(R.id.id_recyclerview);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setAdapter(mAdapter = new WordAdapter(getContext(),mFiles));
        return ret;
    }

}
