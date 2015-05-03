package net.bingyan.myapplication;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.view.View;
import android.view.animation.Transformation;

/**
 * Created by leon Xu on 2015/5/2 0002.
 */
public class Vertical {

    private Camera mCamera = new Camera();
    private int del;
    private Matrix matrix;

    public void transformViewChild(View child, Transformation t, float i,
                                     int j, CoverFlow c) {
        mCamera.save();
        matrix = t.getMatrix();
        final int childHeight = child.getLayoutParams().height;
        final int childWidth = child.getLayoutParams().width;


        setDelta(c.getWidth() / 2);
        mCamera.getMatrix(matrix);
        matrix.preTranslate(-(childWidth / 2), -(childHeight / 2));
        float tx = -j;
        final int ty = (int) (Math.floor((2 * (double) j) / c.getWidth() * child.getHeight()));
        matrix.postScale(i,i);
        matrix.postTranslate(tx + c.getWidth() / 5, (childHeight / 2) + ty);
        mCamera.restore();
    }

    private void setDelta(int i) {
        del = i;
    }

    public int getDelta() {
        return del;
    }
}
