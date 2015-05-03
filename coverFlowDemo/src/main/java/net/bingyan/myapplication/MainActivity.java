package net.bingyan.myapplication;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Display display = getWindowManager().getDefaultDisplay();
        DisplayMetrics metrics = new DisplayMetrics();
        display.getMetrics(metrics);
        GlobalPrefs.setDensity(metrics.density);
        GlobalPrefs.setScreenWidth(metrics.widthPixels);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        CoverFlow coverFlow = (CoverFlow) findViewById(R.id.my_cover_flow);
        CoverFlowAdapter adapter = new CoverFlowAdapter(this);
        coverFlow.setAdapter(adapter);
        coverFlow.setSpacing(20);
        coverFlow.setSelection(0,true);
        coverFlow.setAnimationDuration(500);

    }

}
