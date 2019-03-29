package hsy.com.hsy.fragment;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import hsy.com.hsy.R;
import hsy.com.hsy.activity.AdressActivityMy;
import hsy.com.hsy.activity.ChooseSubjectActivityMy;
import hsy.com.hsy.activity.HomeWorkActivityMy;
import hsy.com.hsy.activity.LeaveActivity;
import hsy.com.hsy.activity.LibraryActivityMy;
import hsy.com.hsy.activity.LivePlanActivityMy;
import hsy.com.hsy.activity.ProcessEvaluationiActivityMy;
import hsy.com.hsy.activity.ResultExcelActivityMy;
import hsy.com.hsy.activity.ResultLookActivityMy;
import hsy.com.hsy.activity.TeamActivityMy;
import hsy.com.hsy.activity.TurnOfWorkActivityMy;
import hsy.com.hsy.activity.fucion.HomeAddappActivity;
import hsy.com.hsy.adapter.fuctioin.HomeEditappAdapter;
import hsy.com.hsy.bean.AppInfo;
import hsy.com.hsy.sql.DatabaseHelper;
import hsy.com.hsy.sql.HomeLastData;
import hsy.com.hsy.util.CommonUtil;
import hsy.com.hsy.util.ToastUtils;

/**
 * 作者：Administrator on 2018/4/14 11:35
 * 功能
 */

public class FunctionFragment extends Fragment {


    private Vibrator mVibrator;
    GridView app_gridview;
    public static List<AppInfo> allApps = new ArrayList<AppInfo>();
    public static LinkedList<AppInfo> addAppInfos = new LinkedList<AppInfo>();
    protected DatabaseHelper sqlHelper;
    static HomeEditappAdapter editappAdapter;
    Context activity;

    private static boolean isShowDelete;
    private View rootView;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.activity = context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        if (rootView== null) {
            rootView = LayoutInflater.from(activity).inflate(R.layout.functionfragment_two, null, false);
            sqlHelper = getHelper();
            mVibrator = (Vibrator) activity.getSystemService(Context.VIBRATOR_SERVICE);
            app_gridview = (GridView) rootView.findViewById(R.id.gridview);
            TextView titile = (TextView) rootView.findViewById(R.id.title_name);
            titile.setText("功能");
            initView();
        }else{
            ViewGroup parent = (ViewGroup) rootView.getParent();
            if (parent != null) {
                parent.removeView(rootView);
            }
        }




        return rootView;
    }


    protected DatabaseHelper getHelper() {
        if (sqlHelper == null) {
            sqlHelper = OpenHelperManager.getHelper(activity, DatabaseHelper.class);
        }
        return sqlHelper;
    }


    private void initView() {
        initAppInfos();
        editappAdapter = new HomeEditappAdapter(activity);
        editappAdapter.setData(addAppInfos);

        app_gridview.setAdapter(editappAdapter);

        app_gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                final int p = position;
                if (isShowDelete) {
                    if (position == parent.getCount() - 1) {
                        isShowDelete = false;
                        editappAdapter.setIsShowDelete(isShowDelete);
                        return;
                    } else {
                        deleteFromSql(p);
                        editappAdapter.delete(p);
                        editappAdapter.setIsShowDelete(isShowDelete);
                        editappAdapter.notifyDataSetChanged();
                    }

                } else {
                    if (position == parent.getCount() - 1) {
                        Intent intent = new Intent(getContext(), HomeAddappActivity.class);
                        startActivity(intent);
                    }
                    //跳转
                    AppInfo info = (AppInfo) app_gridview.getItemAtPosition(p);
                    String appid = info.getAppId();
                    click(appid);
                }
            }
        });
        //gridview长按事件
        app_gridview.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {

            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view,
                                           int position, long id) {
                if (position == parent.getCount() - 1) {
                    isShowDelete = false;
                    return false;
                } else {
                    if (isShowDelete) {
                        isShowDelete = false;
                    } else {
                        isShowDelete = true;
                    }
                    mVibrator.vibrate(50);
                    editappAdapter.setIsShowDelete(isShowDelete);
                    //动画---闪动效果
                    Animation shake = AnimationUtils.loadAnimation(getContext(),
                            R.anim.shake);
                    app_gridview.startAnimation(shake);
                    if (isShowDelete==true) {
                        ToastUtils.showShort( "再次长按可取消编辑");
                    }
                    return true;
                }
            }
        });


    }

    public static boolean onKeyDown(int keyCode, KeyEvent event) {
        // TODO Auto-generated method stub
        if (keyCode == event.KEYCODE_BACK) {

                isShowDelete = false;
                editappAdapter.setIsShowDelete(isShowDelete);
                editappAdapter.notifyDataSetChanged();
                return true;

        }
        return true;
    }
    private static long firstime = 0;
    private void initAppInfos() {

        Map<String, String> homeAppMap = getHomeAppMapFromSql();
        allApps.clear();
        for (int i = 0; i < CommonUtil.MainAppApp.length; i++) {
            AppInfo appInfo = (CommonUtil.getApp(CommonUtil.MainAppApp[i]));
            appInfo.setId(i + 1);
            if (homeAppMap.containsKey(CommonUtil.MainAppApp[i])) {
                appInfo.setState(true);
                addAppInfos.add(appInfo);
            }
            allApps.add(appInfo);
        }
        AppInfo _appInfo = (CommonUtil.getApp(CommonUtil.appId10));
        addAppInfos.add(_appInfo);
    }

    //删除应用数据
    protected void deleteFromSql(int p) {
        HomeLastData hld = new HomeLastData();
        AppInfo ai = addAppInfos.get(p);
        hld.setId(ai.getId());
        hld.setData(hld.getData());
        try {
            Dao<HomeLastData, Integer> dao = sqlHelper.getHomeLastDataDao();
            dao.delete(hld);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    private Map<String, String> getHomeAppMapFromSql() {
        // TODO Auto-generated method stub
        List<HomeLastData> list = null;
        Map<String, String> homeAppMap = new HashMap<String, String>();
        try {
            list = sqlHelper.getHomeLastDataDao().queryForAll();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        if (null != list) {
            for (HomeLastData hld : list) {
                homeAppMap.put(hld.getData(), hld.getData());
            }
        }


        return homeAppMap;
    }

    protected void click(String appId) {
        if ("10001".equals(appId)) {
//            Toast.makeText(getContext(), "选科", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(getContext(), ChooseSubjectActivityMy.class));
        } else if ("10002".equals(appId)) {
//            Toast.makeText(getContext(), "成绩查看", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(getContext(), ResultLookActivityMy.class));
        } else if ("10003".equals(appId)) {
//            Toast.makeText(getContext(), "生涯规划", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(getContext(), LivePlanActivityMy.class));
        } else if ("10004".equals(appId)) {
//            Toast.makeText(getContext(), "联系人", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(getContext(), AdressActivityMy.class));
        } else if ("10005".equals(appId)) {
//            Toast.makeText(getContext(), "过程评价", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(getContext(), ProcessEvaluationiActivityMy.class));
        } else if ("10006".equals(appId)) {
//            Toast.makeText(getContext(), "社团", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(getContext(), TeamActivityMy.class));
        } else if ("10007".equals(appId)) {
//            Toast.makeText(getContext(), "出勤", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(getContext(),TurnOfWorkActivityMy.class));
        } else if ("10008".equals(appId)) {
//            Toast.makeText(getContext(), "作业", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(getContext(), HomeWorkActivityMy.class));
        } else if ("10009".equals(appId)) {
//            Toast.makeText(getContext(), "请假", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(getContext(), LeaveActivity.class));
        }else if ("10011".equals(appId)){
//            Toast.makeText(getContext(), "成绩分析", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(getContext(), ResultExcelActivityMy.class));
        }else if ("10012".equals(appId)){
//            Toast.makeText(getContext(), "图书馆", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(getContext(), LibraryActivityMy.class));
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }


    @Override
    public void onResume() {
        super.onResume();
        if (editappAdapter != null) {
            editappAdapter.notifyDataSetChanged();
        }
    }


    @Override
    public void onPause() {
        super.onPause();
        if (editappAdapter != null) {
            editappAdapter.notifyDataSetChanged();
        }
    }
}
