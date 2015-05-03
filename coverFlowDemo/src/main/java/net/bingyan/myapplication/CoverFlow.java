package net.bingyan.myapplication;

import android.content.Context;
import android.graphics.Camera;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Transformation;
import android.widget.Gallery;

/**
 * Created by leon Xu on 2015/5/2 0002.
 */
public class CoverFlow extends Gallery {

    private int mCoveflowCenter;
    private Vertical vertical = new Vertical();
    private Camera mCamera = new Camera();

    public CoverFlow(Context context) {
        super(context);
        // drawchildÊ±µ÷ÓÃgetChildStaticTransformation
        this.setStaticTransformationsEnabled(true);
    }

    public CoverFlow(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.setStaticTransformationsEnabled(true);
    }

    public CoverFlow(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.setStaticTransformationsEnabled(true);
    }

    private int getCenterOfCoverflow() {
        return (getWidth() - getPaddingLeft() - getPaddingRight()) / 2
                + getPaddingLeft();
    }

    private static int getCenterOfView(View view) {
        return view.getLeft() + view.getWidth() / 2;
    }

    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        mCoveflowCenter = getCenterOfCoverflow();
        super.onSizeChanged(w, h, oldw, oldh);
    }

    @Override
    protected boolean getChildStaticTransformation(View child, Transformation t) {
        final int childCenter = getCenterOfView(child);
        //final int childHeight = child.getLayoutParams().height;
        //final int childWidth = child.getLayoutParams().width;
        int j = childCenter - mCoveflowCenter;
        float zoomAmount = 1-3*Math.abs(j)/(GlobalPrefs.getScreenWidth()*4);
        t.clear();
        t.setTransformationType(Transformation.TYPE_MATRIX);
        if (childCenter == mCoveflowCenter) {
            vertical.transformViewChild(child,t,1,0,this);
        } else {
            vertical.transformViewChild(child,t,zoomAmount,j,this);
        }

        return true;
    }

    @Override
    public boolean onDown(MotionEvent e) {
        getParent().requestDisallowInterceptTouchEvent(true);
        //Log.e("tag", "old x"+e.getX()+"old y"+e.getY());
        float tempx = Math.abs(e.getX());
        float tempy = Math.abs(e.getY());
        float div = (float) (GlobalPrefs.getScreenWidth() / 3.6);
        e.offsetLocation((-tempx + tempy - div), -tempy + tempx + this.getWidth() / 3);
        //Log.e("tag", "new x"+e.getX()+"new y"+e.getY());
        return super.onDown(e);
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
                           float velocityY) {
        return super.onFling(e1, e2, velocityY, velocityX);
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX,
                            float distanceY) {

        getParent().requestDisallowInterceptTouchEvent(true);

        return super.onScroll(e1, e2, distanceY, distanceX);
    }
}
