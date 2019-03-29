package hsy.com.hsy.bean;

/**
 * Created by Administrator on 2018/4/19.
 */

public class User {

    /*
    * "历史"
    "英语"
    "数学"
    "语文"
    "化学"
    "生物"*/
    String name;
    String hository;
    String english;
    String math;
    String chinese;
    String huaxue;
    String shengwu;

    public User(String name, String hository, String english, String math, String chinese, String huaxue, String shengwu) {
        this.name = name;
        this.hository = hository;
        this.english = english;
        this.math = math;
        this.chinese = chinese;
        this.huaxue = huaxue;
        this.shengwu = shengwu;
    }

}
