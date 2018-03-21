package com.hhz.aidl;


import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.flipboard.bottomsheet.BottomSheetLayout;
import com.handpay.aidl.Bill;
import com.handpay.sdk.core.ControllerListener;
import com.handpay.sdk.core.SmartSDKController;
import com.hhz.aidl.adapter.GoodsAdapter;
import com.hhz.aidl.adapter.SelectAdapter;
import com.hhz.aidl.adapter.TypeAdapter;
import com.hhz.aidl.bean.GoodsItem;
import com.hhz.aidl.utils.LogT;
import com.hhz.aidl.view.DividerDecoration;

import java.text.NumberFormat;
import java.util.ArrayList;

import se.emilsjolander.stickylistheaders.StickyListHeadersListView;

public class ShopCarActivity extends AppCompatActivity implements View.OnClickListener,ControllerListener {

    public static ImageView imgCart;
    public static ViewGroup anim_mask_layout;
    private RecyclerView rvType, rvSelected;
    private TextView tvCount, tvCost, tvSubmit, tvTips;
    private BottomSheetLayout bottomSheetLayout;
    private View bottomSheet;
    public static StickyListHeadersListView listView;
    private ArrayList<GoodsItem> dataList, typeList;
    private SparseArray<GoodsItem> selectedList;
    private SparseIntArray groupSelect;
    private GoodsAdapter myAdapter;
    private SelectAdapter selectAdapter;
    private TypeAdapter typeAdapter;
    private NumberFormat nf;
    double allmoney = 0;

    private int state;

    private StringBuffer sbu_log=new StringBuffer("info:\n");

    @SuppressLint("HandlerLeak")
    private Handler uiHandler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            if (state == 1){
                clearCart();
                showDialog("付款成功","您已付款成功，请等待配送。");
            } else if(state == -105){
                showDialog("交易失败","智能POS应用未安装！");
            }else {
                showDialog("购买失败","购买失败，请重新购买。");
            }
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_cart);

        nf = NumberFormat.getCurrencyInstance();
        nf.setMaximumFractionDigits(2);//设置小数部分最大允许两位
        typeList = GoodsItem.getTypeList();
        dataList = GoodsItem.getGoodsList();

        selectedList = new SparseArray<>();
        groupSelect = new SparseIntArray();
        initView();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bottom:
                showBottomSheet();
                break;
            case R.id.clear:
                clearCart();
                break;
            case R.id.tvSubmit:
                LogT.w(String.valueOf(allmoney));
                double allpaymoney = allmoney + 9;
                String money = String.valueOf(allpaymoney * 100);
                String all_momey = money.substring(0,money.indexOf("."));
                if (allmoney <= 0) {
                    Toast.makeText(ShopCarActivity.this, "总付款额为空，不能支付！", Toast.LENGTH_LONG).show();
                } else {
                    SmartSDKController.builder(this.getApplicationContext())
                            .setCallBackListener(this)
                            .smartPay("43145711", "123456", String.valueOf(all_momey));//132测试环境

                }
                break;
            default:
                break;
        }
    }

    @Override
    public void tranResult(Bill mBill) {
        LogT.w("----数据回执："+mBill.toString());
        state = mBill.getTranState();
        uiHandler.sendEmptyMessage(0);
    }

    @Override
    public void Error(int code, String message) {
         LogT.w("----返回错误 code："+code+",msg:"+message);
        state = code;
        uiHandler.sendEmptyMessage(0);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        //一次流程走完务必调用
        SmartSDKController.builder(this).onDestroy();
        super.onDestroy();
    }

    private void initView() {
        tvCount = (TextView) findViewById(R.id.tvCount);
        tvCost = (TextView) findViewById(R.id.tvCost);
        tvTips = (TextView) findViewById(R.id.tvTips);
        tvSubmit = (TextView) findViewById(R.id.tvSubmit);
        rvType = (RecyclerView) findViewById(R.id.typeRecyclerView);

        imgCart = (ImageView) findViewById(R.id.imgCart);
        anim_mask_layout = (RelativeLayout) findViewById(R.id.containerLayout);
        bottomSheetLayout = (BottomSheetLayout) findViewById(R.id.bottomSheetLayout);

        listView = (StickyListHeadersListView) findViewById(R.id.itemListView);

        rvType.setLayoutManager(new LinearLayoutManager(this));
        typeAdapter = new TypeAdapter(this, typeList);
        rvType.setAdapter(typeAdapter);
        rvType.addItemDecoration(new DividerDecoration(this));

        myAdapter = new GoodsAdapter(dataList, this);
        listView.setAdapter(myAdapter);

        listView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                GoodsItem item = dataList.get(firstVisibleItem);
                if (typeAdapter.selectTypeId != item.typeId) {
                    typeAdapter.selectTypeId = item.typeId;
                    typeAdapter.notifyDataSetChanged();
                    rvType.smoothScrollToPosition(getSelectedGroupPosition(item.typeId));
                }
            }
        });
    }


    //添加商品
    public void add(GoodsItem item, boolean refreshGoodList) {
        int groupCount = groupSelect.get(item.typeId);
        if (groupCount == 0) {
            groupSelect.append(item.typeId, 1);
        } else {
            groupSelect.append(item.typeId, ++groupCount);
        }
        GoodsItem temp = selectedList.get(item.id);
        if (temp == null) {
            item.count = 1;
            selectedList.append(item.id, item);
        } else {
            temp.count++;
        }
        update(refreshGoodList);
    }

    //移除商品
    public void remove(GoodsItem item, boolean refreshGoodList) {
        int groupCount = groupSelect.get(item.typeId);
        if (groupCount == 1) {
            groupSelect.delete(item.typeId);
        } else if (groupCount > 1) {
            groupSelect.append(item.typeId, --groupCount);
        }
        GoodsItem temp = selectedList.get(item.id);
        if (temp != null) {
            if (temp.count < 2) {
                selectedList.remove(item.id);
            } else {
                item.count--;
            }
        }
        update(refreshGoodList);
    }

    //刷新布局 总价、购买数量等
    private void update(boolean refreshGoodList) {
        int size = selectedList.size();
        int count = 0;
        double cost = 0;
        for (int i = 0; i < size; i++) {
            GoodsItem item = selectedList.valueAt(i);
            count += item.count;
            cost += item.count * item.price;
        }
        if (count < 1) {
            imgCart.setImageResource(R.mipmap.iv_car_black);
            tvCount.setVisibility(View.GONE);
        } else {
            imgCart.setImageResource(R.mipmap.iv_car);
            tvCount.setVisibility(View.VISIBLE);
        }
        tvCount.setText(String.valueOf(count));

        if (cost > 0) {
            tvTips.setVisibility(View.GONE);
            tvSubmit.setVisibility(View.VISIBLE);
        } else {
            tvSubmit.setVisibility(View.GONE);
            tvTips.setVisibility(View.VISIBLE);
        }
        Log.e("cost:", cost + "");
        allmoney = cost;
        Log.e("allmoney:", allmoney + "");
        tvCost.setText(nf.format(cost));

        if (myAdapter != null && refreshGoodList) {
            myAdapter.notifyDataSetChanged();
        }
        if (selectAdapter != null) {
            selectAdapter.notifyDataSetChanged();
        }
        if (typeAdapter != null) {
            typeAdapter.notifyDataSetChanged();
        }
        if (bottomSheetLayout.isSheetShowing() && selectedList.size() < 1) {
            bottomSheetLayout.dismissSheet();
        }
    }

    //清空购物车
    public void clearCart() {
        selectedList.clear();
        groupSelect.clear();
        update(true);

    }

    //根据商品id获取当前商品的采购数量
    public int getSelectedItemCountById(int id) {
        GoodsItem temp = selectedList.get(id);
        if (temp == null) {
            return 0;
        }
        return temp.count;
    }

    //根据类别Id获取属于当前类别的数量
    public int getSelectedGroupCountByTypeId(int typeId) {
        return groupSelect.get(typeId);
    }

    //根据类别id获取分类的Position 用于滚动左侧的类别列表
    public int getSelectedGroupPosition(int typeId) {
        for (int i = 0; i < typeList.size(); i++) {
            if (typeId == typeList.get(i).typeId) {
                return i;
            }
        }
        return 0;
    }

    public void onTypeClicked(int typeId) {
        listView.setSelection(getSelectedPosition(typeId));
    }

    private int getSelectedPosition(int typeId) {
        int position = 0;
        for (int i = 0; i < dataList.size(); i++) {
            if (dataList.get(i).typeId == typeId) {
                position = i;
                break;
            }
        }
        return position;
    }

    private View createBottomSheetView() {
        View view = LayoutInflater.from(this).inflate(R.layout.layout_bottom_sheet, (ViewGroup) getWindow().getDecorView(), false);
        rvSelected = (RecyclerView) view.findViewById(R.id.selectRecyclerView);
        rvSelected.setLayoutManager(new LinearLayoutManager(this));
        TextView clear = (TextView) view.findViewById(R.id.clear);
        clear.setOnClickListener(this);
        selectAdapter = new SelectAdapter(this, selectedList);
        rvSelected.setAdapter(selectAdapter);
        return view;
    }

    private void showBottomSheet() {
        if (bottomSheet == null) {
            bottomSheet = createBottomSheetView();
        }
        if (bottomSheetLayout.isSheetShowing()) {
            bottomSheetLayout.dismissSheet();
        } else {
            if (selectedList.size() != 0) {
                bottomSheetLayout.showWithSheetView(bottomSheet);
            }
        }
    }

    private void showDialog(String title, String src) {
        AlertDialog.Builder dialog = new AlertDialog.Builder(ShopCarActivity.this);
        final View dialogView = LayoutInflater.from(ShopCarActivity.this)
                .inflate(R.layout.dialog_customize, null);

        TextView tv = (TextView) dialogView.findViewById(R.id.text);
        tv.setText(src);

        dialog.setTitle(title);
        dialog.setView(dialogView);
        dialog.setPositiveButton("确定",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        dialog.show();
    }

}
