package com.liang.paul.myutils.interfaces;

import android.graphics.Bitmap;

/**
 * Created by paulliang on 8/31/16.
 */
public interface ImageCache {
    public Bitmap get(String url);
    public void put(String url, Bitmap image);
}
