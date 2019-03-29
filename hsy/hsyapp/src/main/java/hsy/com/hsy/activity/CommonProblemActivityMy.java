package hsy.com.hsy.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import hsy.com.hsy.R;
import hsy.com.hsy.base.MyBaseActivity;

/**
 *
 * 常见问题 界面
 */
public class CommonProblemActivityMy extends MyBaseActivity {


    private LinearLayout ll_tell;

    @Override
    public void initVariable() {
        setContentView(R.layout.activity_common_problem);
        tool_title.setText("常见问题");
        ll_tell = findViewById(R.id.iwanttellyou);
    }

    @Override
    public void toLoad(Bundle savedInstanceState) {

        ll_tell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CommonProblemActivityMy.this,CoupleBackActivityMy.class));
            }
        });
    }
}
