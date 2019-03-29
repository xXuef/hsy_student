package hsy.com.hsy.fragment;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import hsy.com.hsy.R;
import hsy.com.hsy.activity.AddViewAcivity;
import hsy.com.hsy.activity.AdressActivityMy;
import hsy.com.hsy.activity.ChooseSubjectActivityMy;
import hsy.com.hsy.activity.HomeWorkActivityMy;
import hsy.com.hsy.activity.LeaveActivity;
import hsy.com.hsy.activity.LibraryActivityMy;
import hsy.com.hsy.activity.LivePlanActivityMy;
import hsy.com.hsy.activity.ProcessEvaluationiActivityMy;
import hsy.com.hsy.activity.QualityEvaluation;
import hsy.com.hsy.activity.ResultExcelActivityMy;
import hsy.com.hsy.activity.ResultLookActivityMy;
import hsy.com.hsy.activity.TeamActivityMy;
import hsy.com.hsy.activity.TrueSubjectActivity;
import hsy.com.hsy.activity.TurnOfWorkActivityMy;
import hsy.com.hsy.base.BaseFragment;
import hsy.com.hsy.bean.AddBean;
import hsy.com.hsy.sql.MyDbHelper;


/**
 * Description:自己做出来的功能界面
 * Data: 2018/6/8 16:56
 *
 * @author: Summer
 */
public class Fg_Myfun extends BaseFragment {

    GridView gv;
    public ArrayList<String> strings;
    public ArrayList<Integer> icons;
    public ArrayList<Boolean> state;
    public static ArrayList<String> dbStrings;
    public ArrayList<Integer> dbIcons;
    public ArrayList<Boolean> dbState;
    public ArrayList<AddBean> addBeans;
    private myadapter adapter;

    public static ArrayList<AddBean> appInfo;

    @Override
    protected int getLayoutId() {
        return R.layout.fg_myfun;
    }

    @Override
    protected void initParams(View view, Bundle savedInstanceState) {
        gv = (GridView) view.findViewById(R.id.gv);
        TextView titile = (TextView) view.findViewById(R.id.title_name);
        titile.setText("功能");

        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //得到条目的name 然后对比下面的点击事件 打开对用的activity
                TextView tv = view.findViewById(R.id.tv);
                String text = (String) tv.getText();
                click(text, getContext());
            }
        });

    }

    @Override
    public void onResume() {
        super.onResume();
        strings = new ArrayList<>();
        icons = new ArrayList<>();
        //查看数据库的数据
        LookDataBase();
        dbStrings = new ArrayList<>();
        dbIcons = new ArrayList<>();
        dbState = new ArrayList<>();
        for (int i = 0; i < addBeans.size(); i++) {
            Integer icon = addBeans.get(i).getIcon();
            String name = addBeans.get(i).getName();

            dbIcons.add(icon);
            dbStrings.add(name);
        }
        adapter = new myadapter(dbStrings, dbIcons);

        //这句不能丢  丢了添加功能就没入口了
        //在griview设置数据之前在adapter中添加一个添加图标
        adapter.addData("添加", R.drawable.add);
        gv.setAdapter(adapter);
    }

    /**
     * 查询数据数据
     */
    private void LookDataBase() {

        MyDbHelper helper = new MyDbHelper(getContext());
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cursor = db.query(MyDbHelper.TABLE_NAME, null, null,
                null, null, null, null);
        addBeans = new ArrayList<>();
        while (cursor.moveToNext()) {
            String icon = cursor.getString(cursor.getColumnIndex("icon"));
            String name = cursor.getString(cursor.getColumnIndex("name"));
            int state = cursor.getInt(cursor.getColumnIndex("state"));
            Boolean is;
            //在这里查询的时候只显示state是true的值
            if (state == 1) {
                is = true;
                if (!icon.equals("")) {
                    AddBean beanAdd = new AddBean(Integer.valueOf(icon), name, is);
                    addBeans.add(beanAdd);
                } else {
                    AddBean beanAdd = new AddBean(R.drawable.test, name, is);
                    addBeans.add(beanAdd);
                }
            }
//            dbStrings.add(name);
//            dbIcons.add(1);

        }
    }

    private void initdate() {
        strings = new ArrayList<>();
        strings.add("选课");
        strings.add("作业");
        strings.add("添加");
        strings.add("图书馆");
        strings.add("过程评价");
        strings.add("请假");
        strings.add("通讯录");
        strings.add("考勤");
        icons = new ArrayList<>();
        icons.add(R.drawable.chooesobject);
        icons.add(R.drawable.homework);
        icons.add(R.drawable.add);
        icons.add(R.drawable.library);
        icons.add(R.drawable.processevaluation);
        icons.add(R.drawable.leave);
        icons.add(R.drawable.adress);
        icons.add(R.drawable.turnofrun);
    }


    /**
     * Description:适配器、、、
     * Data: 2018/6/9 9:15
     */
    public class myadapter extends BaseAdapter {

        public myadapter(List<String> strings, List<Integer> icons) {
            this.strings = strings;
            this.icons = icons;
        }

        List<String> strings;
        List<Integer> icons;

        private void addData(String s, Integer i) {
            strings.add(s);
            icons.add(i);
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

            ViewHolder holder = null;

            if (holder == null) {

                holder = new ViewHolder();
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_mufun, null, false);
                holder.icon = convertView.findViewById(R.id.image_view);
                holder.tv = convertView.findViewById(R.id.tv);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }

            holder.icon.setImageResource((icons.get(position) == 1 || icons.get(position) == null) ? R.drawable.homework : icons.get(position));
            holder.tv.setText(strings.get(position));

            return convertView;
        }

        class ViewHolder {
            TextView tv;
            ImageView icon;
        }
    }


    protected void click(String appId, Context context) {

        if ("选课".equals(appId)) {
//            Toast.makeText(getContext(), "选科", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(context, ChooseSubjectActivityMy.class));
        } else if ("成绩查看".equals(appId)) {
//            Toast.makeText(getContext(), "成绩查看", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(context, ResultLookActivityMy.class));
        } else if ("生涯规划".equals(appId)) {
//            Toast.makeText(getContext(), "生涯规划", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(context, LivePlanActivityMy.class));
        } else if ("通讯录".equals(appId)) {
//            Toast.makeText(getContext(), "联系人", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(context, AdressActivityMy.class));
        } else if ("过程评价".equals(appId)) {
//            Toast.makeText(getContext(), "过程评价", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(context, ProcessEvaluationiActivityMy.class));
        } else if ("社团".equals(appId)) {
//            Toast.makeText(getContext(), "社团", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(context, TeamActivityMy.class));
        } else if ("考勤".equals(appId)) {
//            Toast.makeText(getContext(), "出勤", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(context, TurnOfWorkActivityMy.class));
        } else if ("作业".equals(appId)) {
//            Toast.makeText(getContext(), "作业", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(context, HomeWorkActivityMy.class));
        } else if ("请假".equals(appId)) {
//            Toast.makeText(getContext(), "请假", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(context, LeaveActivity.class));
        } else if ("成绩分析".equals(appId)) {
//            Toast.makeText(getContext(), "成绩分析", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(context, ResultExcelActivityMy.class));
        } else if ("图书馆".equals(appId)) {
//            Toast.makeText(getContext(), "图书馆", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(context, LibraryActivityMy.class));
        } else if ("添加".equals(appId)) {
//            Toast.makeText(getContext(), "添加", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(context, AddViewAcivity.class));
        } else if ("真题".equals(appId)) {
            startActivity(new Intent(context, TrueSubjectActivity.class));
        } else if ("素质评价申报".equals(appId)) {
            startActivity(new Intent(context, QualityEvaluation.class));
        }
    }
}
