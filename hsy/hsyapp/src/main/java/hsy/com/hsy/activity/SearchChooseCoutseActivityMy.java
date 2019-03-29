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
import hsy.com.hsy.fragment.Fg_SchoolChooseSubject;
import hsy.com.hsy.fragment.Fg_SubjectChooseSchool;

/**
 *功能·· 生涯规划··查选课
 */
public class SearchChooseCoutseActivityMy extends MyBaseActivity {


    @Override
    public void initVariable() {
        setContentView(R.layout.activity_choose_coutse);

        tool_title.setText("查选科");
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab);

        ViewPager viewPager = (ViewPager) findViewById(R.id.vp);


        List<Fragment> fragmentList =new ArrayList<>();
        List<String> stringList =new ArrayList<>();
        fragmentList.add(new Fg_SubjectChooseSchool());
        fragmentList.add(new Fg_SchoolChooseSubject());
        stringList.add("根据科目选大学（专业）");
        stringList.add("根据大学（专业）选科目");
        viewPager.setAdapter(new TabFragmentShouYeAdapter(fragmentList,stringList,getSupportFragmentManager(),this));

        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public void toLoad(Bundle savedInstanceState) {

    }
}
