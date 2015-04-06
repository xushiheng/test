package com.iweather.app.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.iweather.app.service.AutoUpdateService;

/**
 * Created by leon Xu on 2015/4/5 0005.
 */
public class AutoUpdateReceiver extends BroadcastReceiver {
    //一小时后执行到onReceive时再跳转回service的onStartCommand完成更新
    @Override
    public void onReceive(Context context, Intent intent) {
        Intent intent1 = new Intent(context, AutoUpdateService.class);
        context.startService(intent1);
    }
}
