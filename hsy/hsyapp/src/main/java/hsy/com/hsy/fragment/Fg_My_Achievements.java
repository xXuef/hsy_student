package hsy.com.hsy.fragment;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import hsy.com.hsy.R;
import hsy.com.hsy.base.BaseFragment;
import hsy.com.hsy.bean.KonwledgeSummaryBean;
import hsy.com.hsy.bean.FourParamenterBean;
import hsy.com.hsy.view.MyListView;

public class Fg_My_Achievements extends BaseFragment {

    private MyListView lv;
    private MyListView sumList;
    List<FourParamenterBean> lists;
    List<KonwledgeSummaryBean> konew;

    @Override
    protected int getLayoutId() {
        return R.layout.custom_listview;
    }

    @Override
    protected void initParams(View view, Bundle savedInstanceState) {
        lv = view.findViewById(R.id.lv);
        sumList = view.findViewById(R.id.zongjie);


        initData();
        lv.setAdapter(new MyAdsapter(lists, getContext()));
        sumList.setAdapter(new twoAdapter(konew, getContext()));
    }

    private void initData() {
        lists = new ArrayList<>();
        lists.add(new FourParamenterBean("科目", "成绩分", "班级排名", "全校排名"));
        lists.add(new FourParamenterBean("语文", "88", "68", "80"));
        lists.add(new FourParamenterBean("数学", "99", "15", "35"));
        lists.add(new FourParamenterBean("英语", "76", "50", "110"));

        konew = new ArrayList<>();
        konew.add(new KonwledgeSummaryBean("知识点", "分值", "占比(%)", "平均得分", "平均得分率(%)"));
        konew.add(new KonwledgeSummaryBean("外汇", "2", "2.0", "1.1", "53"));
        konew.add(new KonwledgeSummaryBean("消费类型", "1", "1.5", "0.8", "82"));
        konew.add(new KonwledgeSummaryBean("影响价格的因素", "2", "2.0", "1.5", "73"));
    }


    class MyAdsapter extends BaseAdapter {

        List<FourParamenterBean> adapterList;
        Context mContext;

        public MyAdsapter(List<FourParamenterBean> adapterList, Context mContext) {
            this.adapterList = adapterList;
            this.mContext = mContext;
        }

        @Override
        public int getCount() {
            return adapterList.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder = null;
            if (convertView == null) {
                holder = new ViewHolder();
                convertView = LayoutInflater.from(mContext).inflate(R.layout.item_my_result, null, false);
                holder.chinese = convertView.findViewById(R.id.chinese);
                holder.manth = convertView.findViewById(R.id.math);
                holder.engLish = convertView.findViewById(R.id.english);
                holder.sport = convertView.findViewById(R.id.sport);
                holder.ll = convertView.findViewById(R.id.ll);
                holder.vw = convertView.findViewById(R.id.vw);

                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            if (position == 0) {
                holder.ll.setBackgroundColor(Color.parseColor("#E4F0FB"));
                holder.vw.setVisibility(View.VISIBLE);
                holder.chinese.setTextSize(18);
                holder.manth.setTextSize(18);
                holder.engLish.setTextSize(18);
                holder.sport.setTextSize(18);
            }

            holder.chinese.setText(adapterList.get(position).getSum());
            holder.manth.setText(adapterList.get(position).getEqually());
            holder.engLish.setText(adapterList.get(position).getClassRanking());
            holder.sport.setText(adapterList.get(position).getSchoolRanking());

            return convertView;
        }

        class ViewHolder {
            TextView chinese;
            TextView manth;
            TextView engLish;
            TextView sport;
            LinearLayout ll;
            View vw;
        }
    }

    class twoAdapter extends BaseAdapter {

        List<KonwledgeSummaryBean> arrayList;
        Context mContext;

        public twoAdapter(List<KonwledgeSummaryBean> arrayList, Context mContext) {
            this.arrayList = arrayList;
            this.mContext = mContext;
        }

        @Override
        public int getCount() {
            return arrayList.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder;
            if (convertView == null) {
                holder = new ViewHolder();
                convertView = LayoutInflater.from(mContext).inflate(R.layout.item_konewledge, null, false);
                holder.ll = convertView.findViewById(R.id.ll);
                holder.vw = convertView.findViewById(R.id.vw);
                holder.konwledge = convertView.findViewById(R.id.konew);
                holder.mark = convertView.findViewById(R.id.mark);
                holder.proportion = convertView.findViewById(R.id.proportion);
                holder.average = convertView.findViewById(R.id.average);
                holder.average_score_rate = convertView.findViewById(R.id.average_score_rate);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            if (position == 0) {
                holder.ll.setBackgroundColor(Color.parseColor("#E4F0FB"));
                holder.vw.setVisibility(View.VISIBLE);
                holder.konwledge.setTextSize(16);
                holder.mark.setTextSize(16);
                holder.proportion.setTextSize(16);
                holder.average.setTextSize(16);
                holder.average_score_rate.setTextSize(16);
            }

            holder.konwledge.setText(konew.get(position).getKonwledge());
            holder.mark.setText(konew.get(position).getMark());
            holder.proportion.setText(konew.get(position).getProportion());
            holder.average.setText(konew.get(position).getAverage());
            holder.average_score_rate.setText(konew.get(position).getAverage_score_rate());
            return convertView;
        }

        class ViewHolder {
            LinearLayout ll;
            View vw;
            TextView konwledge;
            TextView mark;
            TextView proportion;
            TextView average;
            TextView average_score_rate;
        }
    }
}
