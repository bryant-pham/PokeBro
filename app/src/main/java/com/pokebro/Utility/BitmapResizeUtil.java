package com.pokebro.Utility;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

/**
 * Created by Bryant on 10/2/2014.
 */
public class BitmapResizeUtil {
    public static Bitmap getResizedDrawable(Resources resource, int drawable) {
        Bitmap originalDrawable = BitmapFactory.decodeResource(resource, drawable);
        int scaledWidth  = originalDrawable.getWidth() * 6;
        int scaledHeight = originalDrawable.getHeight() * 6;
        Bitmap resizedBitmap = Bitmap.createScaledBitmap(originalDrawable, scaledWidth, scaledHeight, true);
        return resizedBitmap;
    }
}
