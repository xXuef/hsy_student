package hsy.com.hsy.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

import hsy.com.hsy.R;
import hsy.com.hsy.adapter.category.Category;
import hsy.com.hsy.adapter.category.CategoryAdapter;
import hsy.com.hsy.base.BaseFragment;

public class Fg_Team_Manager extends BaseFragment {




    @Override
    protected int getLayoutId() {
        return R.layout.my_listview;
    }

    @Override
    protected void initParams(View view, Bundle savedInstanceState) {
        ListView listView = (ListView) view.findViewById(R.id.listview);
        listView.setAdapter(new CategoryAdapter(getContext(),getData()));
    }


    /**
     * 创建测试数据
     */
    private ArrayList<Category> getData() {
        ArrayList<Category> listData = new ArrayList<Category>();
        Category categoryOne = new Category("路人甲");
        categoryOne.addItem("马三立");
        categoryOne.addItem("赵本山");
        categoryOne.addItem("郭德纲");
        categoryOne.addItem("周立波");
        Category categoryTwo = new Category("事件乙");
        categoryTwo.addItem("**贪污");
        categoryTwo.addItem("**照门");
        Category categoryThree = new Category("书籍丙");
        categoryThree.addItem("10天学会***");
        categoryThree.addItem("**大全");
        categoryThree.addItem("**秘籍");
        categoryThree.addItem("**宝典");
        categoryThree.addItem("10天学会***");
        categoryThree.addItem("10天学会***");
        categoryThree.addItem("10天学会***");
        categoryThree.addItem("10天学会***");
        Category categoryFour = new Category("城市");
        categoryFour.addItem("河南");
        categoryFour.addItem("天津");
        categoryFour.addItem("北京");
        categoryFour.addItem("上海");
        categoryFour.addItem("广州");
        categoryFour.addItem("湖北");
        categoryFour.addItem("重庆");
        categoryFour.addItem("山东");
        categoryFour.addItem("陕西");

        listData.add(categoryOne);
        listData.add(categoryTwo);
        listData.add(categoryThree);
        listData.add(categoryFour);

        return listData;
    }
}
