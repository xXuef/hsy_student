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
import hsy.com.hsy.fragment.Fg_History_TurnOfRun2;
import hsy.com.hsy.fragment.Fg_Taday_TurnOfRun;


/**
 *功能·· 考勤
 */
public class TurnOfWorkActivityMy extends MyBaseActivity {


    private TabLayout tablayout;
    private ViewPager viewpager;

    @Override
    public void initVariable() {
        setContentView(R.layout.activity_turn_of_work);
        tool_title.setText("考勤");
        tablayout = (TabLayout) findViewById(R.id.tablayout);
        viewpager = (ViewPager) findViewById(R.id.viewpager);
    }

    @Override
    public void toLoad(Bundle savedInstanceState) {
        List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(new Fg_Taday_TurnOfRun());
        fragmentList.add(new Fg_History_TurnOfRun2());
        List<String> stringList = new ArrayList<>();
        stringList.add("今日考勤");
        stringList.add("历史考勤");
        TabFragmentShouYeAdapter adapter = new TabFragmentShouYeAdapter(fragmentList, stringList,getSupportFragmentManager(),TurnOfWorkActivityMy.this);
        viewpager.setAdapter(adapter);
        tablayout.setupWithViewPager(viewpager);
    }
}
