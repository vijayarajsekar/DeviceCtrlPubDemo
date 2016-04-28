package com.vij.devicectrl.Utilities;

import android.content.res.Resources;

/**
 * Created by joy on 14/7/15.
 */
public class FontUtils {

    public static float dp2px(Resources resources, float dp) {
        final float scale = resources.getDisplayMetrics().density;
        return dp * scale + 0.5f;
    }

    public static float sp2px(Resources resources, float sp) {
        final float scale = resources.getDisplayMetrics().scaledDensity;
        return sp * scale;
    }
}
