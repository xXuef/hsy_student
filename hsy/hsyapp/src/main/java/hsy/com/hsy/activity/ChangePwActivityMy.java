package hsy.com.hsy.activity;

import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import hsy.com.hsy.R;
import hsy.com.hsy.base.MyBaseActivity;

/**
 * 修改密码界面
 */
public class ChangePwActivityMy extends MyBaseActivity {


    @BindView(R.id.student_code)
    TextView studentCode;
    @BindView(R.id.id_number)
    EditText idNumber;
    @BindView(R.id.old_pw)
    EditText oldPw;
    @BindView(R.id.eye_one)
    ImageButton eyeOne;
    @BindView(R.id.new_pw)
    EditText newPw;
    @BindView(R.id.eye_two)
    ImageButton eyeTwo;
    @BindView(R.id.ok)
    Button ok;
    Boolean isHideFirst = true;

    @Override
    public void initVariable() {
        setContentView(R.layout.activity_change_pw);
        ButterKnife.bind(this);
        tool_title.setText("修改密码");

        eyeOne.setImageResource(R.drawable.yjbkj);
        oldPw.setTransformationMethod(PasswordTransformationMethod.getInstance());
        eyeTwo.setImageResource(R.drawable.yjbkj);
        newPw.setTransformationMethod(PasswordTransformationMethod.getInstance());

        isHideFirst = true;
    }

    @Override
    public void toLoad(Bundle savedInstanceState) {

    }


    @OnClick({R.id.eye_one, R.id.eye_two, R.id.ok})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.eye_one:
                if (isHideFirst == true) {
                    eyeOne.setImageResource(R.drawable.yjkj);
                    oldPw.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    oldPw.setSelection(oldPw.getText().length());
                    isHideFirst = false;
                } else {
                    eyeOne.setImageResource(R.drawable.yjbkj);
                    oldPw.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    oldPw.setSelection(oldPw.getText().length());
                    isHideFirst = true;
                }
                break;
            case R.id.eye_two:
                if (isHideFirst == true) {
                    eyeTwo.setImageResource(R.drawable.yjkj);
                    newPw.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    newPw.setSelection(newPw.getText().length());
                    isHideFirst = false;
                } else {
                    eyeTwo.setImageResource(R.drawable.yjbkj);
                    newPw.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    newPw.setSelection(newPw.getText().length());
                    isHideFirst = true;
                }
                break;
            case R.id.ok:
                finish();
                break;
        }
    }


}
