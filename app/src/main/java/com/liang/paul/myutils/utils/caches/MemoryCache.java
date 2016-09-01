package com.liang.paul.myutils.utils.caches;

import android.graphics.Bitmap;
import android.util.LruCache;

import com.liang.paul.myutils.interfaces.ImageCache;

/**
 * Created by paulliang on 8/31/16.
 */
public class MemoryCache implements ImageCache {
    private LruCache<String, Bitmap> memoryCache;


    public MemoryCache() {
        final int maxMemory = (int) (Runtime.getRuntime().maxMemory() / 1024);
        int cacheSize = maxMemory / 20;
        memoryCache = new LruCache<String, Bitmap>(cacheSize){
            @Override
            protected int sizeOf(String key, Bitmap value) {
                return value.getRowBytes() * value.getHeight() / 1024;
            }
        };
    }

    @Override
    public Bitmap get(String url) {
        return memoryCache.get(url);
    }

    @Override
    public void put(String url, Bitmap image) {
        memoryCache.put(url, image);
    }
}
