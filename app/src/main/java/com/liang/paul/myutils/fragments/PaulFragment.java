package com.liang.paul.myutils.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by paulliang on 9/5/16.
 */
public class PaulFragment extends Fragment {

    View rootView;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = super.onCreateView(inflater, container, savedInstanceState);
        return rootView;
    }

    protected <T>T f(int resourceId){
        T view = (T) rootView.findViewById(resourceId);
        return view;
    }
}
