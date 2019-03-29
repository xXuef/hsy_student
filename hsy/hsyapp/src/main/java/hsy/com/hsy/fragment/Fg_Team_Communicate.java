package hsy.com.hsy.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import hsy.com.hsy.R;
import hsy.com.hsy.adapter.ClassTrendsAdapter;
import hsy.com.hsy.base.BaseFragment;

public class Fg_Team_Communicate extends BaseFragment {

    List<String> item_name;
    List<String> item_time;
    List<String> item_content;
    List<String> item_icon;
    List<String> commit_content;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.my_listview;
    }

    @Override
    protected void initParams(View view, Bundle savedInstanceState) {
        ListView listView = (ListView) view.findViewById(R.id.listview);
        initData();
        ClassTrendsAdapter listAdapter = new ClassTrendsAdapter(getContext(),6,item_icon,item_name,item_content,item_time,commit_content);
        listView.setAdapter(listAdapter);
    }

    //假数据
    private void initData() {


        item_name = new ArrayList<>();
        item_name.add("赐一");
        item_name.add("天二");
        item_name.add("张三");
        item_name.add("李四");
        item_name.add("王五");
        item_name.add("赵六");
        item_time = new ArrayList<>();
        item_time.add("11:10");
        item_time.add("12:20");
        item_time.add("13:30");
        item_time.add("14:40");
        item_time.add("15:50");
        item_time.add("16:10");

        item_content = new ArrayList<>();
        item_content.add("中国移动咪咕音乐大音联赛开始报名了~中国最大规模的音乐高校竞赛，百万音乐梦想创业基金，首创网络直播对抗赛，" + "为期一周的魔鬼训练营，发行首张高校原创音乐专辑…成就梦想，马上报名吧！");
        item_content.add("教师都进行了很好的反思与总结，凝聚了人心、鼓舞了士气，进一步激发了全体教职员工的紧迫感、责任感和使命感。回望2017，荣耀的华章将永远定格在!!的荣誉史册，展望2018");
        item_content.add("根据雨花区委组织部及教育局党委部署要求，我们党支部于2018年3月26日下午，认真组织全体党员老师和行政扎实开展了“六项内容”集中学习讨论活动，学习习近平在党的十九届一中全会上的讲话、");
        item_content.add("为了进一步严肃学校工作纪律，加强学校教师队伍作风建设，增强教师的责任意识、纪律意识、服务意识，树立教师良好形象，2018年3月19号下午，!!召开了教师作风建设大会，全面安排部署学校新学期作风建设工作。");
        item_content.add("育质量是学校的生命线，为了进一步加强学校对毕业班工作的管理和指导，强化毕业班教学工作，提升教学质量，2018年3月15日下午，!!在综合楼四楼会议室召开了毕业班语数教师会议。");
        item_content.add("召开了以“精诚合作 精细落实 精彩纷呈”为主题的教研组长会议。本次会议旨在交流本学期工作要求及工作安排。");

        item_icon = new ArrayList<>();
        item_icon.add("https://ss0.baidu.com/6ONWsjip0QIZ8tyhnq/it/u=2031677745,545048845&fm=58&bpow=400&bpoh=400");
        item_icon.add("https://ss0.baidu.com/6ONWsjip0QIZ8tyhnq/it/u=2031677745,545048845&fm=58&bpow=400&bpoh=400");
        item_icon.add("https://ss0.baidu.com/6ONWsjip0QIZ8tyhnq/it/u=2031677745,545048845&fm=58&bpow=400&bpoh=400");
        item_icon.add("https://ss0.baidu.com/6ONWsjip0QIZ8tyhnq/it/u=2031677745,545048845&fm=58&bpow=400&bpoh=400");
        item_icon.add("https://ss0.baidu.com/6ONWsjip0QIZ8tyhnq/it/u=2031677745,545048845&fm=58&bpow=400&bpoh=400");
        item_icon.add("https://ss0.baidu.com/6ONWsjip0QIZ8tyhnq/it/u=2031677745,545048845&fm=58&bpow=400&bpoh=400");

        commit_content = new ArrayList<>();
        commit_content.add("音乐大赛真热闹");
        commit_content.add("教师真的认真负责");
        commit_content.add("相信我党会带领我们走向更好的未来");
        commit_content.add("纪律在学校是最重要的");
        commit_content.add("教育质量要从一切抓取");
        commit_content.add("计划是必须的");

    }

}
