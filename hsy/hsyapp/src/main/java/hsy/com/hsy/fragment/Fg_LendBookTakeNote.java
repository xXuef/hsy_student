package hsy.com.hsy.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import hsy.com.hsy.R;
import hsy.com.hsy.adapter.LendTakeNoteRecyclerAdapter;
import hsy.com.hsy.base.BaseFragment;

public class Fg_LendBookTakeNote extends BaseFragment {


    private RecyclerView recyclerView;
    List<String> icons;
    List<String> names;
    List<String> versons;
    List<String> backTimes;
    List<String> times;

    @Override
    protected int getLayoutId() {
        return R.layout.fg_lendbook_takenote;
    }

    @Override
    protected void initParams(View view, Bundle savedInstanceState) {

        initData();

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemViewCacheSize(2);
        recyclerView.setAdapter(new LendTakeNoteRecyclerAdapter(getContext(),icons,names,versons,backTimes,times));
    }

    private void initData() {
        icons =new ArrayList<>();
        names =new ArrayList<>();
        versons =new ArrayList<>();
        backTimes =new ArrayList<>();
        times =new ArrayList<>();

        icons.add("1231312");
        icons.add("1231312");
        icons.add("1231312");
        icons.add("1231312");

        names.add("中国百年实录");
        names.add("当代北京故宫史话");
        names.add("安娜卡列尼娜");
        names.add("海燕");

        versons.add("徐宪江");
        versons.add("郭京宁");
        versons.add("列夫·托尔斯泰");
        versons.add("高尔基");

        backTimes.add("应还时间:2018.4.1");
        backTimes.add("应还时间:2018.3.21");
        backTimes.add("应还时间:2018.3.16");
        backTimes.add("应还时间:2018.4.11");

        times.add("10");
        times.add("2");
        times.add("8");
        times.add("10");

    }
}
