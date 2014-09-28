package com.adva.basecustomview;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by T530 on 28/09/2014.
 */
public abstract class BaseCustomView extends View {

    public static String TAG = "BaseCustomView";

    public BaseCustomView(Context context) {
        super(context);
    }

    public BaseCustomView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BaseCustomView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        logSpec(MeasureSpec.getMode(widthMeasureSpec));
        Log.d(TAG, "size width:" + MeasureSpec.getSize(widthMeasureSpec));

        logSpec(MeasureSpec.getMode(heightMeasureSpec));
        Log.d(TAG, "size height:" + MeasureSpec.getSize(heightMeasureSpec));

        setMeasuredDimension(getImprovedDefaultWidth(widthMeasureSpec), getImprovedDefaultHeight(heightMeasureSpec));
    }

    private int getImprovedDefaultHeight(int measureSpec) {
        //int result = size;
        int specMode = MeasureSpec.getMode(measureSpec);
        int specSize = MeasureSpec.getSize(measureSpec);
        switch (specMode) {
            case MeasureSpec.UNSPECIFIED:
                return hGetMaximumHeight();
            case MeasureSpec.EXACTLY:
                return specSize;
            case MeasureSpec.AT_MOST:
                return hGetMinimumHeight();
        }
        //you shouldn't come here
        Log.e(TAG,"unknown specmode");
        return specSize;
    }
    private int getImprovedDefaultWidth(int measureSpec) {
        //int result = size;
        int specMode = MeasureSpec.getMode(measureSpec);
        int specSize = MeasureSpec.getSize(measureSpec);
        switch (specMode) {
            case MeasureSpec.UNSPECIFIED:
                return hGetMaximumWidth();
            case MeasureSpec.EXACTLY:
                return specSize;
            case MeasureSpec.AT_MOST:
                return hGetMinimumWidth();
        }
        //you shouldn't come here
        Log.e(TAG,"unknown specmode");
        return specSize;
    }
    //Override these methods to provide a maximum size
    //"h" stands for hook pattern
    abstract protected int hGetMaximumHeight();
    abstract protected int hGetMaximumWidth();
    //For minimum height use the View's methods
    protected int hGetMinimumHeight() {
        return this.getSuggestedMinimumHeight();
    }
    protected int hGetMinimumWidth() {
        return this.getSuggestedMinimumWidth();
    }

    private void logSpec(int specMode) {
        if (specMode == MeasureSpec.UNSPECIFIED) {
            Log.d(TAG,"mode: unspecified");
            return;
        }
        if (specMode == MeasureSpec.AT_MOST) {
            Log.d(TAG,"mode: at most");
            return;
        }
        if (specMode == MeasureSpec.EXACTLY) {
            Log.d(TAG, "mode: exact");
            return;
        }
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w,h,oldw,oldh);
    }
    @Override
    protected void onLayout (boolean changed, int left,
                             int top, int right, int bottom)
    {
        Log.d(TAG,"onLayout");
        super.onLayout(changed, left, top, right, bottom);
    }
    @Override
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.d(TAG,"onDraw called");
    }
    @Override
    protected void onRestoreInstanceState(Parcelable p) {
        Log.d(TAG,"onRestoreInstanceState");
        super.onRestoreInstanceState(p);
    }
    @Override
    protected Parcelable onSaveInstanceState() {
        Log.d(TAG,"onSaveInstanceState");
        Parcelable p = super.onSaveInstanceState();
        return p;
    }
}
