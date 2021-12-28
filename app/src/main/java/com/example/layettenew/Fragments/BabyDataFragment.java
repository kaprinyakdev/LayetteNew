package com.example.layettenew.Fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.layettenew.R;

public class BabyDataFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.baby_data_list, parent, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {

    }
}
