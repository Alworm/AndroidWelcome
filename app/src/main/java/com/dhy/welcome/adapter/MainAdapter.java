package com.dhy.welcome.adapter;



import java.util.List;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class MainAdapter extends FragmentStatePagerAdapter {
    private List<Fragment> list;
    //构造函数
    public MainAdapter(FragmentManager fm, List<Fragment> list) {
        super(fm);
        this.list = list;
    }

    //当前界面是哪个
    @Override
    public Fragment getItem(int i) {
        return list.get(i);
    }
    //有几个界面
    @Override
    public int getCount() {
        return list.size();
    }
}
