package hsy.com.hsy.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import de.hdodenhof.circleimageview.CircleImageView;
import hsy.com.hsy.R;
import hsy.com.hsy.activity.StartTestActivityMy;
import hsy.com.hsy.base.BaseFragment;
import hsy.com.hsy.util.ToastUtils;

/**
 * Created by Administrator on 2018/4/21.
 */

public class Fg_SubjectChooseSchool extends BaseFragment {


    @BindView(R.id.iv_politics)
    CircleImageView ivPolitics;
    @BindView(R.id.politics)
    CircleImageView politics;
    @BindView(R.id.iv_history)
    CircleImageView ivHistory;
    @BindView(R.id.history)
    CircleImageView history;
    @BindView(R.id.iv_geogryphy)
    CircleImageView ivGeogryphy;
    @BindView(R.id.geography)
    CircleImageView geography;
    @BindView(R.id.iv_physics)
    CircleImageView ivPhysics;
    @BindView(R.id.physics)
    CircleImageView physics;
    @BindView(R.id.iv_chemistry)
    CircleImageView ivChemistry;
    @BindView(R.id.chemistry)
    CircleImageView chemistry;
    @BindView(R.id.iv_biology)
    CircleImageView ivBiology;
    @BindView(R.id.biology)
    CircleImageView biology;
    @BindView(R.id.iv_technology)
    CircleImageView ivTechnology;
    @BindView(R.id.technology)
    CircleImageView technology;
    @BindView(R.id.iv_literature_art)
    CircleImageView ivLiteratureArt;
    @BindView(R.id.literature_art)
    CircleImageView literatureArt;
    @BindView(R.id.iv_sports)
    CircleImageView ivSports;
    @BindView(R.id.sports)
    CircleImageView sports;
    @BindView(R.id.tv_politics)
    TextView tvPolitics;
    @BindView(R.id.tv_history)
    TextView tvHistory;
    @BindView(R.id.tv_geogryphy)
    TextView tvGeogryphy;
    @BindView(R.id.tv_physics)
    TextView tvPhysics;
    @BindView(R.id.tv_chemstry)
    TextView tvChemstry;
    @BindView(R.id.tv_biologry)
    TextView tvBiologry;
    @BindView(R.id.tv_technology)
    TextView tvTechnology;
    @BindView(R.id.tv_literature_art)
    TextView tvLiteratureArt;
    @BindView(R.id.tv_sports)
    TextView tvSports;
    @BindView(R.id.come)
    Button come;
    Unbinder unbinder;
    ArrayList<String> addNum = new ArrayList<>();


    @Override
    protected int getLayoutId() {
        return R.layout.fg_subject_choose_school;
    }

    @Override
    protected void initParams(View view, Bundle savedInstanceState) {
        unbinder = ButterKnife.bind(this, view);

    }
    //控制添加数量
    private void addNum(String str, View view) {
        if (addNum.size() < 3) {
            selectVisible(view, str);
        } else if (addNum.size() >= 3) {
            selectVisible(view, str);
        }
    }

    private void selectVisible(View v, String str) {
        int a = v.getVisibility();
        //点击一下 如果是显示状态
        if (a == 0) {
            if (addNum.contains(str)) {
                v.setVisibility(View.INVISIBLE);
                addNum.remove(str);
            }
            //如果点击一下 是不显示状态
        } else if (a == 4) {
            if (addNum.size() < 3) {
                v.setVisibility(View.VISIBLE);
                if (!addNum.contains(str)) {
                    addNum.add(str);
                }
            }
        }
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.iv_politics, R.id.iv_history, R.id.iv_geogryphy, R.id.iv_physics, R.id.iv_chemistry, R.id.iv_biology, R.id.iv_technology, R.id.iv_literature_art, R.id.iv_sports, R.id.come})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_politics:
                String zhengzhi = tvPolitics.getText().toString();
                addNum(zhengzhi, politics);
                break;
            case R.id.iv_history:
                String lishi = tvHistory.getText().toString();
                addNum(lishi, history);
                break;
            case R.id.iv_geogryphy:
                String dili = tvGeogryphy.getText().toString();
                addNum(dili, geography);
                break;
            case R.id.iv_physics:
                String wuli = tvPhysics.getText().toString();
                addNum(wuli, physics);
                break;
            case R.id.iv_chemistry:
                String huaxue = tvChemstry.getText().toString();
                addNum(huaxue, chemistry);
                break;
            case R.id.iv_biology:
                String shengwu = tvBiologry.getText().toString();
                addNum(shengwu, biology);
                break;
            case R.id.iv_technology:
                String jishu = tvTechnology.getText().toString();
                addNum(jishu, technology);
                break;
            case R.id.iv_literature_art:
                String wenyi = tvLiteratureArt.getText().toString();
                addNum(wenyi, literatureArt);
                break;
            case R.id.iv_sports:
                String tiyu = tvSports.getText().toString();
                addNum(tiyu, sports);
                break;
            case R.id.come:
                if (addNum.size() < 1) {

                    ToastUtils.showShort("最少选择一门课程，么么哒！");
                } else {
                    Intent intent = new Intent(getContext(), StartTestActivityMy.class);
                    intent.putStringArrayListExtra("chooseSubjects", addNum);
                    startActivity(intent);
                }
                break;
        }
    }

}
