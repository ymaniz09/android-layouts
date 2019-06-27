package com.github.ymaniz09.androidlayouts.util;

import android.content.Context;
import android.content.res.Resources;

public class PluralUtil {
    public static String getPlural(Context context, int amount, int resourceId) {
        Resources resources = context.getResources();

        return resources.getQuantityString(resourceId, amount, amount);

    }
}
