package com.iweather.app.util;

/**
 * Created by leon Xu on 2015/4/5 0005.
 */
public interface HttpCallbackListener {

    void onFinish(String response);
    void onError(Exception e);

}
