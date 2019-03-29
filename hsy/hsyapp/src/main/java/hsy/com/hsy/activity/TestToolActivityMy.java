package hsy.com.hsy.activity;

import android.os.Bundle;

import hsy.com.hsy.R;
import hsy.com.hsy.base.MyBaseActivity;


/**
 *功能·· 生涯规划··生涯评测
 */
public class TestToolActivityMy extends MyBaseActivity {


    @Override
    public void initVariable() {
        setContentView(R.layout.activity_test_tool);
        tool_title.setText("生涯测评");
    }

    @Override
    public void toLoad(Bundle savedInstanceState) {

    }
}
