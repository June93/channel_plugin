package com.june.channel_plugin;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;

public class CommonUtil {

    public static String getPackageName(Context context) {
        String packageName = "";
        if (context != null) {
            packageName = context.getPackageName();
        }
        return packageName == null ? "" : packageName;
    }

    private static ApplicationInfo getApplicationInfo(Context context) {
        ApplicationInfo ai = null;
        if (context != null) {
            try {
                PackageManager pm = context.getPackageManager();
                ai = pm.getApplicationInfo(getPackageName(context), PackageManager.GET_META_DATA);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return ai;
    }


    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR1)
    public static String getMetaDataString(Context context, String name, String defaultValue) {
        String value = "";
        ApplicationInfo ai = getApplicationInfo(context);
        if (ai != null && ai.metaData != null) {
            try {
                value = ai.metaData.getString(name, defaultValue);
            } catch (Exception e) {
            }
        }
        return value;
    }

}
