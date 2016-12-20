package com.wyu.iwork.net;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;

/**
 * Created by jhj_Plus on 2016/10/25.
 */
public class Network {
    private static Network sNetwork;
    private Context mContext;
    /**
     * 网络请求容器类
     */
    private RequestQueue mRequestQueue;
    /**
     * 图片加载类
     */
    private ImageLoader mImageLoader;

    private Network(Context context) {
        mContext = context.getApplicationContext();
    }

    public static synchronized Network getInstance(Context context) {
        if (sNetwork == null) {
            sNetwork = new Network(context);
        }
        return sNetwork;
    }

    public RequestQueue getRequestQueue() {
        if (mRequestQueue == null) {
            mRequestQueue = Volley.newRequestQueue(mContext);
        }
        return mRequestQueue;
    }

    public <T> void addRequest(Request<T> request) {
        getRequestQueue().add(request);
    }

    public ImageLoader getImageLoader() {
        if (mImageLoader == null) {
            mImageLoader = new ImageLoader(getRequestQueue(), new LruBitmapCache(mContext));
        }
        return mImageLoader;
    }
}
