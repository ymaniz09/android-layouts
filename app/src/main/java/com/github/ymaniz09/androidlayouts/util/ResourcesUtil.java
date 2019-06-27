package com.github.ymaniz09.androidlayouts.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;

public class ResourcesUtil {

    public static Drawable getDrawable(Context context, String resourceName) {
        Resources resources = context.getResources();

        int drawableId = resources
                .getIdentifier(resourceName, "drawable", context.getPackageName());

        return context.getDrawable(drawableId);
    }
}
