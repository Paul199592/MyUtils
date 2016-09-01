package com.liang.paul.myutils.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import com.liang.paul.myutils.R;
import com.liang.paul.myutils.interfaces.ImageCache;
import com.liang.paul.myutils.interfaces.WebRequestInterface;
import com.liang.paul.myutils.utils.caches.MemoryCache;


/**
 * Created by paulliang on 8/31/16.
 */
public class CacheImageLoader {
    Context context;
    ImageCache cache = new MemoryCache();
    String url;
    Bitmap bitmap = null;
    Bitmap loadingBitmap;
    Bitmap failedBitmap;
    int resLoad = -1;
    int resFailed = -1;

    public CacheImageLoader(Context context){
        this.context = context;
        BitmapFactory.Options opts = new BitmapFactory.Options();
        opts.inJustDecodeBounds =true;
        resLoad = R.drawable.load;
        resFailed = R.drawable.failed;
    }

    public CacheImageLoader from(String url){
        this.url = url;
        return this;
    }

    public CacheImageLoader loadingImage(int res){
        resLoad = res;
        return this;
    }

    public CacheImageLoader loadingImage(Bitmap bitmap){
        loadingBitmap = bitmap;
        return this;
    }

    public CacheImageLoader failedImage(int res){
        resFailed = res;
        return this;
    }

    public CacheImageLoader failedImage(Bitmap bitmap){
        failedBitmap = bitmap;
        return this;
    }

    public CacheImageLoader cacheTypt(ImageCache cache){
        this.cache = cache;
        return this;
    }

    public void into(final ImageView view){
        if (loadingBitmap == null){
            view.setImageResource(resLoad);
        }else {
            view.setImageBitmap(loadingBitmap);
        }
        if (url != null){
            bitmap = cache.get(url);
            if (bitmap == null){
                new WebRequestTaskImage(new WebRequestInterface() {
                    @Override
                    public void callback(Bitmap content) {
                        bitmap = content;
                        if (bitmap != null) {
                            cache.put(url, bitmap);
                            view.setImageBitmap(bitmap);
                        }
                    }

                    @Override
                    public void inProgress(int progress) {

                    }

                    @Override
                    public void failed(int code) {
                        if (failedBitmap == null) {
                            view.setImageResource(resFailed);
                        }else {
                            view.setImageBitmap(failedBitmap);
                        }
                    }
                }).execute(url);
            }else {
                view.setImageBitmap(bitmap);
            }
        }
    }

    private Bitmap drawableToBitmap(int res) {
        Drawable drawable;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            drawable = context.getDrawable(res);
        }else {
            drawable = context.getResources().getDrawable(res);
        }
        BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
        return bitmapDrawable.getBitmap();
    }
}
