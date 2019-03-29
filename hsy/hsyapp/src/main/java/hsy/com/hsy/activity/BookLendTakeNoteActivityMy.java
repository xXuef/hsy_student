package hsy.com.hsy.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import hsy.com.hsy.R;
import hsy.com.hsy.adapter.TabFragmentShouYeAdapter;
import hsy.com.hsy.base.MyBaseActivity;
import hsy.com.hsy.fragment.Fg_BackBookTackNote;
import hsy.com.hsy.fragment.Fg_LendBookTakeNote;

/**
 * 图书馆··记录
 */
public class BookLendTakeNoteActivityMy extends MyBaseActivity {


    @BindView(R.id.tl)
    TabLayout tl;
    @BindView(R.id.vp)
    ViewPager vp;

    List<Fragment> fragments;
    List<String> strings;

    @Override
    public void initVariable() {
        setContentView(R.layout.activity_book_lend_take_note);
        ButterKnife.bind(this);
        initData();
    }

    @Override
    public void toLoad(Bundle savedInstanceState) {

        vp.setAdapter(new TabFragmentShouYeAdapter(fragments, strings, getSupportFragmentManager(), this));
        tl.setupWithViewPager(vp);

    }

    private void initData() {
        tool_title.setText("记录");

        fragments = new ArrayList<>();
        fragments.add(new Fg_LendBookTakeNote());
        fragments.add(new Fg_BackBookTackNote());
        strings = new ArrayList<>();
        strings.add("借书记录");
        strings.add("还书记录");
    }
}
