package hsy.com.hsy.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import hsy.com.hsy.R;
import hsy.com.hsy.adapter.TeamItemAdapter;
import hsy.com.hsy.base.BaseFragment;

public class Fg_AskForJoinTeam extends BaseFragment {
    private ListView listview;
    List<String> iconS;
    List<String> nameS;
    List<String> numPeople;
    List<String> createTimes;
    private TextView alread_joined;

    @Override
    protected int getLayoutId() {
        return R.layout.my_listview;
    }

    @Override
    protected void initParams(View view, Bundle savedInstanceState) {

        listview = (ListView)view. findViewById(R.id.listview);

        initData();
        listview.setAdapter(new TeamItemAdapter(getContext(),iconS,nameS,numPeople,createTimes));

    }

    private void initData() {
        iconS = new ArrayList<>();
        nameS = new ArrayList<>();
        numPeople = new ArrayList<>();
        createTimes = new ArrayList<>();

        iconS.add("");
        iconS.add("");
        iconS.add("");
        iconS.add("");

        nameS.add("摄影社");
        nameS.add("乒乓球社");
        nameS.add("篮球社");
        nameS.add("排球社");

        numPeople.add("成员:23人");
        numPeople.add("成员:11人");
        numPeople.add("成员:36人");
        numPeople.add("成员:47人");

        createTimes.add("成立时间:2017.5.8");
        createTimes.add("成立时间:2017.6.22");
        createTimes.add("成立时间:2017.4.3");
        createTimes.add("成立时间:2017.3.23");
    }
}
