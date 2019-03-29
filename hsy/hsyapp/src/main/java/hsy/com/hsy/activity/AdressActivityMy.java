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
import hsy.com.hsy.fragment.Fg_AdressClass;
import hsy.com.hsy.fragment.Fg_AdressSchool;
import hsy.com.hsy.fragment.Fg_AdressTeacher;
import hsy.com.hsy.fragment.Fg_AdressTeam;

/**
 * 通讯录  界面
 */
public class AdressActivityMy extends MyBaseActivity {

    private TabLayout tab;
    private ViewPager vp;
    private List<Fragment> fragments;
    private List<String> strings;

    @Override
    public void initVariable() {
        setContentView(R.layout.activity_adress);
        tool_title.setText("通讯录");
        tab = (TabLayout) findViewById(R.id.tab);
        vp = (ViewPager) findViewById(R.id.viewpager);

    }

    @Override
    public void toLoad(Bundle savedInstanceState) {

        fragments = new ArrayList<>();
        fragments.add(new Fg_AdressClass());
        fragments.add(new Fg_AdressTeam());
        fragments.add(new Fg_AdressTeacher());
        fragments.add(new Fg_AdressSchool());
        strings =new ArrayList<>();
        strings.add("班级");
        strings.add("社团");
        strings.add("教师");
        strings.add("学校");

        vp.setAdapter(new TabFragmentShouYeAdapter(fragments,strings,getSupportFragmentManager(),this));

        tab.setupWithViewPager(vp);
    }
}
