package com.liang.paul.myutils.utils;


import android.app.Fragment;

import java.util.ArrayList;

/**
 * Created by paulliang on 9/5/16.
 */
public class FragmentStackManager {
    ArrayList<Fragment> stack;
    static FragmentStackManager instance = null;

    private FragmentStackManager(){
        stack = new ArrayList<Fragment>();
    }

    public static synchronized FragmentStackManager getInstance(){
        if (instance == null){
            instance = new FragmentStackManager();
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
