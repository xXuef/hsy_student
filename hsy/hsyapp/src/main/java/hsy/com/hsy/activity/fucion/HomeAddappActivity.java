package hsy.com.hsy.activity.fucion;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ListView;

import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import hsy.com.hsy.R;
import hsy.com.hsy.adapter.fuctioin.HomeAddappAdapter;
import hsy.com.hsy.bean.AppInfo;
import hsy.com.hsy.fragment.FunctionFragment;
import hsy.com.hsy.sql.DatabaseHelper;
import hsy.com.hsy.sql.HomeLastData;
import hsy.com.hsy.util.CommonUtil;


/**
 * Description:网上找的功能添加界面
 * Data: 2018/6/8 16:57
 * @author: Summer
 */
public class HomeAddappActivity extends Activity {

    private ListView listView;
    private HomeAddappAdapter addappAdapter;
    private List<AppInfo> appInfos;
    private Button confim_btn;
    private DatabaseHelper sqlHelper = OpenHelperManager.getHelper(this, DatabaseHelper.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.home_add_app);

        initView();
    }

    public void initView() {
        listView = (ListView) findViewById(R.id.home_add_app_listview);
        //完成
        confim_btn = (Button) findViewById(R.id.home_add_app_btn);
        confim_btn.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                //TODO
                //对数据库进行操作
                updateHomeApp();
                finish();
            }
        });
        addappAdapter = new HomeAddappAdapter(HomeAddappActivity.this);
        addappAdapter.setData(FunctionFragment.allApps);
        listView.setAdapter(addappAdapter);
    }

    private void updateHomeApp() {
        ArrayList<HomeLastData> hldList = new ArrayList<HomeLastData>();
        for (AppInfo appinfo : FunctionFragment.allApps) {
            HomeLastData hld = new HomeLastData();
            hld.setId(appinfo.getId());
            hld.setData(appinfo.getAppId());
            hldList.add(hld);
        }
        try {
            Dao<HomeLastData, Integer> dao = sqlHelper.getHomeLastDataDao();
            dao.delete(hldList);
            for (AppInfo appinfo : FunctionFragment.addAppInfos) {
                if (!appinfo.getAppId().equals(CommonUtil.appId10)) {
                    HomeLastData _hld = new HomeLastData();
                    _hld.setId(appinfo.getId());
                    _hld.setData(appinfo.getAppId());
                    dao.createOrUpdate(_hld);
                }
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
            Intent intent = new Intent(HomeAddappActivity.this, FunctionFragment.class);
            setResult(RESULT_OK, intent);
            finish();
            return false;
        }
        return false;
    }
}
