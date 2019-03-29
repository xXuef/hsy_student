package hsy.com.hsy.util;


import hsy.com.hsy.R;
import hsy.com.hsy.bean.AppInfo;

public class CommonUtil {
    private static final String appId1 = "10001";
    private static final String appId2 = "10002";
    private static final String appId3 = "10003";
    private static final String appId4 = "10004";
    private static final String appId5 = "10005";
    private static final String appId6 = "10006";
    private static final String appId7 = "10007";
    private static final String appId8 = "10008";
    private static final String appId9 = "10009";
    public static final String appId10 = "10010";
    public static final String appId11 = "10011";
    public static final String appId12 = "10012";

    //首页应用添加在这里
    public static String[] MainHomeApp = {appId1, appId2, appId3, appId4, appId5, appId10};
    //应用中心的应用在这里
    public static String[] MainAppApp = {appId1, appId2, appId3, appId4, appId5, appId6, appId7, appId8, appId9,appId11, appId12};

    public static AppInfo getApp(String id) {
        if (id.equals(appId1)) {
            return new AppInfo(appId1, "选课", R.drawable.chooesobject, "1");
        } else if (id.equals(appId2)) {
            return new AppInfo(appId2, "成绩查看", R.drawable.reslutlook, "2");
        } else if (id.equals(appId3)) {
            return new AppInfo(appId3, "生涯规划", R.drawable.liveplan, "3");
        } else if (id.equals(appId4)) {
            return new AppInfo(appId4, "通讯录", R.drawable.adress, "4");
        } else if (id.equals(appId5)) {
            return new AppInfo(appId5, "过程评价", R.drawable.processevaluation, "5");
        } else if (id.equals(appId6)) {
            return new AppInfo(appId6, "社团", R.drawable.team, "6");
        } else if (id.equals(appId7)) {
            return new AppInfo(appId7, "考勤", R.drawable.turnofrun, "7");
        } else if (id.equals(appId8)) {
            return new AppInfo(appId8, "作业", R.drawable.homework, "8");
        } else if (id.equals(appId9)) {
            return new AppInfo(appId9, "请假", R.drawable.leave, "9");
        } else if (id.equals(appId10)) {
            return new AppInfo(appId10, "添加", R.drawable.add, "10");
        } else if (id.equals(appId11)) {
            return new AppInfo(appId11, "成绩分析",R.drawable.resultexcel, "11");
        } else if (id.equals(appId12)) {
            return new AppInfo(appId12, "图书馆",R.drawable.library, "12");
        }
        return null;
    }

}
