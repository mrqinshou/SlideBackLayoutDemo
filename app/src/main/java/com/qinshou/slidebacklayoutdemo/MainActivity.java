package com.qinshou.slidebacklayoutdemo;

import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SeekBar;

import com.qinshou.slidebacklayoutdemo.widget.SlideBackLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //创建侧滑关闭 Activity 控件
        SlideBackLayout mSlideBackLayout = new SlideBackLayout(this);
        //绑定 Activity
        mSlideBackLayout.bindActivity(this);
        mSlideBackLayout.unbindActivity();
        //初始化 ViewPager
        ViewPager vpTest = (ViewPager) findViewById(R.id.vp_test);
        int[] resource = new int[]{R.drawable.a, R.drawable.b, R.drawable.c
                , R.drawable.d, R.drawable.e, R.drawable.f};
        List<View> viewList = new ArrayList<>();
        for (int i = 0; i < resource.length; i++) {
            ImageView mImageView = new ImageView(this);
            mImageView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            mImageView.setImageResource(resource[i]);
            viewList.add(mImageView);
        }
        vpTest.setAdapter(new MyViewPagerAdapter(viewList));
        //初始化 SeekBar，添加至希望不被拦截触摸事件的容器中
        SeekBar sbText = (SeekBar) findViewById(R.id.sb_test);
        mSlideBackLayout.addNotInterceptView(sbText);
    }

    private class MyViewPagerAdapter extends PagerAdapter {
        private List<View> viewList = new ArrayList<>();

        public MyViewPagerAdapter(List<View> viewList) {
            this.viewList = viewList;
        }

        @Override
        public int getCount() {
            return viewList.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(viewList.get(position));
            return viewList.get(position);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(viewList.get(position));
        }
    }
}
