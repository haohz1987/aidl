package com.hhz.aidl.adapter;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.PointF;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.hhz.aidl.R;
import com.hhz.aidl.ShopCarActivity;
import com.hhz.aidl.bean.GoodsItem;
import com.hhz.aidl.utils.PointFTypeEvaluator;
import com.hhz.aidl.view.FakeAddImageView;

import java.text.NumberFormat;
import java.util.ArrayList;

import se.emilsjolander.stickylistheaders.StickyListHeadersAdapter;

/* 右侧商品列表 */
public class GoodsAdapter extends BaseAdapter implements StickyListHeadersAdapter {

    private ArrayList<GoodsItem> dataList;
    private ShopCarActivity mContext;
    private NumberFormat nf;
    private LayoutInflater mInflater;

    public GoodsAdapter(ArrayList<GoodsItem> dataList, ShopCarActivity mContext) {
        this.dataList = dataList;
        this.mContext = mContext;
        nf = NumberFormat.getCurrencyInstance();
        nf.setMaximumFractionDigits(2);
        mInflater = LayoutInflater.from(mContext);
    }

    @Override
    public View getHeaderView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.item_header_view, parent, false);
        }
        ((TextView) (convertView)).setText(dataList.get(position).typeName);
        return convertView;
    }

    @Override
    public long getHeaderId(int position) {
        return dataList.get(position).typeId;
    }

    @Override
    public int getCount() {
        if (dataList == null) {
            return 0;
        }
        return dataList.size();
    }

    @Override
    public Object getItem(int position) {
        return dataList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final ItemViewHolder holder;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.item_goods, parent, false);
            holder = new ItemViewHolder();
            holder.name = (TextView) convertView.findViewById(R.id.tvName);
            holder.tvSaled = (TextView) convertView.findViewById(R.id.tv_saled);
            holder.price = (TextView) convertView.findViewById(R.id.tvPrice);
            holder.img = (ImageView) convertView.findViewById(R.id.img);
            holder.tvCount = (TextView) convertView.findViewById(R.id.count);
            holder.tvMinus = (TextView) convertView.findViewById(R.id.tvMinus);
            holder.tvAdd = (TextView) convertView.findViewById(R.id.tvAdd);
            convertView.setTag(holder);
        } else {
            holder = (ItemViewHolder) convertView.getTag();
        }
        final GoodsItem item = dataList.get(position);
        holder.name.setText(item.name);
        holder.tvSaled.setText("月售" + item.saled + "份");
        holder.img.setImageResource(item.resource);
        item.count = mContext.getSelectedItemCountById(item.id);
        holder.tvCount.setText(String.valueOf(item.count));
        holder.price.setText(nf.format(item.price));

        if (item.count < 1) {
            holder.tvCount.setVisibility(View.GONE);
            holder.tvMinus.setVisibility(View.GONE);
        } else {
            holder.tvCount.setVisibility(View.VISIBLE);
            holder.tvMinus.setVisibility(View.VISIBLE);
        }

        holder.tvAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int count = mContext.getSelectedItemCountById(item.id);
                if (count < 1) {
                    holder.tvMinus.setVisibility(View.VISIBLE);
                    holder.tvCount.setVisibility(View.VISIBLE);
                    add(holder.tvAdd, position);
                }
                mContext.add(item, false);
                add(holder.tvAdd, position);
                count++;
                holder.tvCount.setText(String.valueOf(count));
                int[] loc = new int[2];
                view.getLocationInWindow(loc);
            }
        });

        holder.tvMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int count = mContext.getSelectedItemCountById(item.id);
                if (count < 2) {
                    holder.tvMinus.setAnimation(getHiddenAnimation());
                    holder.tvMinus.setVisibility(View.GONE);
                    holder.tvCount.setVisibility(View.GONE);
                }
                count--;
                mContext.remove(item, false);
                holder.tvCount.setText(String.valueOf(count));
            }
        });
        return convertView;
    }

    class ItemViewHolder {
        int posi;
        TextView name, price, tvAdd, tvMinus, tvCount,tvSaled;
        ImageView img;
        GoodsItem item;
    }

    public void add(View view, int position) {
        int[] addLocation = new int[2];
        int[] cartLocation = new int[2];
        int[] recycleLocation = new int[2];
        view.getLocationInWindow(addLocation);
        ShopCarActivity.imgCart.getLocationInWindow(cartLocation);
        ShopCarActivity.listView.getLocationInWindow(recycleLocation);

        PointF startP = new PointF();
        PointF endP = new PointF();
        PointF controlP = new PointF();

        startP.x = addLocation[0];
        startP.y = addLocation[1] - recycleLocation[1];
        endP.x = cartLocation[0];
        endP.y = cartLocation[1] - recycleLocation[1];
        controlP.x = endP.x;
        controlP.y = startP.y;

        final FakeAddImageView fakeAddImageView = new FakeAddImageView(mContext);
        ShopCarActivity.anim_mask_layout.addView(fakeAddImageView);
        fakeAddImageView.setImageResource(R.mipmap.button_add);
        fakeAddImageView.getLayoutParams().width = mContext.getResources().getDimensionPixelSize(R.dimen.item_dish_circle_size);
        fakeAddImageView.getLayoutParams().height = mContext.getResources().getDimensionPixelSize(R.dimen.item_dish_circle_size);
        fakeAddImageView.setVisibility(View.VISIBLE);
        ObjectAnimator addAnimator = ObjectAnimator.ofObject(fakeAddImageView, "mPointF",
                new PointFTypeEvaluator(controlP), startP, endP);
        addAnimator.setInterpolator(new AccelerateInterpolator());
        addAnimator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {
                fakeAddImageView.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationEnd(Animator animator) {
                fakeAddImageView.setVisibility(View.GONE);
                ShopCarActivity.anim_mask_layout.removeView(fakeAddImageView);
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });
        ObjectAnimator scaleAnimatorX = new ObjectAnimator().ofFloat(ShopCarActivity.imgCart, "scaleX", 0.6f, 1.0f);
        ObjectAnimator scaleAnimatorY = new ObjectAnimator().ofFloat(ShopCarActivity.imgCart, "scaleY", 0.6f, 1.0f);
        scaleAnimatorX.setInterpolator(new AccelerateInterpolator());
        scaleAnimatorY.setInterpolator(new AccelerateInterpolator());
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(scaleAnimatorX).with(scaleAnimatorY).after(addAnimator);
        animatorSet.setDuration(800);
        animatorSet.start();
    }

    private Animation getHiddenAnimation() {
        AnimationSet set = new AnimationSet(true);
        RotateAnimation rotate = new RotateAnimation(0, 720, RotateAnimation.RELATIVE_TO_SELF, 0.5f, RotateAnimation.RELATIVE_TO_SELF, 0.5f);
        set.addAnimation(rotate);
        TranslateAnimation translate = new TranslateAnimation(
                TranslateAnimation.RELATIVE_TO_SELF, 0
                , TranslateAnimation.RELATIVE_TO_SELF, 2f
                , TranslateAnimation.RELATIVE_TO_SELF, 0
                , TranslateAnimation.RELATIVE_TO_SELF, 0);
        set.addAnimation(translate);
        AlphaAnimation alpha = new AlphaAnimation(1, 0);
        set.addAnimation(alpha);
        set.setDuration(500);
        return set;
    }
}
