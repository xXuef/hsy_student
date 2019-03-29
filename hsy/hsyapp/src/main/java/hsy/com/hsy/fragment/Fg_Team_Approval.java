package hsy.com.hsy.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import hsy.com.hsy.R;
import hsy.com.hsy.adapter.ApprocalAdapter;
import hsy.com.hsy.base.BaseFragment;

public class Fg_Team_Approval extends BaseFragment {


    private ListView listView;

    @Override
    protected int getLayoutId() {
        return R.layout.my_listview;
    }

    List<String> imglist;
    List<String> namelist;
    List<String> questlist;
    List<String> statelist;

    @Override
    protected void initParams(View view, Bundle savedInstanceState) {
        listView = (ListView) view.findViewById(R.id.listview);
        initdata();

        ApprocalAdapter listAdapter = new ApprocalAdapter(getContext(),imglist.size(),imglist,namelist,questlist,statelist);

        listView.setAdapter(listAdapter);
    }

    private void initdata() {
        imglist= new ArrayList<>();
        namelist= new ArrayList<>();
        questlist= new ArrayList<>();
        statelist= new ArrayList<>();
        imglist.add("https://ss0.baidu.com/6ONWsjip0QIZ8tyhnq/it/u=2031677745,545048845&fm=58&bpow=400&bpoh=400");
        imglist.add("https://ss0.baidu.com/6ONWsjip0QIZ8tyhnq/it/u=2031677745,545048845&fm=58&bpow=400&bpoh=400");
        imglist.add("https://ss0.baidu.com/6ONWsjip0QIZ8tyhnq/it/u=2031677745,545048845&fm=58&bpow=400&bpoh=400");
        namelist.add("张三");
        namelist.add("张三");
        namelist.add("张三");
        questlist.add("申请加入");
        questlist.add("申请加入");
        questlist.add("申请加入");
        statelist.add("待审批");
        statelist.add("待审批");
        statelist.add("待审批");
    }




}
