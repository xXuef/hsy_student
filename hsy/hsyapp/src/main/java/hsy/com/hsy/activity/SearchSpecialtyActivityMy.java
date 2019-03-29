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
import hsy.com.hsy.fragment.Fg_School_Ben;
import hsy.com.hsy.fragment.Fg_School_Zhuan;

/**
 *功能·· 生涯规划··查专业
 */
public class SearchSpecialtyActivityMy extends MyBaseActivity {

    @Override
    public void initVariable() {
        setContentView(R.layout.activity_search_specialty);
        tool_title.setText("查专业");


        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab);

        ViewPager viewPager = (ViewPager) findViewById(R.id.vp);


        List<Fragment> fragmentList =new ArrayList<>();
        List<String> stringList =new ArrayList<>();
        fragmentList.add(new Fg_School_Ben());
        fragmentList.add(new Fg_School_Zhuan());
        stringList.add("本科专业");
        stringList.add("专科专业");
        viewPager.setAdapter(new TabFragmentShouYeAdapter(fragmentList,stringList,getSupportFragmentManager(),this));

        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public void toLoad(Bundle savedInstanceState) {

    }
}
