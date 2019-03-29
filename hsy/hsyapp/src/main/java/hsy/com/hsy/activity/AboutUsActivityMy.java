package hsy.com.hsy.activity;

import android.os.Bundle;

import hsy.com.hsy.R;
import hsy.com.hsy.base.MyBaseActivity;

/**
 * 关于我们  页面
 */
public class AboutUsActivityMy extends MyBaseActivity {


    @Override
    public void initVariable() {
        setContentView(R.layout.activity_about_me);
        tool_title.setText("关于我们");
    }

    @Override
    public void toLoad(Bundle savedInstanceState) {

    }
}
