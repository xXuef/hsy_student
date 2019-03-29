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
import hsy.com.hsy.fragment.Fg_Examination_Paper_Analysis;
import hsy.com.hsy.fragment.Fg_My_Achievements;
import hsy.com.hsy.fragment.Fg_test_situation;

/**
 * 成绩分析界面
 */
public class ResultExcelActivityMy extends MyBaseActivity {


    @Override
    public void initVariable() {
        setContentView(R.layout.activity_result_excel);
        tool_title.setText("成绩分析");
    }

    @Override
    public void toLoad(Bundle savedInstanceState) {
        TabLayout tab = (TabLayout) findViewById(R.id.tab);
        ViewPager viewpager = (ViewPager) findViewById(R.id.viewpager);
        List<Fragment> frags = new ArrayList<>();
        frags.add(new Fg_test_situation());
        frags.add(new Fg_Examination_Paper_Analysis());
        frags.add(new Fg_My_Achievements());
        List<String> strings = new ArrayList<>();
        strings.add("考试概况");
        strings.add("试卷分析");
        strings.add("我的成绩");

        viewpager.setAdapter(new TabFragmentShouYeAdapter(frags,strings,getSupportFragmentManager(),this));

        tab.setupWithViewPager(viewpager);
    }
}
