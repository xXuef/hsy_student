package hsy.com.hsy.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import hsy.com.hsy.R;
import hsy.com.hsy.adapter.TabFragmentShouYeAdapter;
import hsy.com.hsy.base.BaseFragment;

/**
 * 作者：Administrator on 2018/4/14 11:38
 */

public class NotifyFragment extends BaseFragment {


    @Override
    protected int getLayoutId() {
        return R.layout.notifyfragment;
    }

    @Override
    protected void initParams(View view, Bundle savedInstanceState) {
        TabLayout tablayout = (TabLayout) view.findViewById(R.id.tablayout);
        ViewPager viewpager = (ViewPager) view.findViewById(R.id.viewpager);
        TextView textView = (TextView) view.findViewById(R.id.title_name);
        textView.setText("通知");

        List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(new Fg_SchoolIn_Notify());
        fragmentList.add(new Fg_Class_Notify());
        fragmentList.add(new Fg_System_Notify());
        //这里是自己弄出来的功能实验界面 终成
//        fragmentList.add(new Fg_Myfun());
        List<String> stringList = new ArrayList<>();
        stringList.add("校园通知");
        stringList.add("班级通知");
        stringList.add("系统通知");
//        stringList.add("Fun");
        TabFragmentShouYeAdapter adapter = new TabFragmentShouYeAdapter(fragmentList, stringList, getChildFragmentManager(), getContext());
        viewpager.setAdapter(adapter);
        tablayout.setupWithViewPager(viewpager);
    }
}
