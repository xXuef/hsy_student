package hsy.com.hsy.util;

import android.content.Context;
import android.widget.Toast;

import hsy.com.hsy.BaseApp;

public class ToastUtils {

    // App生命周期中唯一Context，CrashApplication继承Application
    private static Context mContext = BaseApp.getInstance();
    // 全局的toast实例
    private static Toast mToast;

    // 短时间显示toast
    public static void showShort(String text) {
        if (mContext == null) {
            mContext = BaseApp.getInstance();
        }

        if (mToast == null) {
            mToast = Toast.makeText(mContext, text, Toast.LENGTH_SHORT);
        }

        mToast.setText(text);
        mToast.setDuration(Toast.LENGTH_SHORT);
        mToast.show();
    }

    public static void showShort(int resId) {
        if (mContext == null) {
            mContext = BaseApp.getInstance();
        }

        if (mToast == null) {
            mToast = Toast.makeText(mContext, resId, Toast.LENGTH_SHORT);
        }

        mToast.setText(resId);
        mToast.setDuration(Toast.LENGTH_SHORT);
        mToast.show();
    }

    // 长时间显示toast
    public static void showLong(String text) {
        if (mContext == null) {
            mContext = BaseApp.getInstance();
        }

        if (mToast == null) {
            mToast = Toast.makeText(mContext, text, Toast.LENGTH_LONG);
        }

        mToast.setText(text);
        mToast.setDuration(Toast.LENGTH_LONG);
        mToast.show();
    }

    public static void showLong(int resId) {
        if (mContext == null) {
            mContext = BaseApp.getInstance();
        }

        if (mToast == null) {
            mToast = Toast.makeText(mContext, resId, Toast.LENGTH_LONG);
        }

        mToast.setText(resId);
        mToast.setDuration(Toast.LENGTH_LONG);
        mToast.show();
    }
}