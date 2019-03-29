package hsy.com.hsy.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import hsy.com.hsy.R;
import hsy.com.hsy.adapter.TabFragmentShouYeAdapter;
import hsy.com.hsy.base.BaseFragment;
import hsy.com.hsy.fragment.Fg_Team_Approval;
import hsy.com.hsy.fragment.Fg_Team_Communicate;
import hsy.com.hsy.fragment.Fg_Team_Manager;
import hsy.com.hsy.fragment.Fg_Team_MemberMenage;

/**
 * 功能···已加入社团 界面
 */
public class AlreadJoinedTeamAc extends BaseFragment {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_alread_joined_team;
    }

    @Override
    protected void initParams(View view, Bundle savedInstanceState) {
        TabLayout tablayout = (TabLayout)view. findViewById(R.id.tablayout);
        ViewPager viewpager = (ViewPager)view. findViewById(R.id.viewpager);

        List<String> strings = new ArrayList<>();
        strings.add("社团交流");
        strings.add("部门管理");
        strings.add("待审批");
        strings.add("社员管理");
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new Fg_Team_Communicate());
        fragments.add(new Fg_Team_Manager());
        fragments.add(new Fg_Team_Approval());
        fragments.add(new Fg_Team_MemberMenage());

        viewpager.setAdapter(new TabFragmentShouYeAdapter(fragments, strings, getChildFragmentManager(), getContext()));
        tablayout.setupWithViewPager(viewpager);
    }
}
