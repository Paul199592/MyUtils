package com.liang.paul.myutils.activitys;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by paulliang on 16/4/27.
 */
public class PaulActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
    }

    protected <T>T f(int resourceId){
        T view = (T) findViewById(resourceId);
        return view;
    }
}
