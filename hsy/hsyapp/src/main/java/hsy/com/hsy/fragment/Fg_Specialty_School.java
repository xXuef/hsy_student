package hsy.com.hsy.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import hsy.com.hsy.R;
import hsy.com.hsy.adapter.SchoolItemAdapter;
import hsy.com.hsy.base.BaseFragment;

public class Fg_Specialty_School extends BaseFragment {

    private ListView listView;
    List<String> icons;
    List<String> names;
    List<String> ofs;
    List<String> types;
    List<String> hotss;
    List<String> Ranking;
    private TextView school_num;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_search_school;
    }

    @Override
    protected void initParams(View view, Bundle savedInstanceState) {

        //将引用过来的布局文件的搜索框去掉
        view.findViewById(R.id.title_layout).setVisibility(View.GONE);
        school_num = view.findViewById(R.id.num_school);
        listView = (ListView) view.findViewById(R.id.lv_school);

        initData();
        school_num.setText("共找到" + icons.size() + "所院校");
        SchoolItemAdapter schoolItemAdapter = new SchoolItemAdapter(getContext(), icons.size(), icons, names, ofs, types, hotss, Ranking);
        listView.setAdapter(schoolItemAdapter);
    }

    private void initData() {
        icons = new ArrayList<>();
        names = new ArrayList<>();
        ofs = new ArrayList<>();
        types = new ArrayList<>();
        hotss = new ArrayList<>();
        Ranking = new ArrayList<>();

        icons.add("https://ss0.baidu.com/6ONWsjip0QIZ8tyhnq/it/u=2031677745,545048845&fm=58&bpow=400&bpoh=400");
        icons.add("https://ss0.baidu.com/6ONWsjip0QIZ8tyhnq/it/u=2031677745,545048845&fm=58&bpow=400&bpoh=400");
        icons.add("https://ss2.baidu.com/6ONYsjip0QIZ8tyhnq/it/u=3360714137,2511773209&fm=58&w=200&h=200&img.JPEG");
        names.add("复旦大学");
        names.add("复旦大学");
        names.add("西安交通大学");
        ofs.add("隶属:教育部");
        ofs.add("隶属:教育部");
        ofs.add("隶属:教育部");
        types.add("性质:公立");
        types.add("性质:公立");
        types.add("性质:公立");
        hotss.add("热度: 13.9万");
        hotss.add("热度: 13.9万");
        hotss.add("热度: 15.9万");
        Ranking.add("全国排名: 4");
        Ranking.add("全国排名: 4");
        Ranking.add("全国排名: 16");
    }
}
