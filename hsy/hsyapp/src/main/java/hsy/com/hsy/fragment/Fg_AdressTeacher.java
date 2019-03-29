package hsy.com.hsy.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import hsy.com.hsy.R;
import hsy.com.hsy.adapter.AdressNumAdapter;
import hsy.com.hsy.base.BaseFragment;

public class Fg_AdressTeacher extends BaseFragment {
    Context activity;
    private RecyclerView recy;
    List<String> iphoneIcons;
    List<String> names;
    List<String> clases;
    List<String> teams;
    List<String> prfession;

    @Override
    protected int getLayoutId() {
        return R.layout.fg_adress_class;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.activity =activity;
    }

    @Override
    protected void initParams(View view, Bundle savedInstanceState) {

        initData();
        recy = (RecyclerView) view.findViewById(R.id.rlv);

        recy.setLayoutManager(new LinearLayoutManager(activity));
        recy.setAdapter(new AdressNumAdapter(activity,iphoneIcons,names,clases,prfession));

    }

    private void initData() {
        iphoneIcons = new ArrayList<>();
        iphoneIcons.add("123");
        iphoneIcons.add("123");
        iphoneIcons.add("123");
        iphoneIcons.add("123");
        iphoneIcons.add("123");
        names = new ArrayList<>();
        names.add("小明");
        names.add("小华");
        names.add("刘明");
        names.add("或钳");
        names.add("刘明");
        clases = new ArrayList<>();
        clases.add("班级: 高二一班");
        clases.add("班级: 高一三班");
        clases.add("班级: 高二一班");
        clases.add("班级: 高三一班");
        clases.add("班级: 高二一班");
        teams = new ArrayList<>();
        teams.add("社团:摄影社");
        teams.add("社团:排球社");
        teams.add("社团:足球社");
        teams.add("社团:舞蹈社");
        teams.add("社团:篮球社");
        prfession = new ArrayList<>();
        prfession.add("");
        prfession.add("班主任");
        prfession.add("");
        prfession.add("副班主任");
        prfession.add("");
    }
}
