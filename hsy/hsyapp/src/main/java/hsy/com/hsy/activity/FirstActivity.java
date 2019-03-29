package hsy.com.hsy.activity;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.gyf.barlibrary.ImmersionBar;
import com.heima.tabview.library.TabView;
import com.heima.tabview.library.TabViewChild;

import java.util.ArrayList;
import java.util.List;

import hsy.com.hsy.R;
import hsy.com.hsy.fragment.Fg_Myfun;
import hsy.com.hsy.fragment.FunctionFragment;
import hsy.com.hsy.fragment.NotifyFragment;
import hsy.com.hsy.fragment.PersonalFragment;
import hsy.com.hsy.fragment.TrendsFragment;

/**
 * 程序入口
 */
public class FirstActivity extends AppCompatActivity {

    Fragment fg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        ImmersionBar.with(this).statusBarColor(R.color.stabar_color).fitsSystemWindows(true).init();
        TabView tabview = (TabView) findViewById(R.id.tabView);


        FrameLayout framlayout = (FrameLayout) findViewById(R.id.framlayout);
        List<TabViewChild> tabViewChildList = new ArrayList<>();
        TabViewChild tabViewChild01 = new TabViewChild(R.drawable.theooneun, R.drawable.theone, "动态", new TrendsFragment());
        //网上看到的
        FunctionFragment functionFragment = new FunctionFragment();
        //自己写出来的
        Fg_Myfun myfun = new Fg_Myfun();
        TabViewChild tabViewChild02 = new TabViewChild(R.drawable.thetwoun, R.drawable.thetwo, "功能", myfun);
        TabViewChild tabViewChild03 = new TabViewChild(R.drawable.thethreeon, R.drawable.thethree, "通知", new NotifyFragment());
        TabViewChild tabViewChild04 = new TabViewChild(R.drawable.thefouron, R.drawable.thefour, "个人", new PersonalFragment());
        tabViewChildList.add(tabViewChild01);
        tabViewChildList.add(tabViewChild02);
        tabViewChildList.add(tabViewChild03);
        tabViewChildList.add(tabViewChild04);

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.framlayout, new TrendsFragment(), null).commit();
        tabview.setTabViewChild(tabViewChildList, getSupportFragmentManager());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ImmersionBar.with(this).destroy();
    }

    private long firstime = 0;
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

            if (keyCode == KeyEvent.KEYCODE_BACK) {
                long secondtime = System.currentTimeMillis();
                if (secondtime - firstime > 3000) {

                    Toast.makeText(FirstActivity.this, "再按一次返回键退出", Toast.LENGTH_SHORT).show();
                    firstime = System.currentTimeMillis();

                    return true;
                } else {
                    finish();
                    System.exit(0);
                }
            }
        return super.onKeyDown(keyCode, event);
    }
}
