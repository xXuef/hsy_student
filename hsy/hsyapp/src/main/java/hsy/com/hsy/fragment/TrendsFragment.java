package hsy.com.hsy.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import hsy.com.hsy.R;
import hsy.com.hsy.activity.SendPlayActivity;
import hsy.com.hsy.adapter.TabFragmentShouYeAdapter;

/**
 * 作者：Administrator on 2018/4/14 09:33
 */

public class TrendsFragment extends Fragment {


    /**
     * Description:网上弄的功能界面  真正的是fg_myfun
     * Data: 2018/6/8 16:06
     * @author: Summer
     */
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        final View inflate = inflater.inflate(R.layout.fragment_trends, container, false);

        TextView textView = (TextView) inflate.findViewById(R.id.title_name);
        final ImageView add = (ImageView) inflate.findViewById(R.id.add);
        textView.setText("动态");

        TabLayout tablayout = (TabLayout) inflate.findViewById(R.id.tablayout);
        ViewPager viewpager = (ViewPager) inflate.findViewById(R.id.viewpager);

        List<Fragment> fragmentList =new ArrayList<>();
        List<String> stringList =new ArrayList<>();

        fragmentList.add(new Fg_school_inside());
        fragmentList.add(new Fg_Class_Trends());
        fragmentList.add(new Fg_Self_Trends());
        fragmentList.add(new Fg_Group_Trends());
        stringList.add("校内动态");
        stringList.add("班级动态");
        stringList.add("个人动态");
        stringList.add("社团动态");

        //这里控制动态右上角的图标的显示
        viewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if (position==1){
                    add.setVisibility(View.VISIBLE);
                }else {
                    add.setVisibility(View.GONE);
                }
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        viewpager.setAdapter(new TabFragmentShouYeAdapter(fragmentList,stringList,getFragmentManager(),getContext()));

        tablayout.setupWithViewPager(viewpager);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), SendPlayActivity.class));
            }
        });
        return inflate;
    }
}


