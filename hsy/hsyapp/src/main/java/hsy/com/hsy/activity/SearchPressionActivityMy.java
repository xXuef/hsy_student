package hsy.com.hsy.activity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import hsy.com.hsy.R;
import hsy.com.hsy.base.MyBaseActivity;

/**
 * 功能·· 生涯规划··查职业
 */
public class SearchPressionActivityMy extends MyBaseActivity {

    private EditText et_school;
    private ImageView iv_search;

    @Override
    public void initVariable() {
        setContentView(R.layout.activity_search_pression);
        tool_title.setText("查职业");

        et_school = findViewById(R.id.et_school);
        iv_search = findViewById(R.id.iv_search);
    }

    @Override
    public void toLoad(Bundle savedInstanceState) {

        initEditText();
    }


    /**
     * Description:监听edittext的变化
     * Data: 2018/6/9 17:37
     */
    private void initEditText() {
        et_school.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                //编辑框内容变化之前会调用该方法，s为编辑框内容变化之前的内容
                Log.i("beforeTextChanged", s.toString());
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //只要编辑框内容有变化就会调用该方法，s为编辑框变化后的内容
                Log.i("onTextChanged", s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
                //编辑框内容变化之后会调用该方法，s为编辑框内容变化后的内容
                Log.i("afterTextChanged", s.toString());
                if (s.length() > 0) {
                    iv_search.setVisibility(View.INVISIBLE);
                } else {
                    iv_search.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}
