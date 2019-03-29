package hsy.com.hsy.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import java.util.ArrayList;
import java.util.List;

import hsy.com.hsy.R;
import hsy.com.hsy.adapter.TabFragmentShouYeAdapter;
import hsy.com.hsy.base.MyBaseActivity;
import hsy.com.hsy.fragment.Fg_Specialty_Direction;
import hsy.com.hsy.fragment.Fg_Specialty_Recommend;
import hsy.com.hsy.fragment.Fg_Specialty_School;

public class SpecialtyDirectionActivity extends MyBaseActivity{


    @Override
    public void initVariable() {
        setContentView(R.layout.activity_specialty_direction);
        tool_title.setText("哲学");
        TabLayout tablayout = (TabLayout) findViewById(R.id.tablayout);
        ViewPager viewpager = (ViewPager) findViewById(R.id.viewpager);

        List<Fragment> fragmentList =new ArrayList<>();
        List<String> stringList =new ArrayList<>();

        fragmentList.add(new Fg_Specialty_Recommend());
        fragmentList.add(new Fg_Specialty_Direction());
        fragmentList.add(new Fg_Specialty_School());
        stringList.add("专业介绍");
        stringList.add("职业方向");
        stringList.add("开设院校");

        viewpager.setAdapter(new TabFragmentShouYeAdapter(fragmentList,stringList,getSupportFragmentManager(),this));

        tablayout.setupWithViewPager(viewpager);
    }

    @Override
    public void toLoad(Bundle savedInstanceState) {

    }
}
