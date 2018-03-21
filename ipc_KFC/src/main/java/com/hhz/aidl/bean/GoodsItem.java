package com.hhz.aidl.bean;


import com.hhz.aidl.R;

import java.util.ArrayList;

public class GoodsItem {
    public int id;
    public int typeId;
    public String name;
    public String saled;
    public String typeName;
    public double price;
    public int count;
    public int resource;

    public GoodsItem(int id, double price, String name, String saled, int resource, int typeId, String typeName) {
        this.id = id;
        this.price = price;
        this.name = name;
        this.saled = saled;
        this.resource = resource;
        this.typeId = typeId;
        this.typeName = typeName;
    }

    private static ArrayList<GoodsItem> goodsList;
    private static ArrayList<GoodsItem> typeList;

    public static ArrayList<GoodsItem> getTypeList() {
        if (typeList == null) {
            initData();
        }
        return typeList;
    }

    public static ArrayList<GoodsItem> getGoodsList() {
        if (goodsList == null) {
            initData();
        }
        return goodsList;
    }

    private static void initData() {
        goodsList = new ArrayList<>();
        typeList = new ArrayList<>();

        GoodsItem item = null;
        for (int i = 1; i < 2; i++) {
            for (int j = 1; j < 7; j++) {
                switch (i) {
                    case 1:
                        if (j == 1) {
                            item = new GoodsItem(j, 13, "劲爆鸡米花（大）", "38", R.mipmap.iv_jmhd, i, "小食/配餐");
                        } else if (j == 2) {
                            item = new GoodsItem(j, 11, "劲爆鸡米花（小）", "15", R.mipmap.iv_jmhx, i, "小食/配餐");
                        } else if (j == 3) {
                            item = new GoodsItem(j, 13, "鲜蔬沙拉", "4", R.mipmap.iv_scsl, i, "小食/配餐");
                        } else if (j == 4) {
                            item = new GoodsItem(j, 11, "黄金鸡块5块装", "44", R.mipmap.iv_hjjk, i, "小食/配餐");
                        } else if (j == 5) {
                            item = new GoodsItem(j, 6, "醇香土豆泥", "85", R.mipmap.iv_tdn, i, "小食/配餐");
                        } else if (j == 6) {
                            item = new GoodsItem(j, 8, "香甜栗米棒", "45", R.mipmap.iv_ymb, i, "小食/配餐");
                        }
                        break;

                    case 2:
                        if (j == 1) {
                            item = new GoodsItem(j, 19, "拿铁血橙派", "4", R.mipmap.iv_ntxcp, i, "K 咖啡");
                        } else if (j == 2) {
                            item = new GoodsItem(j, 16, "冰拿铁（中）", "4", R.mipmap.iv_bnt, i, "K 咖啡");
                        } else if(j == 3) {
                            item = new GoodsItem(j, 19, "热拿铁（大）葡挞", "2", R.mipmap.iv_rnt, i, "K 咖啡");
                        } else if (j == 4) {
                            item = new GoodsItem(j, 20, "冰美式新比利时巧圣", "3", R.mipmap.iv_ms, i, "K 咖啡");
                        } else if (j == 5) {
                            item = new GoodsItem(j, 20, "榛果风味冰拿铁（大）", "3", R.mipmap.iv_zgwnt, i, "K 咖啡");
                        } else if (j == 6) {
                            item = new GoodsItem(j, 14, "冰美式", "1", R.mipmap.iv_bms, i, "K 咖啡");
                        }
                        break;

                    case 3:
                        if (j == 3) {
                            item = new GoodsItem(j, 15, "老北京鸡肉卷", "65", R.mipmap.iv_bjjrj, i, "美味汉堡/卷");
                        } else if(j == 2){
                            item = new GoodsItem(j, 18, "新奥尔良烤鸡腿堡", "18" , R.mipmap.iv_aelkb, i, "美味汉堡/卷");
                        } else if(j == 3){
                            item = new GoodsItem(j, 17, "香辣鸡腿堡", "81" , R.mipmap.iv_xljtb, i, "美味汉堡/卷");
                        } else if (j == 4) {
                            item = new GoodsItem(j, 17, "劲脆鸡腿堡", "98", R.mipmap.iv_jcjtb, i, "美味汉堡/卷");
                        } else if (j == 5) {
                            item = new GoodsItem(j, 39, "香辣鸡腿堡土豆泥餐", "15", R.mipmap.iv_tdntc, i, "美味汉堡/卷");
                        } else if (j == 6) {
                            item = new GoodsItem(j, 35, "新奥尔良烤堡薯条餐", "17", R.mipmap.iv_aeltc, i, "美味汉堡/卷");
                        }
                        break;
                }
                goodsList.add(item);
            }
            typeList.add(item);
        }
    }
}
