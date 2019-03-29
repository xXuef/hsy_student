package hsy.com.hsy.activity;

import android.os.Bundle;

import hsy.com.hsy.R;
import hsy.com.hsy.base.MyBaseActivity;

/**
 *功能··
 */
public class TestExcelActivityMy extends MyBaseActivity {


    @Override
    public void initVariable() {
        setContentView(R.layout.activity_test_excel);
        tool_title.setText("生涯报告");
    }

    @Override
    public void toLoad(Bundle savedInstanceState) {

    }
}
