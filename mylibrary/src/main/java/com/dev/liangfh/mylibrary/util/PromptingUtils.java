package com.dev.liangfh.mylibrary.util;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/**
 *
 * Created by @author liangfh on 2017/10/30.
 * 提示类工具
 * toast/dialog
 */

public class PromptingUtils {

    private static Toast mToast;
    private static TextView tvMsg;

    /**
     * show toast with long time
     * @param context
     * @param contents
     */
    public static void showToastLong(Context context, Object contents) {
        showToast(context, contents, Toast.LENGTH_LONG);
    }

    /**
     * showt toast with short time
     * @param context
     * @param contents
     */
    public static void showToast(Context context, Object contents) {
        showToast(context, contents, Toast.LENGTH_SHORT);
    }

    private static void showToast(Context context, Object contents, int length) {
        if (contents == null || contents.equals("")) return;
        initToast(context);
        mToast.setDuration(length);
        if (contents instanceof Integer) {
            try {
                tvMsg.setText((int) contents);
            } catch (Resources.NotFoundException e) {
                tvMsg.setText(String.valueOf(contents));
            }
        } else {
            tvMsg.setText(String.valueOf(contents));
        }
        mToast.show();
    }

    /**
     * init toast while use it at first time
     * @param context
     */
    private static void initToast(Context context) {
        if (mToast == null) {
            synchronized (PromptingUtils.class) {
                if (mToast == null) {
                    mToast = new Toast(context);
                    LayoutInflater inflate = (LayoutInflater)
                            context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    View v = inflate.inflate(com.android.internal.R.layout.transient_notification
                            , null);
                    tvMsg = v.findViewById(com.android.internal.R.id.message);
                    mToast.setView(v);
                }
            }
        }
    }
}
