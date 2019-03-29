package hsy.com.hsy.fragment;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.scwang.smartrefresh.header.BezierCircleHeader;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.footer.ClassicsFooter;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;

import hsy.com.hsy.Constants;
import hsy.com.hsy.R;
import hsy.com.hsy.activity.HowActivity;
import hsy.com.hsy.adapter.HomeListAdapter;
import hsy.com.hsy.base.BaseFragment;
import hsy.com.hsy.bean.AddBean;
import hsy.com.hsy.sql.MyDbHelper;
import hsy.com.hsy.util.SharePreUtil;

/**
 * 作者：Administrator on 2018/4/14 11:01
 */

public class Fg_school_inside extends BaseFragment {

    List<String> item_name;
    List<String> item_time;
    List<String> item_content;
    List<String> item_icon;
    private SharePreUtil sharePreUtil;
    private HomeListAdapter homeListAdapter;
    private ArrayList<AddBean> appInfo;

    private SQLiteDatabase db;
    private MyDbHelper helper;

    @Override
    protected int getLayoutId() {
        return R.layout.my_refresh_listview;
    }

    @Override
    protected void initParams(View view, Bundle savedInstanceState) {
        ListView listview = (ListView) view.findViewById(R.id.listview);
        final SmartRefreshLayout refresh = view.findViewById(R.id.refresh);

        /**
         * 直接在这里写入功能页面的数据
         * 向数据库添加功能的全部数据
         */
        comeDbData();

        //准备假数据
        initData();

        if (item_icon.size() != item_name.size() && item_icon.size() < item_name.size()) {

            for (int i = 0; i < item_name.size() - item_icon.size(); i++) {
                item_icon.add("null");
            }
        }
        homeListAdapter = new HomeListAdapter(item_name, item_time, item_content, false, null, false, item_icon, null, getContext());
        listview.setAdapter(homeListAdapter);

        refresh.setRefreshHeader(new BezierCircleHeader(getContext()));
        refresh.setRefreshFooter(new ClassicsFooter(getContext()));
        refresh.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshLayout) {

                refresh.finishRefresh(2000, true);//传入false表示刷新失败
                homeListAdapter.notifyDataSetChanged();
            }
        });

        int size = 0;
        refresh.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(RefreshLayout refreshLayout) {
                for (int i = 0; i < 5; i++) {
                    item_name.add("添加数据" + i + "标题");
                    item_time.add("添加数据" + i + "内容------------------------------");
                    item_content.add("添加数据" + i + "11:49");
                    item_icon.add("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=3200334446,1487314372&fm=27&gp=0.jpg" +
                            "##" + "https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=1315075744,1691272927&fm=27&gp=0.jpg");
                }
                homeListAdapter.notifyDataSetChanged();
                refresh.finishLoadMore(2000);//传入false表示加载失败
            }
        });

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(getContext(), HowActivity.class));
            }
        });
    }

    /**
     * 数据库写入操作
     */
    private void comeDbData() {
        helper = new MyDbHelper(getContext());
        db = helper.getReadableDatabase();
        //记录是否已经添加过数据了
        SharedPreferences sp = getContext().getSharedPreferences(Constants.ISADD, Context.MODE_PRIVATE);
        sharePreUtil = new SharePreUtil(getContext(), sp);

        initDbDate();//虚拟数据
        boolean value = sharePreUtil.getValue(Constants.ADDKRY, false);
        if (!value == true) {
            addDateBase();//向数据库添加数据
        }
    }

    private void addDateBase() {
        ContentValues values;
        for (int i = 0; i < appInfo.size(); i++) {
            values = new ContentValues();
            values.put("icon", appInfo.get(i).getIcon());
            values.put("name", appInfo.get(i).getName());
            values.put("state", appInfo.get(i).getState());
            db.insert(MyDbHelper.TABLE_NAME, null, values);
        }
        sharePreUtil.setValue(Constants.ADDKRY, true);
    }

    private void initDbDate() {

        appInfo = new ArrayList<>();
        appInfo.add(new AddBean(R.drawable.chooesobject, "选课", false));
        appInfo.add(new AddBean(R.drawable.homework, "作业", true));
        appInfo.add(new AddBean(R.drawable.reslutlook, "成绩查看", true));
        appInfo.add(new AddBean(R.drawable.library, "图书馆", false));
        appInfo.add(new AddBean(R.drawable.processevaluation, "过程评价", false));
        appInfo.add(new AddBean(R.drawable.leave, "请假", true));
        appInfo.add(new AddBean(R.drawable.adress, "通讯录", false));
        appInfo.add(new AddBean(R.drawable.turnofrun, "考勤", false));
        appInfo.add(new AddBean(R.drawable.liveplan, "生涯规划", true));
        appInfo.add(new AddBean(R.drawable.resultexcel, "成绩分析", false));
        appInfo.add(new AddBean(R.drawable.team, "社团", false));
        appInfo.add(new AddBean(R.drawable.team, "真题", false));
        appInfo.add(new AddBean(R.drawable.team, "素质评价申报", false));

    }


    //假数据
    private void initData() {
        item_name = new ArrayList<>();
        item_name.add("音为青春”中国大学音乐超级联赛");
        item_name.add("自主教育 互赏互享");
        item_name.add("集中学习“六项内容” 切实提升政治素养");
        item_name.add("加强作风建设 构建清风校园");
        item_name.add("爱心陪伴 专业引领 再攀新高");
        item_name.add("精诚合作 精细落实 精彩纷呈 ");
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
        item_icon.add("https://ss0.baidu.com/6ONWsjip0QIZ8tyhnq/it/u=2031677745,545048845&fm=58&bpow=400&bpoh=400"
                + "##" + "https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=3200334446,1487314372&fm=27&gp=0.jpg" +
                "##" + "https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=1315075744,1691272927&fm=27&gp=0.jpg"
                + "##" + "https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=3200334446,1487314372&fm=27&gp=0.jpg"
                + "##" + "https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=3200334446,1487314372&fm=27&gp=0.jpg");
        item_icon.add("https://ss0.baidu.com/6ONWsjip0QIZ8tyhnq/it/u=2031677745,545048845&fm=58&bpow=400&bpoh=400"
                + "##" + "https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=3200334446,1487314372&fm=27&gp=0.jpg" +
                "##" + "https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=3200334446,1487314372&fm=27&gp=0.jpg");
        item_icon.add("https://ss0.baidu.com/6ONWsjip0QIZ8tyhnq/it/u=2031677745,545048845&fm=58&bpow=400&bpoh=400"
                + "##" + "https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=3200334446,1487314372&fm=27&gp=0.jpg"
                + "##" + "https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=3200334446,1487314372&fm=27&gp=0.jpg"
                + "##" + "https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=3200334446,1487314372&fm=27&gp=0.jpg");
        item_icon.add("https://ss0.baidu.com/6ONWsjip0QIZ8tyhnq/it/u=2031677745,545048845&fm=58&bpow=400&bpoh=400");
        item_icon.add("https://ss0.baidu.com/6ONWsjip0QIZ8tyhnq/it/u=2031677745,545048845&fm=58&bpow=400&bpoh=400");
        item_icon.add("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=3200334446,1487314372&fm=27&gp=0.jpg##"
                + "https://ss0.baidu.com/6ONWsjip0QIZ8tyhnq/it/u=2031677745,545048845&fm=58&bpow=400&bpoh=400");
    }


}
