package hsy.com.hsy.activity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.gyf.barlibrary.ImmersionBar;

import hsy.com.hsy.R;
import hsy.com.hsy.base.MyBaseActivity;

/**
 * 请假记录
 */
public class LeaveHistoryActivityMy extends MyBaseActivity {


    private ListView lv;

    @Override
    public void initVariable() {
        setContentView(R.layout.my_listview);
        ImmersionBar.with(this).statusBarColor(R.color.stabar_color).fitsSystemWindows(true).init();
        tool_title.setText("历史请假");
        lv = findViewById(R.id.listview);
    }

    @Override
    public void toLoad(Bundle savedInstanceState) {
        String []data=new String[]{"2016.6.3   病假","2016.6.3   事假","2016.6.3   事假"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, data);
        lv.setAdapter(adapter);


    }

    @Override
    protected synchronized void onDestroy() {
        super.onDestroy();
        ImmersionBar.with(this).destroy();
    }
}
