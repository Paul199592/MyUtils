package com.liang.paul.myutils.utils.caches;

import android.graphics.Bitmap;

import com.liang.paul.myutils.interfaces.ImageCache;

/**
 * Created by paulliang on 8/31/16.
 */
public class BothCache implements ImageCache {
    MemoryCache memoryCache = new MemoryCache(-1);
    DiskCache diskCache = new DiskCache();

    @Override
    public Bitmap get(String url) {
        Bitmap bitmap = memoryCache.get(url);
        if (bitmap == null){
            bitmap = diskCache.get(url);
        }
        return bitmap;
    }

    @Override
    public void put(String url, Bitmap image) {
        memoryCache.put(url, image);
        diskCache.put(url, image);
    }
}
