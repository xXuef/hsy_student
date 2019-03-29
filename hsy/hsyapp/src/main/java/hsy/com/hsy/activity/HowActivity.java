package hsy.com.hsy.activity;

import android.os.Bundle;

import hsy.com.hsy.R;
import hsy.com.hsy.base.MyBaseActivity;

/**
 * Description:onCrete
 * Data: 2018/6/8 15:32
 * @author: Summer
 */
public class HowActivity extends MyBaseActivity {

    @Override
    public void initVariable() {
        setContentView(R.layout.activity_how);
        tool_title.setText("详情");
    }

    @Override
    public void toLoad(Bundle savedInstanceState) {

    }
}
