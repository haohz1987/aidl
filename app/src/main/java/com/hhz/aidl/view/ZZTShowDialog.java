package com.hhz.aidl.view;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.Button;

public class ZZTShowDialog<T extends View> {
    private Context context;
    private Dialogcallback dialogcallback;
    private Dialog dialog;
    private Button sure, cancle;
    private T mContentView;

    public ZZTShowDialog() {
        super();
    }

    public ZZTShowDialog(Context context, T view, int dialog_theme) {
        this.context = context;
        this.mContentView = view;
        dialog = new Dialog(context, dialog_theme);
        dialog.setContentView(view);
    }
    public ZZTShowDialog(Context context, T view, boolean cancelable, int dialog_theme) {
        this.context = context;
        this.mContentView = view;
        dialog = new Dialog(context, dialog_theme);
        dialog.setContentView(view);
        dialog.setCancelable(cancelable);
    }
    public ZZTShowDialog(Context context, T view) {
        this.context = context;
        this.mContentView = view;
        dialog = new Dialog(context);
        dialog.setContentView(view);
    }
    public T getContentView() {
        if (mContentView != null) {
            return mContentView;
        }
        return null;
    }

    public void show() {
        dialog.show();
    }

    public void hide() {
        dialog.hide();
    }

    public void dismiss() {
        dialog.dismiss();
    }

    public interface Dialogcallback {
        public void ButtonOk();

        public void ButtonCancle();
    }

    public void setDialogCallback(Dialogcallback dialogcallback) {
        this.dialogcallback = dialogcallback;
    }

    public Dialog getDialog() {
        return dialog;
    }
}
