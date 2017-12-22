package com.hhz.aidl;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ActionSheetCoupon {

    private static LinearLayout layout;
    private static Dialog dlg;

    public interface OnActionSheetSelected {
        void onSheetClick(int whichButton);
    }

    public ActionSheetCoupon() {
    }

    public static Dialog showSheet(final Context context, final OnActionSheetSelected actionSheetSelected,
                                   OnCancelListener cancelListener) {
        if(dlg==null){
            dlg = new Dialog(context, R.style.AlertDialogStyle);
        }
        dlg.setCanceledOnTouchOutside(true);

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        layout = (LinearLayout) inflater.inflate(R.layout.actionsheet_coupon, null);
        final int cFullFillWidth = 10000;
        layout.setMinimumWidth(cFullFillWidth);

        onClickId(actionSheetSelected, R.id.btn_cashcoupon);
        onClickId(actionSheetSelected, R.id.btn_discount);
        onClickId(actionSheetSelected, R.id.btn_exchange);
        onClickId(context,actionSheetSelected, R.id.cancel);

        Window w = dlg.getWindow();
        WindowManager.LayoutParams lp = w.getAttributes();
//        lp.x = 0;
//        final int cMakeBottom = -1000;
//        lp.y = cMakeBottom;
        lp.gravity = Gravity.BOTTOM;
        dlg.onWindowAttributesChanged(lp);
        if (cancelListener != null)
            dlg.setOnCancelListener(cancelListener);
        dlg.setContentView(layout);
        dlg.show();
        return dlg;
    }

    private static void onClickId(final OnActionSheetSelected actionSheetSelected, final int whichButton) {
        layout.findViewById(whichButton).setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                actionSheetSelected.onSheetClick(whichButton);
                dlg.dismiss();
            }
        });
    }
    private static void onClickId(final Context context,final OnActionSheetSelected actionSheetSelected, final int whichButton) {
        layout.findViewById(whichButton).setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                if(whichButton==R.id.cancel){
                    Resources resource=context.getResources();
                    ColorStateList csl=(ColorStateList)resource.getColorStateList(R.color.btn_text_color);
                    if(csl!=null){
                        ((TextView)layout.findViewById(R.id.cancel)).setTextColor(context.getResources().getColor(R.color.btn_text_color));//设置按钮文字颜色
                    }
                }
                actionSheetSelected.onSheetClick(whichButton);
                dlg.dismiss();
            }
        });
    }
}
