package com.hhz.aidl;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;

public class ActionSheetCoupon {

    private static LinearLayout layout;
    private static Dialog dlg;
    private static Button cancelBtn;

    public interface OnActionSheetSelected {
        void onSheetClick(int whichButton);
    }

    public ActionSheetCoupon() {
    }

    public static Dialog showSheet(final Context context, final OnActionSheetSelected actionSheetSelected,
                                   OnCancelListener cancelListener) {
        dlg = new Dialog(context, R.style.AlertDialogStyle);
        dlg.setCanceledOnTouchOutside(true);

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        layout = (LinearLayout) inflater.inflate(R.layout.actionsheet_coupon, null);
        final int cFullFillWidth = 10000;
        layout.setMinimumWidth(cFullFillWidth);

        onClickId(actionSheetSelected, R.id.btn_cashcoupon);
        onClickId(actionSheetSelected, R.id.btn_discount);
        onClickId(actionSheetSelected, R.id.btn_exchange);
        onClickId(actionSheetSelected, R.id.cancel);

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

}
