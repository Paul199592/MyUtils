package com.liang.paul.myutils.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;

import com.liang.paul.myutils.interfaces.WebRequestInterface;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by paulliang on 8/31/16.
 */
public class WebRequestTaskImage extends AsyncTask<String, Integer, Bitmap> {

    WebRequestInterface call;

    public WebRequestTaskImage(WebRequestInterface call) {
        this.call = call;
    }

    public Bitmap getContent(String url) {
        Bitmap result;
        try {
            URL downloadUrl = new URL(url);
            HttpURLConnection httpURLConnection = (HttpURLConnection) downloadUrl.openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setConnectTimeout(5000);
            if (httpURLConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                InputStream is = httpURLConnection.getInputStream();
                result = BitmapFactory.decodeStream(is);
            }else {
                Log.i("WebRequestTaskFailed->", "" + httpURLConnection.getResponseCode());
                result = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            result = null;
        }
        return result;
    }

    @Override
    protected Bitmap doInBackground(String... params) {
        Bitmap content = getContent(params[0]);
        return content;
    }

    @Override
    protected void onPostExecute(Bitmap result) {
        Log.i("Execute-->>", "Execute");
        call.callback(result);
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        call.inProgress(values[0]);
    }

}
