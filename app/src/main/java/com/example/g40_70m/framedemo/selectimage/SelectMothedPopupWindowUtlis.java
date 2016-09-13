package com.example.g40_70m.framedemo.selectimage;

import android.app.Activity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.PopupWindow;

import com.example.g40_70m.framedemo.R;
import com.example.g40_70m.framedemo.selectimage.view.SelectMothedPopupWindow;
import com.example.g40_70m.framedemo.utils.DensityUtil;

/**
 * Created by 坤 on 2016/8/12.
 */
public class SelectMothedPopupWindowUtlis {

    public static void showPopupWindow(final Activity activity,View contentView,SelectMothedPopupWindow.OnMothedSelected onMothedSelected){
        SelectMothedPopupWindow selectMothedPopupWindow = new SelectMothedPopupWindow(ViewGroup.LayoutParams.MATCH_PARENT, DensityUtil.dip2px(activity, 156),
                LayoutInflater.from(activity.getApplicationContext())
                        .inflate(R.layout.pop_select_method, null));
        selectMothedPopupWindow
                .setAnimationStyle(R.style.anim_popup_dir);
        selectMothedPopupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                WindowManager.LayoutParams lp = activity.getWindow().getAttributes();
                lp.alpha = 1.0f;
                activity.getWindow().setAttributes(lp);
            }
        });

        selectMothedPopupWindow.showAtLocation(contentView, Gravity.BOTTOM, 0, 0);
        // 设置背景颜色变暗
        WindowManager.LayoutParams lp = activity.getWindow().getAttributes();
        lp.alpha = .3f;
        activity.getWindow().setAttributes(lp);

        selectMothedPopupWindow.setOnImageDirSelected(onMothedSelected);
    }

}
