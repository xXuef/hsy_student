package hsy.com.hsy.activity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import hsy.com.hsy.R;
import hsy.com.hsy.adapter.BookOrderAdapter;
import hsy.com.hsy.base.MyBaseActivity;
import hsy.com.hsy.view.OrderDialog;

/**
 * 图书馆馆···预约
 */
public class BookOrderActivityMy extends MyBaseActivity {


    List<String> iconUrls;
    List<String> bookNames;
    List<String> lendOutSituations;
    List<String> versons;
    List<String> bookHots;
    List<String> bookRecommends;
    private GridView gv;

    @Override
    public void initVariable() {
        setContentView(R.layout.activity_book_order);
        EditText et_hint = (EditText) findViewById(R.id.et_school);
        gv = (GridView)findViewById(R.id.gv);
        et_hint.setHint("搜索");
        initData();

    }


    @Override
    public void toLoad(Bundle savedInstanceState) {

        final BookOrderAdapter adapter = new BookOrderAdapter(BookOrderActivityMy.this, iconUrls, bookNames, lendOutSituations, versons);

        adapter.setOnItemClickListener(new BookOrderAdapter.OnItemClickListener() {
            @Override
            public void onClick(int position) {
//                Toast.makeText(BookOrderActivityMy.this, "可预约" + position + "行", Toast.LENGTH_SHORT).show();
                OrderDialog.Builder builder = new OrderDialog.Builder(BookOrderActivityMy.this);

                builder.setTime("取书时间:" + getTedayTime());
                OrderDialog orderDialog = builder.create();
                orderDialog.show();
            }
        });

        gv.setAdapter(adapter);
    }

    private void initData() {
        tool_title.setText("预约");

        iconUrls = new ArrayList<>();
        iconUrls.add("123");
        iconUrls.add("123");
        iconUrls.add("123");
        iconUrls.add("123");
        bookNames = new ArrayList<>();
        bookNames.add("中国百年实录");
        bookNames.add("当代北京故宫史话");
        bookNames.add("安娜卡列尼娜");
        bookNames.add("海燕");
        lendOutSituations = new ArrayList<>();
        lendOutSituations.add("预约");
        lendOutSituations.add("预约");
        lendOutSituations.add("预约");
        lendOutSituations.add("已借出");
        versons = new ArrayList<>();
        versons.add("徐宪江");
        versons.add("郭京宁");
        versons.add("列夫·托尔斯泰");
        versons.add("高尔基");
        bookHots = new ArrayList<>();
        bookHots.add("借阅热度: 50");
        bookHots.add("借阅热度: 24");
        bookHots.add("借阅热度: 43");
        bookHots.add("借阅热度: 86");
        bookRecommends = new ArrayList<>();
        bookRecommends.add("本书收录了近300余幅珍贵历史照片、50多万考证有据的文字，广泛、生动、真实地展现了中国自1911年至2000年百年的变迁与风雨：浓缩、再现了百年里中国人民为民族和国家的富强与独立，前赴后继，英勇奋斗、不屈不挠，最终实现民族复兴的伟大历程。");
        bookRecommends.add("本书收录了近300余幅珍贵历史照片、50多万考证有据的文字，广泛、生动、真实地展现了中国自1911年至2000年百年的变迁与风雨：浓缩、再现了百年里中国人民为民族和国家的富强与独立，前赴后继，英勇奋斗、不屈不挠，最终实现民族复兴的伟大历程。");
        bookRecommends.add("本书收录了近300余幅珍贵历史照片、50多万考证有据的文字，广泛、生动、真实地展现了中国自1911年至2000年百年的变迁与风雨：浓缩、再现了百年里中国人民为民族和国家的富强与独立，前赴后继，英勇奋斗、不屈不挠，最终实现民族复兴的伟大历程。");
        bookRecommends.add("本书收录了近300余幅珍贵历史照片、50多万考证有据的文字，广泛、生动、真实地展现了中国自1911年至2000年百年的变迁与风雨：浓缩、再现了百年里中国人民为民族和国家的富强与独立，前赴后继，英勇奋斗、不屈不挠，最终实现民族复兴的伟大历程。");

    }

    public String getTedayTime() {
        //获取时间
//        Date date = new Date();
//        String year = String.format("%tY", date);
//        String month = String.format("%tB", date);
//        String day = String.format("%te", date);
//        System.out.println("今天是："+year+"-"+month+"-"+day);
        Calendar c = Calendar.getInstance();//可以对每个时间域单独修改
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);//0代表1月，最大为11月
        int date = c.get(Calendar.DATE);

        return year + "." + (month + 1) + "." + (date + 1) + "";
    }
}
