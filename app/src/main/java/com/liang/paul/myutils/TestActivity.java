package com.liang.paul.myutils;

import android.os.Bundle;
import android.widget.ImageView;

import com.liang.paul.myutils.activitys.PaulActivity;
import com.liang.paul.myutils.utils.CacheImageLoader;
import com.liang.paul.myutils.utils.caches.BothCache;
import com.liang.paul.myutils.utils.caches.DiskCache;

public class TestActivity extends PaulActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        ImageView test = f(R.id.txt_test);
        new CacheImageLoader(this)
                .from("http://www.opsactive.com/wp-content/uploads/2012/11/Surface-Screenshot.png")//The Image URL here
                .failedImage(R.drawable.failed)//The Resource Id for image when failed, also can put a bitmap here
                .loadingImage(R.drawable.loading)//The Resource Id for image when loading, also can put a bitmap here
                .cacheTypt(new BothCache())/*
                                                I built 3 kind of Cache logic here
                                                MemoryCache just use the memory, you can set new MemoryCache(percent), percent is a int value between 0 and 100, for seting the percent of memory use for cache initialize
                                                DiskCache just use the storage, you can set new DiskCache(), the cache path will be sdcard/cache
                                                BothCache use both memory and storage to cache, will use 20 percent of memory for caching
                                                You also can set your own cache by write new ImageCache and implement the interface here
                                            */
                .into(test);// This is for the target ImageView

    }


}
