package com.liang.paul.myutils;

import android.os.Bundle;
import android.widget.ImageView;

import com.liang.paul.myutils.activitys.PaulActivity;
import com.liang.paul.myutils.utils.CacheImageLoader;
import com.liang.paul.myutils.utils.caches.BothCache;
import com.liang.paul.myutils.utils.caches.DiskCache;

public class TestActivity extends PaulActivity {

    ImageView test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        test = f(R.id.txt_test);
        new CacheImageLoader(this)
                .from("http://www.opsactive.com/wp-content/uploads/2012/11/Surface-Screenshot.png")
                .cacheTypt(new BothCache())
                .into(test);

    }


}
