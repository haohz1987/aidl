package com.hhz.aidl;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.hhz.aidl.service.IntentServiceDemo;
import com.hhz.aidl.service.ServiceDemo;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,
        ActionSheetCoupon.OnActionSheetSelected, ColorSelectDialog.OnColorSelected {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn_service).setOnClickListener(this);
        findViewById(R.id.btn_intentservice).setOnClickListener(this);
        findViewById(R.id.btn_color_select).setOnClickListener(this);
        findViewById(R.id.btn_coupon_select).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_service:
                startService(new Intent(MainActivity.this, ServiceDemo.class));
                break;
            case R.id.btn_intentservice:
                startService(new Intent(MainActivity.this, IntentServiceDemo.class));
                break;
            //会员卡颜色选择
            case R.id.btn_color_select:
                ColorSelectDialog.selectColor(MainActivity.this, MainActivity.this, new DialogInterface.OnCancelListener() {
                    @Override
                    public void onCancel(DialogInterface dialog) {

                    }
                });

                break;
            //会优惠券选择
            case R.id.btn_coupon_select:
                ActionSheetCoupon.showSheet(MainActivity.this, MainActivity.this,
                        new DialogInterface.OnCancelListener() {
                            @Override
                            public void onCancel(DialogInterface dialog) {

                            }
                        });
                break;
        }

    }

    @Override
    public void onSheetClick(int whichButton) {
        LogT.w("onSheetClick=" + whichButton);
        switch (whichButton) {
            case R.id.btn_cashcoupon:
                Toast.makeText(MainActivity.this, "代金券", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_discount:
                Toast.makeText(MainActivity.this, "折扣券", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_exchange:
                Toast.makeText(MainActivity.this, "兑换券", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActionSheetCoupon.showSheet(null, null, null);
    }

    @Override
    public void onColorSelected(int position) {
        LogT.w("onColorSelected=" + position);
        ((ImageView) findViewById(R.id.iv_select)).setImageResource(CouponColorType.getResID("" + (position+1)));
    }
}
