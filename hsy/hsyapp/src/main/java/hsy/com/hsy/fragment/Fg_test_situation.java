package hsy.com.hsy.fragment;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import hsy.com.hsy.R;
import hsy.com.hsy.base.BaseFragment;
import hsy.com.hsy.bean.FourParamenterBean;
import hsy.com.hsy.util.DpToPx;

public class Fg_test_situation extends BaseFragment {


    private ListView listview;
    List<FourParamenterBean> lists;

    @Override
    protected int getLayoutId() {
        return R.layout.my_listview;
    }

    @Override
    protected void initParams(View view, Bundle savedInstanceState) {

        listview = view.findViewById(R.id.listview);

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(listview.getLayoutParams());
        layoutParams.setMargins(DpToPx.px2dip(50), 10, DpToPx.px2dip(50), 0);
        listview.setLayoutParams(layoutParams);
        listview.setDivider(new ColorDrawable(getResources().getColor(R.color.black)));
        listview.setPadding(5,5,5,0);
        listview.setDividerHeight(1);

        init();
        listview.setAdapter(new MyAdsapter(lists, getContext()));
    }

    private void init() {
        lists = new ArrayList<>();
        lists.add(new FourParamenterBean("总分", "均分", "班级排名", "全校排名"));
        lists.add(new FourParamenterBean("500", "88", "68", "80"));
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

}
