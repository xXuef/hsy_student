package hsy.com.hsy.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.bigkoo.pickerview.builder.TimePickerBuilder;
import com.bigkoo.pickerview.listener.OnTimeSelectListener;
import com.bigkoo.pickerview.view.TimePickerView;
import com.gyf.barlibrary.ImmersionBar;

import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import hsy.com.hsy.Constants;
import hsy.com.hsy.R;
import hsy.com.hsy.util.SharePreUtil;
import hsy.com.hsy.util.ToastUtils;

/**
 * 请假 页面
 */
public class LeaveActivity extends AppCompatActivity {


    @BindView(R.id.add)
    ImageView add;
    @BindView(R.id.leave_type)
    RelativeLayout leaveType;
    @BindView(R.id.start_time)
    RelativeLayout startTime;
    @BindView(R.id.end_time)
    RelativeLayout endTime;
    @BindView(R.id.howlong)
    TextView howlong;
    @BindView(R.id.leave_beacause_text)
    EditText leaveBeacauseText;
    @BindView(R.id.commit)
    Button commit;
    @BindView(R.id.tv_start_time)
    TextView tvStartTime;
    @BindView(R.id.tv_end_time)
    TextView tvEndTime;

    TextView tv;
    private TimePickerView pvTime;

    private SharedPreferences sp;
    private SharePreUtil sharePreUtil;
    private Spinner spinner;
    private ArrayAdapter<String> adapter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leave);
        ButterKnife.bind(this);
        ImmersionBar.with(this).statusBarColor(R.color.stabar_color).fitsSystemWindows(true).init();
        spinner = findViewById(R.id.spinner);
        tv = findViewById(R.id.tv);

        //初始化title
        initTitle();
        //创建这玩意是为了记录选择的日期方便计算
        sp = getSharedPreferences(Constants.LEAVEDATA, Context.MODE_PRIVATE);
        sharePreUtil = new SharePreUtil(this, sp);

        //初始化复选框的的内容
        doSpnniner();


    }

    /**
     * 下拉框处理
     */
    private void doSpnniner() {

        String[] mItems = getResources().getStringArray(R.array.plantes);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, mItems);
        //设置下拉列表的风格
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //将adapter添加到spinner中
        spinner.setAdapter(adapter);
        //添加事件Spinner事件监听
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String[] strings = getResources().getStringArray(R.array.plantes);
                //进来之后默认选中第一条
                ToastUtils.showShort(strings[position]);
                tv.setText(strings[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }


    /**
     * 初始化状态栏
     */
    private void initTitle() {
        TextView name = (TextView) findViewById(R.id.title_name);
        ImageView back = (ImageView) findViewById(R.id.back);
        name.setText("请假");
        back.setVisibility(View.VISIBLE);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        add.setVisibility(View.VISIBLE);
        add.setImageResource(R.drawable.leaveselecter);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LeaveActivity.this, LeaveHistoryActivityMy.class));
            }
        });
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        ImmersionBar.with(this).destroy();
    }


    @OnClick({R.id.start_time, R.id.end_time, R.id.commit})
    public void onViewClicked(View view) {
        switch (view.getId()) {

            case R.id.start_time:
                //时间选择器
                pvTime = new TimePickerBuilder(LeaveActivity.this, new OnTimeSelectListener() {
                    @Override
                    public void onTimeSelect(Date date, View v) {
                        tvStartTime.setText(dateToStrLong(date));
                        sharePreUtil.setValue(Constants.LEAVESTART, date.getTime() + "");
                    }
                }).build();

                pvTime.show();

                break;
            case R.id.end_time:
                if (tvStartTime.getText().equals("")) {
                    ToastUtils.showShort("请先选择开始时间");
                    return;
                }
                //     .setLabel("年", "月", "日", "", "", "")//默认设置为年月日时分秒
                pvTime = new TimePickerBuilder(LeaveActivity.this, new OnTimeSelectListener() {
                    @Override
                    public void onTimeSelect(Date date, View v) {
                        tvEndTime.setText(dateToStrLong(date));
                        sharePreUtil.setValue(Constants.LEAVEEND, date.getTime() + "");

                        String end = sharePreUtil.getValue(Constants.LEAVEEND, "");
                        String start = sharePreUtil.getValue(Constants.LEAVESTART, "");
                        Log.e("leaveTime", "开始时间long值"+ start+"结束时间long值"+ end);

                        long aLong = (long) Long.valueOf(end);
                        long bLong = (long) Long.valueOf(start);
                        long l = aLong - bLong;
                        long nd = 1000 * 24 * 60 * 60;

                        howlong.setText(l / nd + "");

                    }

                }).build();
                pvTime.show();


                break;
            case R.id.commit:
                break;
        }
    }


    public static String getDatePoor(Date endDate, Date nowDate) {

        long nd = 1000 * 24 * 60 * 60;
        long nh = 1000 * 60 * 60;
        long nm = 1000 * 60;
        // long ns = 1000;
        // 获得两个时间的毫秒时间差异
        long diff = endDate.getTime() - nowDate.getTime();
        // 计算差多少天
        long day = diff / nd;
        // 计算差多少小时
        long hour = diff % nd / nh;
        // 计算差多少分钟
        long min = diff % nd % nh / nm;
        // 计算差多少秒//输出结果
        // long sec = diff % nd % nh % nm / ns;
//        return day + "天" + hour + "小时" + min + "分钟";
        return day + "";
    }

    //data转年月日
    public static String dateToStrLong(java.util.Date dateDate) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = formatter.format(dateDate);
        return dateString;
    }

    /**
     * 两个时间之间的天数
     */
    public static long getDays(String date1, String date2) {
        long day = 0;
        if (date1 == null || date1.equals(""))
            return 0;
        if (date2 == null || date2.equals(""))
            return 0;
        // 转换为标准时间
        SimpleDateFormat myFormatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        Date mydate = null;
        try {
            date = myFormatter.parse(date1);
            mydate = myFormatter.parse(date2);
            day = (date.getTime() - mydate.getTime()) / (24 * 60 * 60 * 1000);
        } catch (Exception e) {
        }

        return day;
    }
}
