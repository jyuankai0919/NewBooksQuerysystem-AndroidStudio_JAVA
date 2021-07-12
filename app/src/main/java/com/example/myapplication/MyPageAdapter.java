package com.example.myapplication;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyPageAdapter extends PagerAdapter {
    List<View> mPager;
    int myCount=0;
    List<String> number=new ArrayList<String>();


    public MyPageAdapter(List<View> mPager1){
            this.mPager=mPager1;
    }

    @Override
    public int getItemPosition(@NonNull Object object) {
        if (myCount>0){
            myCount--;
            return POSITION_NONE;
        }

        return super.getItemPosition(object);
    }
    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        mPager.get(position).setTag(position);
        ((ViewPager)container).addView(mPager.get(position));
        return mPager.get(position);

    }
    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
       container.removeView((View)object);

    }

    @Override
    public void notifyDataSetChanged() {
        myCount=getCount();
        super.notifyDataSetChanged();
    }
    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {

        number=Arrays.asList("心理學","理財類","投資類","英語類","數學類","設計類","科學類","傳記類","成功法","電腦程式設計","醫學類","期刊","文集類","其他","搜尋");


        return (number.get(position));

        //return super.getPageTitle(position);
    }
    @Override
    public int getCount() {
        return mPager.size();
    }
    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        //return false;
        return view==object;
    }
}
