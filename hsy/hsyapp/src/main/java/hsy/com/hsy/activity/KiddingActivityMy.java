package hsy.com.hsy.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import hsy.com.hsy.R;
import hsy.com.hsy.base.MyBaseActivity;
import hsy.com.hsy.fragment.FunctionFragment;
import hsy.com.hsy.fragment.NotifyFragment;
import hsy.com.hsy.fragment.PersonalFragment;


/**
 * 主页面--搭失败
 */
public class KiddingActivityMy extends MyBaseActivity {

    @BindView(R.id.grag)
    FrameLayout grag;
    @BindView(R.id.one)
    RadioButton one;
    @BindView(R.id.two)
    RadioButton two;
    @BindView(R.id.three)
    RadioButton three;
    @BindView(R.id.group)
    RadioGroup group;
    private FragmentManager fragmentManager;


    @Override
    public void initVariable() {
        setContentView(R.layout.activity_kidding);
        ButterKnife.bind(this);
        fragmentManager = getSupportFragmentManager();

    }

    @Override
    public void toLoad(Bundle savedInstanceState) {

        fragmentManager.beginTransaction().add(R.id.grag,new FunctionFragment(),null).commit();

    }

    @OnClick({R.id.one, R.id.two, R.id.three})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.one:
                fragmentManager.beginTransaction().add(R.id.grag, new FunctionFragment(), null).commit();
                break;
            case R.id.two:
                fragmentManager.beginTransaction().add(R.id.grag, new NotifyFragment(), null).commit();
                break;
            case R.id.three:
                fragmentManager.beginTransaction().add(R.id.grag, new PersonalFragment(), null).commit();
                break;
        }
    }
}
