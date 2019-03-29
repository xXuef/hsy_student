package hsy.com.hsy.activity;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import hsy.com.hsy.R;
import hsy.com.hsy.bean.AddBean;
import hsy.com.hsy.Constants;
import hsy.com.hsy.sql.MyDbHelper;
import hsy.com.hsy.util.SharePreUtil;


/**
 * Description:自己做出来的功能筛选界面
 * Data: 2018/6/8 16:57
 * @author: Summer
 */
public class AddViewAcivity extends AppCompatActivity {

    private ListView lv;
    public static ArrayList<String> strings;
    public ArrayList<Integer> icons;
    public ArrayList<Boolean> state;
    private SQLiteDatabase db;
    private MyDbHelper helper;
    private Button btn_ok;
    private ArrayList<AddBean> appInfo;
    private ArrayList<AddBean> dbAppInfo;

    private myAd adapter;
    private SharePreUtil sharePreUtil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_view_acivity);
        btn_ok = (Button) findViewById(R.id.home_add_app_btn);
        ImageView back = (ImageView) findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        helper = new MyDbHelper(this);
        db = helper.getReadableDatabase();

        lv = (ListView) findViewById(R.id.lv);
//      点击完成
        initBtnOk();

        //记录是否已经添加过数据了
        SharedPreferences sp = getSharedPreferences(Constants.ISADD, MODE_PRIVATE);
        sharePreUtil = new SharePreUtil(this, sp);

        initDate();//虚拟数据
        boolean value = sharePreUtil.getValue(Constants.ADDKRY, false);
        if (!value == true) {
            addDateBase();//向数据库添加数据
            Log.e("app",appInfo.size()+"大小");
            adapter = new myAd(appInfo, this);
        } else {
            LookDate();
            Log.e("Dbapp",dbAppInfo.size()+"大小");
            adapter = new myAd(dbAppInfo, this);
        }

        lv.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }

    /**
     * 如果sp已经写入过了就
     * 查询数据库
     */
    private void LookDate() {
        dbAppInfo = new ArrayList<>();
        MyDbHelper helper = new MyDbHelper(this);
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cursor = db.query(MyDbHelper.TABLE_NAME, null, null,
                null, null, null, null);
        while (cursor.moveToNext()) {
            AddBean beanAdd;
            String icon = cursor.getString(cursor.getColumnIndex("icon"));
            String name = cursor.getString(cursor.getColumnIndex("name"));
            int state = cursor.getInt(cursor.getColumnIndex("state"));
            Boolean is;
            if (state == 1) {
                is = true;
                beanAdd = new AddBean(Integer.valueOf(icon), name, is);
                dbAppInfo.add(beanAdd);
            } else if (state == 0) {
                is = false;
                beanAdd = new AddBean(Integer.valueOf(icon), name, is);
                dbAppInfo.add(beanAdd);
            }
        }
    }

    /**
     * 完成确定按钮逻辑
     * 更新点击过的数据
     */
    private void initBtnOk() {
        btn_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //点击确定之后 直接问adapter要数据
                ArrayList<ContentValues> contentValues = adapter.getcontentValues();
                Log.e("size", contentValues.size() + "集合");

                if (contentValues != null) {
                    for (int i = 0; i < contentValues.size(); i++) {
                        String whereClause = "name=?";
                        String[] whereArgs = {String.valueOf(contentValues.get(i).get("name"))};
                        db.update(MyDbHelper.TABLE_NAME, contentValues.get(i), whereClause, whereArgs);
                    }
                }
                finish();
            }
        });
    }

    /**
     * 向数据库添加功能的全部数据
     */
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

    class myAd extends BaseAdapter {

        ArrayList<AddBean> appInfo;
        Context context;
        private ArrayList<ContentValues> contentValues = new ArrayList<>();

        public myAd(ArrayList<AddBean> appInfo, Context context) {
            this.appInfo = appInfo;
            this.context = context;
        }


        @Override
        public int getCount() {
            return appInfo.size();
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        private ArrayList<ContentValues> getcontentValues() {

            return contentValues;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            final ViewHolder holder;
            if (convertView == null) {
                holder = new ViewHolder();
                convertView = LayoutInflater.from(context).inflate(R.layout.item_addlist, null, false);
                holder.icon = convertView.findViewById(R.id.iv_icon);
                holder.selecter = convertView.findViewById(R.id.home_add_app_item_checkbox);
                holder.textView = convertView.findViewById(R.id.tv_name);
                holder.ll = convertView.findViewById(R.id.item_ll);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            holder.textView.setText(appInfo.get(position).getName());
            holder.icon.setImageResource(appInfo.get(position).getIcon() == 1 ? R.drawable.aboutus : appInfo.get(position).getIcon());
            holder.selecter.setChecked(appInfo.get(position).getState());


            //在这里点击之后就会将点击过的值加入集合中
            holder.ll.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (appInfo.get(position).isState()) {
                        appInfo.get(position).setState(false);
                        holder.selecter.setChecked(false);
//                        appInfo.remove(appInfo.get(position));

                        String name = appInfo.get(position).getName();
                        Integer icon = appInfo.get(position).getIcon();
                        Boolean state = appInfo.get(position).getState();
                        ContentValues valu = new ContentValues();
                        valu.put("name", name);
                        valu.put("icon", icon);
                        valu.put("state", state);
                        contentValues.add(valu);
                        Log.e("size", contentValues.size() + "大小");

                    } else {
                        appInfo.get(position).setState(true);
                        holder.selecter.setChecked(true);
//                        appInfo.add(appInfo.get(position));

                        String name = appInfo.get(position).getName();
                        Integer icon = appInfo.get(position).getIcon();
                        Boolean state = appInfo.get(position).getState();
                        ContentValues valu = new ContentValues();
                        valu.put("name", name);
                        valu.put("icon", icon);
                        valu.put("state", state);
                        contentValues.add(valu);
                        Log.e("size", contentValues.size() + "大小");
                    }
                }
            });
            return convertView;
        }

        class ViewHolder {
            LinearLayout ll;
            TextView textView;
            ImageView icon;
            CheckBox selecter;
        }
    }


    private void initDate() {

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



}


