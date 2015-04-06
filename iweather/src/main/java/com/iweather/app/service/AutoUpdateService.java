package com.iweather.app.service;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.IBinder;
import android.os.SystemClock;
import android.preference.PreferenceManager;

import com.iweather.app.receiver.AutoUpdateReceiver;
import com.iweather.app.util.HttpCallbackListener;
import com.iweather.app.util.HttpUtil;
import com.iweather.app.util.Utility;

import java.net.HttpURLConnection;
import java.util.ServiceConfigurationError;

/**
 * Created by leon Xu on 2015/4/5 0005.
 */
public class AutoUpdateService extends Service {
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    //开启子线程更新天气信息后，隔一个小时启动一次AutoUpdateReceiver
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                updateWeather();
            }
        }).start();
        AlarmManager manager = (AlarmManager) getSystemService(ALARM_SERVICE);
        int anHour = 60 * 60 * 1000;
        long triggerAtTime = SystemClock.elapsedRealtime() + anHour;
        Intent intent1 = new Intent(this, AutoUpdateReceiver.class);
        PendingIntent pi = PendingIntent.getBroadcast(this,0,intent1,0);
        manager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP,triggerAtTime,pi);
        return super.onStartCommand(intent,flags,startId);
    }

    private void updateWeather() {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        String weatherCode = prefs.getString("weather_code","");
        String address = "http://www.weather.com.cn/data/cityinfo/"+weatherCode+".html";
        HttpUtil.sendHttpRequest(address,new HttpCallbackListener() {
            @Override
            public void onFinish(String response) {
                Utility.handlWeahterResponse(AutoUpdateService.this,response);
            }

            @Override
            public void onError(Exception e) {
                e.printStackTrace();
            }
        });
    }
}
