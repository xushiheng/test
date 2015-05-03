package net.bingyan.myapplication;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by leon Xu on 2015/5/2 0002.
 */
public class CoverFlowAdapter extends BaseAdapter {
    private Context mContext;
    private Integer[] imgs = {
            R.drawable.img1,
            R.drawable.img2,
            R.drawable.img3,
            R.drawable.img4,
            R.drawable.img5,
            R.drawable.img6,
            R.drawable.img7,
            R.drawable.img8,
            R.drawable.img1,
            R.drawable.img2,
            R.drawable.img3,
            R.drawable.img4,
            R.drawable.img5,
            R.drawable.img6,
            R.drawable.img7,
            R.drawable.img8
    };

    public CoverFlowAdapter(Context context){
        mContext = context;
    }
    @Override
    public int getCount() {
        return 100;
    }

    @Override
    public Object getItem(int position) {
        return imgs[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        /*ImageView i = new ImageView(mContext);
        i.setImageResource(imgs[position]);
        i.setLayoutParams(new CoverFlow.LayoutParams(500, 500));
        i.setScaleType(ImageView.ScaleType.CENTER_INSIDE);*/
        TextView t = null;
        if(convertView == null){
            t = new TextView(mContext);
            convertView = t;
            convertView.setTag(t);
        }else {
            t = (TextView) convertView.getTag();
        }

        t.setText(position+" ");
        t.setLayoutParams(new CoverFlow.LayoutParams(500, 500));
        t.setTextSize(50);
        t.setGravity(Gravity.CENTER);
        t.setBackgroundColor(Color.RED);

        return convertView;
    }
}
