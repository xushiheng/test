package com.iweather.app.service;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.IBinder;
import android.preference.PreferenceManager;

import com.iweather.app.R;
import com.iweather.app.activity.ChooseAreaActivity;
import com.iweather.app.activity.WeatherActivity;

/**
 * Created by leon Xu on 2015/4/6 0006.
 */
public class NotificationService extends Service {
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        String cityName = prefs.getString("city_name", "");
        String weatherDesp = prefs.getString("weather_desp", "");
        String temp1 = prefs.getString("temp1", "");
        String temp2 = prefs.getString("temp2", "");
        Intent notificationIntent = new Intent(this, ChooseAreaActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this,0,notificationIntent,0);
        Notification notification = new Notification.Builder(this).setAutoCancel(true)
                .setSmallIcon(R.drawable.notification).setContentTitle(cityName).setContentText
                        (weatherDesp + "\n" + temp2 + "~" + temp1).setWhen(System
                        .currentTimeMillis()).setContentIntent(pendingIntent).build();
        startForeground(1,notification);
        return super.onStartCommand(intent, flags, startId);
    }
}
