package com.liang.paul.myutils.testfragments;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.liang.paul.myutils.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class TestFragment2 extends Fragment {


    public TestFragment2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_test_fragment2, container, false);
    }

}
