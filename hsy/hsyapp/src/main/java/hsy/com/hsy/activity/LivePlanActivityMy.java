package hsy.com.hsy.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import hsy.com.hsy.R;
import hsy.com.hsy.base.MyBaseActivity;
/**
 * 生涯规划
 */
public class LivePlanActivityMy extends MyBaseActivity {

    @BindView(R.id.search_school)
    RelativeLayout searchSchool;
    @BindView(R.id.search_professional)
    RelativeLayout searchProfessional;
    @BindView(R.id.search_choosecourse)
    RelativeLayout searchChoosecourse;
    @BindView(R.id.search_profession)
    RelativeLayout searchProfession;
    @BindView(R.id.testtool)
    RelativeLayout testtool;
    @BindView(R.id.test_report)
    RelativeLayout testReport;


    @Override
    public void initVariable() {
        setContentView(R.layout.activity_live_plan);
        ButterKnife.bind(this);
        tool_title.setText("生涯规划");
    }

    @Override
    public void toLoad(Bundle savedInstanceState) {

    }

    @OnClick({R.id.search_school, R.id.search_professional, R.id.search_choosecourse, R.id.search_profession, R.id.testtool, R.id.test_report})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.search_school:
                startActivity(new Intent(this,SearchSchoolActivityMy.class));
                break;
            case R.id.search_professional:
                startActivity(new Intent(this,SearchSpecialtyActivityMy.class));
                break;
            case R.id.search_choosecourse:
                startActivity(new Intent(this,SearchChooseCoutseActivityMy.class));
                break;
            case R.id.search_profession:
                startActivity(new Intent(this,SearchPressionActivityMy.class));
                break;
            case R.id.testtool:
                startActivity(new Intent(this,TestToolActivityMy.class));
                break;
            case R.id.test_report:
                startActivity(new Intent(this,TestExcelActivityMy.class));
                break;
        }
    }
}
