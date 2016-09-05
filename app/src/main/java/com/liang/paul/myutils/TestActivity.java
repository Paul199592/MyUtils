package com.liang.paul.myutils;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.liang.paul.myutils.activitys.PaulActivity;
import com.liang.paul.myutils.testfragments.TestFragment1;
import com.liang.paul.myutils.testfragments.TestFragment2;
import com.liang.paul.myutils.utils.FileOpener;
import com.liang.paul.myutils.utils.FragmentStackManager;
import com.liang.paul.myutils.utils.UriToUrlParsor;

import java.io.File;

public class TestActivity extends PaulActivity {

    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        Button back = f(R.id.btn_back);
        Button change = f(R.id.btn_change);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (FragmentStackManager.getInstance().size() > 0){ // Check is that any fragment in stack
                    i--;
                    Fragment fragment = FragmentStackManager.getInstance().pop(); // Get last fragment and remove it in stack
                    FragmentManager manager = getFragmentManager();
                    FragmentTransaction transaction = manager.beginTransaction();
                    transaction.replace(R.id.fragment, fragment);
                    transaction.commit();
                }
            }
        });

        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i++;
                if (i % 2 == 0){
                    TestFragment1 fragment = new TestFragment1();
                    FragmentStackManager.getInstance().push(fragment); // Add the fragment into stack
                    FragmentManager manager = getFragmentManager();
                    FragmentTransaction transaction = manager.beginTransaction();
                    transaction.replace(R.id.fragment, fragment);
                    transaction.commit();
                }else {
                    TestFragment2 fragment = new TestFragment2();
                    FragmentStackManager.getInstance().push(fragment);
                    FragmentManager manager = getFragmentManager();
                    FragmentTransaction transaction = manager.beginTransaction();
                    transaction.replace(R.id.fragment, fragment);
                    transaction.commit();
                }
            }
        });

        FragmentStackManager.getInstance().removeAll(new TestFragment1()); // Remove all fragment belong to TestFragment1
        FragmentStackManager.getInstance().removeFirst(new TestFragment2()); //Remove the first fragment belong to TestFragment2 in stack
        FragmentStackManager.getInstance().removeLast(new TestFragment2()); //Remove the last fragment belong to TestFragment2 in stack



    }

    @Override
    public void onBackPressed() {
        if (FragmentStackManager.getInstance().size() > 0){
            i--;
            Fragment fragment = FragmentStackManager.getInstance().pop();
            FragmentManager manager = getFragmentManager();
            FragmentTransaction transaction = manager.beginTransaction();
            transaction.replace(R.id.fragment, fragment);
            transaction.commit();
        }else {
            finish();
        }
    }
}
