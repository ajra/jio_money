package com.jiomoney.snapbizz.utils;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.StrictMode;
import android.provider.Settings;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import android.widget.Toast;

import com.jiomoney.snapbizz.R;


public class Common {
    public static <T> String getTAG(Class<T> clazz) {
        String className = clazz.getName();
        className = getClassNameFromPackageName(className);
        return className;
    }
    private static String getClassNameFromPackageName(String className) {
        if (className.contains(".")) {
            String[] classNameArr = className.split("\\.");
            className = classNameArr[classNameArr.length - 1];
        }
        return className;
    }
    /**
     * Returns the actual width of screen of device in pixels
     *
     * @param context
     *            context of activity
     * @return width in pixels
     */
    @SuppressWarnings("deprecation")
    public static int getScreenWidth(Context context) {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        if (Build.VERSION.SDK_INT >= 13) {
            DisplayMetrics metrics = new DisplayMetrics();
            ((Activity) context).getWindowManager().getDefaultDisplay()
                    .getMetrics(metrics);
            return metrics.widthPixels;

        } else {
            Display display = ((WindowManager) context
                    .getSystemService(Context.WINDOW_SERVICE))
                    .getDefaultDisplay();
            return display.getWidth();
        }
    }

    public static void showToastMessage(Context context, String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }

    /**
     * Check if device is online or not
     *
     * @return true if it has access to Internet, false otherwise
     */
    public static boolean isOnline(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(
                Context.CONNECTIVITY_SERVICE);
        NetworkInfo nf = null;
        if (cm != null) {
            nf = cm.getActiveNetworkInfo();
        }

        if (nf != null) {
            return nf.isConnectedOrConnecting();
        }
        return false;
    }

    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Network[] networks = connectivityManager.getAllNetworks();
            NetworkInfo networkInfo;
            for (Network mNetwork : networks) {
                networkInfo = connectivityManager.getNetworkInfo(mNetwork);
                if (networkInfo.getState().equals(NetworkInfo.State.CONNECTED)) {
                    return true;
                }
            }
        } else {
            if (connectivityManager != null) {
                //noinspection deprecation
                NetworkInfo[] info = connectivityManager.getAllNetworkInfo();
                if (info != null) {
                    for (NetworkInfo anInfo : info) {
                        if (anInfo.getState() == NetworkInfo.State.CONNECTED) {
                            Log.d("Network",
                                    "NETWORKNAME: " + anInfo.getTypeName());
                            return true;
                        }
                    }
                }
            }
        }
        //  Toast.makeText(mContext, mContext.getString(R.string.dialog_no_inter_message), Toast.LENGTH_SHORT).show();
        return false;
    }

    public static String getDeviceId(Context context) {
        return Settings.Secure.getString(context.getContentResolver(),
                Settings.Secure.ANDROID_ID);
    }

    public static String getAppPackageName(Context activity) {
        String appPackageName = null;
        PackageManager packageManager = activity.getPackageManager();
        try {
            PackageInfo pinfo = packageManager.getPackageInfo(activity.getPackageName(), 0);
            appPackageName = pinfo.packageName;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return appPackageName;
    }
    public static String getVersionNo(Context activity) {

        String appPackageName = null;
        PackageManager packageManager = activity.getPackageManager();
        try {
            PackageInfo pinfo = packageManager.getPackageInfo(activity.getPackageName(), 0);
            appPackageName = pinfo.versionName;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return appPackageName;
    }

    public static void showUnderDevelopmentToast(Context context) {
        Toast.makeText(context,context.getString(R.string.under_development),Toast.LENGTH_LONG).show();
    }
}
