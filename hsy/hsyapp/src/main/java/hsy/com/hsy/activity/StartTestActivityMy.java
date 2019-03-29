package hsy.com.hsy.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import hsy.com.hsy.R;
import hsy.com.hsy.adapter.TabFragmentShouYeAdapter;
import hsy.com.hsy.base.MyBaseActivity;
import hsy.com.hsy.fragment.Fg_Ben214;
import hsy.com.hsy.fragment.Fg_Zhuan26;

/**
 *功能·· 生涯规划··测评报告
 */
public class StartTestActivityMy extends MyBaseActivity {


    List<String> strings;
    List<Fragment> fragments;
    private TabLayout tab;
    private ViewPager vp;

    @Override
    public void initVariable() {
        setContentView(R.layout.activity_start_test);
        tool_title.setText("测评报告");
        tab = (TabLayout) findViewById(R.id.tl);
        vp = (ViewPager) findViewById(R.id.vp);
        fragments = new ArrayList<>();
        strings = new ArrayList<>();
        fragments.add(new Fg_Ben214());
        fragments.add(new Fg_Zhuan26());
        strings.add("214所本科大学");
        strings.add("26所高职院校");

        ArrayList<String> chooseSubjects = getIntent().getStringArrayListExtra("chooseSubjects");
        Log.e("科目数量",chooseSubjects.toString());

    }

    @Override
    public void toLoad(Bundle savedInstanceState) {

        vp.setAdapter(new TabFragmentShouYeAdapter(fragments, strings, getSupportFragmentManager(), this));
        tab.setupWithViewPager(vp);
    }
}
