package hsy.com.hsy.activity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import hsy.com.hsy.R;
import hsy.com.hsy.adapter.TableAdapter;
import hsy.com.hsy.base.MyBaseActivity;
import hsy.com.hsy.bean.ThreeParameterBean;

/**
 * 作业页面
 */
public class HomeWorkActivityMy extends MyBaseActivity {


    private ListView listview;
    List<ThreeParameterBean> myList;

    @Override
    public void initVariable() {
        setContentView(R.layout.activity_home_work);
        tool_title.setText("作业");
    }

    @Override
    public void toLoad(Bundle savedInstanceState) {

        initData();
        listview = findViewById(R.id.lsitview);
        listview.setAdapter(new TableAdapter(myList,this));

    }

    private void initData() {
        myList = new ArrayList<>();
        myList.add(new ThreeParameterBean("科目", "作业内容", "截止日期"));
        myList.add(new ThreeParameterBean("语文", "随堂测试", "2017-03-13"));
        myList.add(new ThreeParameterBean("数学", "模拟试卷一", "2017-03-13"));
        myList.add(new ThreeParameterBean("英语", "模拟试卷二", "2017-03-13"));
        myList.add(new ThreeParameterBean("政治", "随堂测试", "2017-03-13"));
        myList.add(new ThreeParameterBean("历史", "模拟试卷一", "2017-03-13"));
    }
}
