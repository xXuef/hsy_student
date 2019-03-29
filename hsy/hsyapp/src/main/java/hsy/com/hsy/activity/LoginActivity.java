package hsy.com.hsy.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.gyf.barlibrary.ImmersionBar;

import hsy.com.hsy.R;
import hsy.com.hsy.util.Constans;
import hsy.com.hsy.util.SharePreUtil;
/**
 * 登录界面
 */
public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView pw_iv;
    Boolean isHideFirst=true;
    private EditText et_pw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_activity);

        ImmersionBar.with(this).statusBarColor(R.color.stabar_color).fitsSystemWindows(true).init();
        et_pw = (EditText) findViewById(R.id.et_login_pw);
        TextView forget_pw = (TextView) findViewById(R.id.forget_pw);
        TextView tv_titile = (TextView) findViewById(R.id.title_name);
        Button bt_login = (Button) findViewById(R.id.bt_login);
        pw_iv = (ImageView) findViewById(R.id.look_pw_iv);
        tv_titile.setText("登录");
        pw_iv.setImageResource(R.drawable.yjbkj);
        et_pw.setTransformationMethod(PasswordTransformationMethod.getInstance());

        forget_pw.setOnClickListener(this);
        pw_iv.setOnClickListener(this);
        bt_login.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.forget_pw:
                startActivity(new Intent(LoginActivity.this, ChangePwActivityMy.class));
                break;
            case R.id.bt_login:

                SharePreUtil sharePreUtil = new SharePreUtil(LoginActivity.this, Constans.LOGING_STATE_SP);
                sharePreUtil.setValue(Constans.LOGING_STATE, true);
                finish();
                break;
            case R.id.look_pw_iv:
                if (isHideFirst == true) {
                    pw_iv.setImageResource(R.drawable.yjkj);
                    et_pw.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    et_pw.setSelection(et_pw.getText().length());
                    isHideFirst = false;
                } else {
                    pw_iv.setImageResource(R.drawable.yjbkj);
                    et_pw.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    et_pw.setSelection(et_pw.getText().length());
                    isHideFirst = true;
                }
                break;
        }
    }
}
