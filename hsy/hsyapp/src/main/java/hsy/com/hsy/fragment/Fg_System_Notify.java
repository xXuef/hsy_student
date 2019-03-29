package hsy.com.hsy.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import hsy.com.hsy.R;
import hsy.com.hsy.adapter.NotifyItemAdapter;
import hsy.com.hsy.base.BaseFragment;

/**
 * Created by Administrator on 2018/4/18.
 */

public class Fg_System_Notify extends BaseFragment {
    List<String> names;
    List<String> importants;
    List<String> times;
    List<String> contents;



    @Override
    protected int getLayoutId() {
        return R.layout.fg_schoolin_notify;
    }

    @Override
    protected void initParams(View view, Bundle savedInstanceState) {

        ListView lv = view.findViewById(R.id.lv_ss);
        initData();
        lv.setAdapter(new NotifyItemAdapter(getContext(),3,names,importants,times,contents));
    }


    public void initData() {
        names = new ArrayList<>();
        names.add("音为青春”中国大学音乐超级联赛");
        names.add("中国大学音乐超级联赛，音为青春");
        names.add("中国大学音乐超级联赛");
        importants = new ArrayList<>();
        importants.add("重要");
        importants.add("普通");
        importants.add("紧急");
        times = new ArrayList<>();
        times.add("11:23");
        times.add("12:43");
        times.add("4:52");
        contents = new ArrayList<>();
        contents.add("中国移动咪咕音乐大音联赛开始报名了~中国最大规模的音乐高校竞赛，百万音乐梦想创业基金。");
        contents.add("中国最大规模的音乐高校竞赛，百万音乐梦想创业基金中国移动咪咕音乐大音联赛开始报名了~。");
        contents.add("百万音乐梦想创业基金,中国移动咪咕音乐大音联赛开始报名了~中国最大规模的音乐高校竞赛。");
    }

}
