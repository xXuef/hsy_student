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
import hsy.com.hsy.fragment.Fg_AskForJoinTeam;

/**
 *社团
 */
public class TeamActivityMy extends MyBaseActivity {




    @Override
    public void initVariable() {
        setContentView(R.layout.activity_team);
        tool_title.setText("社团");
        ViewPager viewpager = findViewById(R.id.viewpager);
        TabLayout tablayout = findViewById(R.id.tablayout);

        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new AlreadJoinedTeamAc());
        fragments.add(new Fg_AskForJoinTeam());
        List<String> strings = new ArrayList<>();
        strings.add("已加入社团");
        strings.add("申请加入");

        TabFragmentShouYeAdapter adapter = new TabFragmentShouYeAdapter(fragments,strings,getSupportFragmentManager(),this);

        viewpager.setAdapter(adapter);
        tablayout.setupWithViewPager(viewpager);



    }



    @Override
    public void toLoad(Bundle savedInstanceState) {



    }




}
