package hsy.com.hsy.activity;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.gyf.barlibrary.ImmersionBar;

import java.util.ArrayList;
import java.util.List;

import hsy.com.hsy.R;
import hsy.com.hsy.bean.StudyResultLookBean_My;
import hsy.com.hsy.view.MyListView;

/**
 * 成绩查看
 */
public class ResultLookActivityMy extends AppCompatActivity implements View.OnClickListener {

    List<StudyResultLookBean_My> lists;
    private MyListView lv;
    private RelativeLayout titleLl;
    private ImageView add;
    private MyAdsapter adsapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_look);
        ImmersionBar.with(this).statusBarColor(R.color.stabar_color).fitsSystemWindows(true).init();
        TextView titleName = findViewById(R.id.title_name);
        ImageView back = findViewById(R.id.back);
        add = findViewById(R.id.add);
        titleLl = findViewById(R.id.one);
        add.setVisibility(View.VISIBLE);
        add.setImageResource(R.drawable.selecter_ben);
        back.setVisibility(View.VISIBLE);
        back.setOnClickListener(this);
        add.setOnClickListener(this);
        titleName.setText("成绩查看");
        initData();
        lv = findViewById(R.id.lv);
        adsapter = new MyAdsapter(this);
        adsapter.setAdapterData(lists);
        lv.setAdapter(adsapter);
    }

    private void initData() {
        lists = new ArrayList<>();
        lists.add(new StudyResultLookBean_My("语文", "数学", "英语", "体育", "美术", "音乐", "技术", "通用"));
        lists.add(new StudyResultLookBean_My("110", "100", "116", "40", "60", "60", "90", "80"));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ImmersionBar.with(this).destroy();
    }

    boolean isAdd = false;
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.add:
                View view = LayoutInflater.from(this).inflate(R.layout.choose_subject_type, null, false);

                final TextView item_1 = view.findViewById(R.id.item_1);
                final PopupWindow window = new PopupWindow(view);
                window.setWidth(LinearLayout.LayoutParams.WRAP_CONTENT);
                window.setHeight(LinearLayout.LayoutParams.WRAP_CONTENT);
                window.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#E4F0FB")));
                // 设置PopupWindow是否能响应外部点击事件
                window.setOutsideTouchable(true);
                // 设置PopupWindow是否能响应点击事件
                window.setTouchable(true);
                item_1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(final View v) {
                        window.dismiss();
                        View view = LayoutInflater.from(ResultLookActivityMy.this).inflate(R.layout.my_listview, null, false);
                        ListView listView = view.findViewById(R.id.listview);
                        final List<String> list = new ArrayList<>();
                        list.add("考试类型");
                        list.add("学期");
                        final PopuWidowsAdapter popuWidowsAdapter = new PopuWidowsAdapter(list, ResultLookActivityMy.this);
                        listView.setAdapter(popuWidowsAdapter);

                        final PopupWindow window2 = new PopupWindow(view);
                        window2.setWidth(LinearLayout.LayoutParams.MATCH_PARENT);
                        window2.setHeight(LinearLayout.LayoutParams.WRAP_CONTENT);
                        window2.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#E4F0FB")));
                        // 设置PopupWindow是否能响应外部点击事件
                        window2.setOutsideTouchable(true);
                        // 设置PopupWindow是否能响应点击事件
                        window2.setTouchable(true);

                        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                window.dismiss();
                                TextView tv = view.findViewById(R.id.tv);
                                if (tv.getText().toString().equals("考试类型")) {
                                    List<String> ll = new ArrayList<>();
                                    ll.add("考试类型");
                                    ll.add("学期");
                                    ll.add("入学考试");
                                    ll.add("期中考试");
                                    ll.add("期末考试");
                                    popuWidowsAdapter.setAdapterData(ll);
                                    popuWidowsAdapter.notifyDataSetChanged();
                                } else if (tv.getText().toString().equals("学期")) {
                                    List<String> ls = new ArrayList<>();
                                    ls.add("考试类型");
                                    ls.add("学期");
                                    ls.add("2017年下半学期");
                                    ls.add("2018年上半学期");
                                    popuWidowsAdapter.setAdapterData(ls);
                                    popuWidowsAdapter.notifyDataSetChanged();
                                } else if (tv.getText().toString().equals("入学考试")) {

                                } else if (tv.getText().toString().equals("期中考试")) {

                                } else if (tv.getText().toString().equals("期末考试")) {

                                }
                            }
                        });
                        window2.showAsDropDown(titleLl);
                    }
                });
                window.showAsDropDown(add, 1, -2);
                break;
        }
    }

    class PopuWidowsAdapter extends BaseAdapter {

        List<String> strings;
        Context mContext;

        public PopuWidowsAdapter(List<String> strings, Context mContext) {
            this.strings = strings;
            this.mContext = mContext;
        }

        private void setAdapterData(List<String> strings) {
            this.strings = strings;
        }

        @Override
        public int getCount() {
            return strings.size();
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder;
            if (convertView == null) {
                holder = new ViewHolder();
                convertView = LayoutInflater.from(mContext).inflate(R.layout.choose_subject_item, null, false);
                holder.tv = convertView.findViewById(R.id.tv);
                holder.iv = convertView.findViewById(R.id.iv);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }

            if (position > 2) {
                holder.iv.setVisibility(View.INVISIBLE);
            }
            holder.tv.setText(strings.get(position));
            return convertView;
        }

        class ViewHolder {
            TextView tv;
            ImageView iv;
        }
    }


    class MyAdsapter extends BaseAdapter {

        List<StudyResultLookBean_My> adapterList;
        Context mContext;

        private void setAdapterData(List<StudyResultLookBean_My> adapterList) {
            this.adapterList = adapterList;
        }

        private List<StudyResultLookBean_My> getAdapterData() {
            return adapterList;
        }

        public MyAdsapter(Context mContext) {
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
                convertView = LayoutInflater.from(mContext).inflate(R.layout.item_result_look, null, false);
                holder.chinese = convertView.findViewById(R.id.chinese);
                holder.manth = convertView.findViewById(R.id.math);
                holder.engLish = convertView.findViewById(R.id.english);
                holder.sport = convertView.findViewById(R.id.sport);
                holder.art = convertView.findViewById(R.id.art);
                holder.music = convertView.findViewById(R.id.music);
                holder.technology = convertView.findViewById(R.id.technology);
                holder.currency = convertView.findViewById(R.id.currency);
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
                holder.art.setTextSize(18);
                holder.music.setTextSize(18);
                holder.technology.setTextSize(18);
                holder.currency.setTextSize(18);
            }

            holder.chinese.setText(adapterList.get(position).getChinese());
            holder.manth.setText(adapterList.get(position).getManth());
            holder.engLish.setText(adapterList.get(position).getEngLish());
            holder.sport.setText(adapterList.get(position).getSport());
            holder.art.setText(adapterList.get(position).getArt());
            holder.music.setText(adapterList.get(position).getMusic());
            holder.technology.setText(adapterList.get(position).getTechnology());
            holder.currency.setText(adapterList.get(position).getCurrency());
            return convertView;
        }

        class ViewHolder {
            TextView chinese;
            TextView manth;
            TextView engLish;
            TextView sport;
            TextView art;
            TextView music;
            TextView technology;
            TextView currency;
            LinearLayout ll;
            View vw;
        }
    }
}
