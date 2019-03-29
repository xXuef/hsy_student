package hsy.com.hsy.activity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import hsy.com.hsy.R;
import hsy.com.hsy.adapter.SchoolItemAdapter;
import hsy.com.hsy.base.MyBaseActivity;


/**
 *功能·· 生涯规划··查院校
 */
public class SearchSchoolActivityMy extends MyBaseActivity {


    @BindView(R.id.et_school)
    EditText etSchool;
    @BindView(R.id.iv_search)
    ImageView ivSearch;
    @BindView(R.id.num_school)
    TextView numSchool;
    @BindView(R.id.lv_school)
    ListView lvSchool;


    List<String> icons;
    List<String> names;
    List<String> ofs;
    List<String> types;
    List<String> hotss;
    List<String> Ranking;

    @Override
    public void initVariable() {
        setContentView(R.layout.activity_search_school);
        ButterKnife.bind(this);

        //初始化edittext的
        initEditText();
        tool_title.setText("查院校");
        icons = new ArrayList<>();
        names = new ArrayList<>();
        ofs = new ArrayList<>();
        types = new ArrayList<>();
        hotss = new ArrayList<>();
        Ranking = new ArrayList<>();

        icons.add("https://ss0.baidu.com/6ONWsjip0QIZ8tyhnq/it/u=2031677745,545048845&fm=58&bpow=400&bpoh=400");
        icons.add("https://ss0.baidu.com/6ONWsjip0QIZ8tyhnq/it/u=2031677745,545048845&fm=58&bpow=400&bpoh=400");
        names.add("复旦大学");
        names.add("复旦大学");
        ofs.add("隶属:教育部");
        ofs.add("隶属:教育部");
        types.add("性质:公立");
        types.add("性质:公立");
        hotss.add("热度: 13.9万");
        hotss.add("热度: 13.9万");
        Ranking.add("全国排名: 4");
        Ranking.add("全国排名: 4");

    }

    @Override
    public void toLoad(Bundle savedInstanceState) {
        SchoolItemAdapter schoolItemAdapter = new SchoolItemAdapter(SearchSchoolActivityMy.this, icons.size(), icons, names, ofs, types, hotss, Ranking);
        lvSchool.setAdapter(schoolItemAdapter);
    }


    /**
     * Description:监听edittext的变化
     * Data: 2018/6/9 17:37
     */
    private void initEditText() {
        etSchool.addTextChangedListener(new TextWatcher() {
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
                if (s.length()>0){
                    ivSearch.setVisibility(View.INVISIBLE);
                }else {
                    ivSearch.setVisibility(View.VISIBLE);
                }

            }
        });
    }

}
