package com.liang.paul.myutils.utils.caches;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.util.Log;

import com.liang.paul.myutils.interfaces.ImageCache;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by paulliang on 8/31/16.
 */
public class DiskCache implements ImageCache {
    String cacheDir;

    public DiskCache(){
        cacheDir = Environment.getExternalStorageDirectory().toString() + "/cache/";
        Log.i("CacheDir-->>", cacheDir);
        File file = new File(cacheDir);
        if (!file.exists()){
            file.mkdir();
        }
    }

    @Override
    public Bitmap get(String url) {
        Log.i("DiskCacheGet-->>", cacheDir + url.hashCode());
        return BitmapFactory.decodeFile(cacheDir + url.hashCode());
    }

    @Override
    public void put(String url, Bitmap image) {
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(cacheDir + url.hashCode());
            image.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            if (fileOutputStream != null){
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
