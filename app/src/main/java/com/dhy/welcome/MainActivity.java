package com.dhy.welcome;

import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.ImageButton;


import com.dhy.welcome.adapter.MainAdapter;
import com.dhy.welcome.fragment.FourFragment;
import com.dhy.welcome.fragment.OneFragment;
import com.dhy.welcome.fragment.ThreeFragment;
import com.dhy.welcome.fragment.TwoFragment;

import java.util.ArrayList;
import java.util.List;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.ViewPager;

public class MainActivity extends FragmentActivity implements View.OnClickListener {
    private static final String TAG = "MainActivity";
    private ViewPager viewPager;
    private ImageButton imgOne;
    private ImageButton imgTwo;
    private ImageButton imgThree;
    private ImageButton imgFour;
    private List<Fragment> list;
    private MainAdapter adapter;
    private View currentButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findView();
    }

    private void findView() {
        //28->  API  更新
        viewPager = findViewById(R.id.view_pager);
        imgOne = findViewById(R.id.img_one);
        imgOne.setOnClickListener(this);
        imgTwo = findViewById(R.id.img_two);
        imgTwo.setOnClickListener(this);
        imgThree = findViewById(R.id.img_three);
        imgThree.setOnClickListener(this);
        imgFour = findViewById(R.id.img_four);
        imgFour.setOnClickListener(this);
        list = new ArrayList<>();
        Fragment oneFragment = new OneFragment();
        list.add(oneFragment);
        Fragment twoFragment = new TwoFragment();
        list.add(twoFragment);
        Fragment threeFragment = new ThreeFragment();
        list.add(threeFragment);
        Fragment fourFragment = new FourFragment();
        list.add(fourFragment);
        adapter = new MainAdapter(getSupportFragmentManager(),list);
        viewPager.setAdapter(adapter);
        //默认点击
        imgOne.performClick();
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                switch (i){
                    case 0:
                        setButton(imgOne);
                        break;
                    case 1:
                        setButton(imgTwo);
                        break;
                    case 2:
                        setButton(imgThree);
                        break;
                    case 3:
                        setButton(imgFour);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.img_one:
                viewPager.setCurrentItem(0);
                setButton(v);
//                Log.d(TAG, "onClick: 点击第一个按钮");
                break;
            case R.id.img_two:
                viewPager.setCurrentItem(1);
                setButton(v);
                Log.d(TAG, "onClick: 点击第二个按钮");
                break;
            case R.id.img_three:
                viewPager.setCurrentItem(2);
                setButton(v);
                Log.d(TAG, "onClick: 点击第三个按钮");
                break;
            case R.id.img_four:
                viewPager.setCurrentItem(3);
                setButton(v);
                Log.d(TAG, "onClick: 点击第四个按钮");
                break;
                
        }

    }
    private void setButton(View v){
        if(currentButton!=null&&currentButton.getId()!=v.getId()){
            currentButton.setEnabled(true);
        }
        v.setEnabled(false);
        currentButton = v;
    }
}
