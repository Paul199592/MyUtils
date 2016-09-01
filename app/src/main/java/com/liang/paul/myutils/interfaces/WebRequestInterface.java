package com.liang.paul.myutils.interfaces;

import android.graphics.Bitmap;

/**
 * Created by paulliang on 8/31/16.
 */
public interface WebRequestInterface {
    public void callback(Bitmap content);
    public void inProgress(int progress);
    public void failed(int code);
}
