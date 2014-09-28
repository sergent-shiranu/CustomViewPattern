package com.adva.customviewpattern;

import android.content.Context;
import android.util.AttributeSet;

import com.adva.basecustomview.BaseCustomView;

/**
 * Created by T530 on 28/09/2014.
 */
public class CustomCircularView extends BaseCustomView {

    public CustomCircularView(Context context) {
        super(context);
    }

    public CustomCircularView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomCircularView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected int hGetMaximumHeight() {
        return 0;
    }

    @Override
    protected int hGetMaximumWidth() {
        return 0;
    }
}
