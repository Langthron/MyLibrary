package com.dev.liangfh.mylibrary.util;

import android.widget.TextView;

/**
 * Created by usr on 2017/10/30.
 */

public class ViewUtils {

    public static void setText(TextView textView, Object contents) {
        if (textView == null) return;

        if (contents instanceof Integer) {
            try {
                textView.setText((int) contents);
            } catch (Exception e) {
                textView.setText(String.valueOf(contents));
            }
        } else {
            textView.setText(String.valueOf(contents));
        }
    }
}
