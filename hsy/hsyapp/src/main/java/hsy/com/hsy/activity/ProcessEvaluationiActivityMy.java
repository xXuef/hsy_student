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
 * 功能···过程评价界面
 */
public class ProcessEvaluationiActivityMy extends MyBaseActivity {

    private ListView lv;

    @Override
    public void initVariable() {
        setContentView(R.layout.activity_process_evaluationi);
        tool_title.setText("过程评价");
        lv = (ListView) findViewById(R.id.lv);
    }

    @Override
    public void toLoad(Bundle savedInstanceState) {
        List<ThreeParameterBean> lists = new ArrayList<>();

        lists.add(new ThreeParameterBean("评价项", "评分", "评语"));
        lists.add(new ThreeParameterBean("语文评价", "60", "还不错"));
        lists.add(new ThreeParameterBean("数学评价", "60", "很优秀"));
        lists.add(new ThreeParameterBean("英语评价", "70", "还不错"));
        lists.add(new ThreeParameterBean("物理评价", "80", "继续努力"));

        lv.setAdapter(new TableAdapter(lists, this));

    }
}
