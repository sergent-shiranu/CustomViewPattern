package com.adva.basecustomlayoutview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;

/**
 * Created by T530 on 28/09/2014.
 */
public class BaseCustomLayoutView extends ViewGroup {
    public BaseCustomLayoutView(Context context) {
        super(context);
    }

    public BaseCustomLayoutView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BaseCustomLayoutView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onLayout(boolean b, int i, int i2, int i3, int i4) {

    }
}
