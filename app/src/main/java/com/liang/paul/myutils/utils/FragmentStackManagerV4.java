package com.liang.paul.myutils.utils;

import android.support.v4.app.Fragment;

import java.util.ArrayList;

/**
 * Created by paulliang on 9/5/16.
 */
public class FragmentStackManagerV4 {
    ArrayList<Fragment> stack;
    static FragmentStackManagerV4 instance = null;

    private FragmentStackManagerV4(){
        stack = new ArrayList<Fragment>();
    }

    public static synchronized FragmentStackManagerV4 getInstance(){
        if (instance == null){
            instance = new FragmentStackManagerV4();
        }
        return instance;
    }

    public void push(Fragment fragment){
        stack.add(fragment);
    }

    public int size(){
        return stack.size();
    }

    public Fragment pop(){
        int lastIndex = stack.size() - 1;
        Fragment fragment = stack.get(lastIndex);
        stack.remove(lastIndex);
        return fragment;
    }

    public void clear(){
        stack.clear();
    }

    public void removeFirst(Fragment fragment){
        for (int i = 0; i < stack.size(); i++){
            if (isSameClass(stack.get(i), fragment)){
                stack.remove(i);
                break;
            }
        }
    }

    public void removeLast(Fragment fragment){
        for (int i = (stack.size() - 1); i > -1; i++){
            if (isSameClass(stack.get(i), fragment)){
                stack.remove(i);
                break;
            }
        }
    }

    public void removeAll(Fragment fragment){
        for (int i = 0; i < stack.size(); i++){
            if (isSameClass(stack.get(i), fragment)){
                stack.remove(i);
            }
        }
    }

    private boolean isSameClass(Fragment fragment1, Fragment fragment2){
        if (fragment1.getClass().getName().equals(fragment2.getClass().getName())){
            return true;
        }
        return false;
    }

}
