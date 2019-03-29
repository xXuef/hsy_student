package hsy.com.hsy.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;
import hsy.com.hsy.R;
import hsy.com.hsy.activity.AboutUsActivityMy;
import hsy.com.hsy.activity.ChangePwActivityMy;
import hsy.com.hsy.activity.CommonProblemActivityMy;
import hsy.com.hsy.activity.LoginActivity;
import hsy.com.hsy.activity.PersonalDataActivityMy;
import hsy.com.hsy.util.Constans;
import hsy.com.hsy.util.SharePreUtil;
import hsy.com.hsy.util.ToastUtils;

/**
 * 作者：Administrator on 2018/4/14 11:43
 */

public class PersonalFragment extends Fragment {


    View view;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.student_icon)
    CircleImageView studentIcon;
    @BindView(R.id.student_name)
    TextView studentName;
    @BindView(R.id.class_num)
    TextView classNum;
    @BindView(R.id.student_data)
    LinearLayout studentData;
    @BindView(R.id.stu_num)
    TextView stuNum;
    @BindView(R.id.sex)
    TextView sex;
    @BindView(R.id.pw_change)
    LinearLayout pwChange;
    @BindView(R.id.about_us)
    LinearLayout aboutUs;
    @BindView(R.id.frequently_question)
    LinearLayout frequentlyQuestion;
    @BindView(R.id.bt_out_login)
    TextView btOutLogin;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.personalfragment, container, false);
        ButterKnife.bind(this, view);

        TextView name = (TextView) view.findViewById(R.id.tv_title);
        name.setText("个人");
        studentIcon.setImageResource(R.drawable.choose);
        studentName.setText("胡汉三");
        classNum.setText("社会三班");
        stuNum.setText("666888");
        sex.setText("男");


        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        SharePreUtil sharePreUtil = new SharePreUtil(getContext(), Constans.LOGING_STATE_SP);
        boolean isLogin = sharePreUtil.getValue(Constans.LOGING_STATE, true);
        if (isLogin == false) {
            ToastUtils.showShort("请先登录");
            startActivity(new Intent(getContext(), LoginActivity.class));
        }

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @OnClick({R.id.student_data, R.id.pw_change, R.id.about_us, R.id.frequently_question, R.id.bt_out_login})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.student_data:
                startActivity(new Intent(getContext(), PersonalDataActivityMy.class));
                break;
            case R.id.pw_change:
                startActivity(new Intent(getContext(), ChangePwActivityMy.class));
                break;
            case R.id.about_us:
                startActivity(new Intent(getContext(), AboutUsActivityMy.class));
                break;
            case R.id.frequently_question:
                startActivity(new Intent(getContext(), CommonProblemActivityMy.class));
                break;
            case R.id.bt_out_login:
                SharePreUtil sharePreUtil = new SharePreUtil(getContext(), Constans.LOGING_STATE_SP);
                sharePreUtil.setValue(Constans.LOGING_STATE, false);
                startActivity(new Intent(getContext(), LoginActivity.class));
                break;
        }
    }


}
