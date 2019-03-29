package hsy.com.hsy.activity;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.view.PagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import fr.castorflex.android.verticalviewpager.VerticalViewPager;
import hsy.com.hsy.R;
import hsy.com.hsy.adapter.DialogGridViewAdapter;
import hsy.com.hsy.bean.ThreeParameterBean;
import hsy.com.hsy.util.ToastUtils;

public class QualityEvaluation extends AppCompatActivity {

    public static int item_grid_num = 2;//每一页中GridView中item的数量
    public static int number_columns = 2;//gridview一行展示的数目
    private VerticalViewPager view_pager;
    private pagerAdapter mAdapter;
    private List<ThreeParameterBean> dataList;
    private List<GridView> gridList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quality_evaluation);
        initView();

        initDatas();
    }

    private void initView() {
        view_pager = findViewById(R.id.viewpager);
        mAdapter = new pagerAdapter();
        view_pager.setAdapter(mAdapter);
        dataList = new ArrayList<>();
    }

    private void initDatas() {
        if (dataList.size() > 0) {
            dataList.clear();
        }
        if (gridList.size() > 0) {
            gridList.clear();
        }
        //初始化数据
        //初始化数据
        dataList.add(new ThreeParameterBean("https://ss0.baidu.com/6ONWsjip0QIZ8tyhnq/it/u=1967972454,1621682239&fm=58&bpow=496&bpoh=799", "萧炎", "资质卓绝，四岁练气，十岁拥有九段斗之气，十一岁成功凝聚斗之气旋，一跃成为家族百年之内最年轻的斗者。十二岁成为斗者却又连续三年功力倒退保持在斗之气三段，从此逐渐沦为遭人白眼的废柴。原因是名为药尘的八品巅峰炼药宗师的魂魄在母亲的遗物古戒中吸收他的斗气，在药尘停止吸收斗气后终于天赋重展，在药尘的帮助下一年时间突破斗者，震惊全城，后又在药尘的教导下，成为加玛帝国黑岩城最年轻的二品炼药师，凭借执着与信念闯荡大陆，不断取得辉煌的战绩。"));
        dataList.add(new ThreeParameterBean("https://ss1.baidu.com/6ONXsjip0QIZ8tyhnq/it/u=2476474363,1910627444&fm=58&bpow=1200&bpoh=1920", "萧薰儿", "萧薰儿，原名古薰儿。天蚕土豆所著异世大陆类玄幻小说《斗破苍穹》女主角之一，《武动乾坤》以及《大主宰》当中客串出场。为古族千金，天之骄女，古族近千年内斗帝血脉觉醒最完美者。拥有异火榜排名第四的金帝焚天炎，后转赠萧炎。"));
        dataList.add(new ThreeParameterBean("https://ss0.baidu.com/6ONWsjip0QIZ8tyhnq/it/u=1967972454,1621682239&fm=58&bpow=496&bpoh=799", "药老", "资质卓绝，四岁练气，十岁拥有九段斗之气，十一岁成功凝聚斗之气旋，一跃成为家族百年之内最年轻的斗者。十二岁成为斗者却又连续三年功力倒退保持在斗之气三段，从此逐渐沦为遭人白眼的废柴。原因是名为药尘的八品巅峰炼药宗师的魂魄在母亲的遗物古戒中吸收他的斗气，在药尘停止吸收斗气后终于天赋重展，在药尘的帮助下一年时间突破斗者，震惊全城，后又在药尘的教导下，成为加玛帝国黑岩城最年轻的二品炼药师，凭借执着与信念闯荡大陆，不断取得辉煌的战绩。"));
        dataList.add(new ThreeParameterBean("https://ss1.baidu.com/6ONXsjip0QIZ8tyhnq/it/u=2476474363,1910627444&fm=58&bpow=1200&bpoh=1920", "纳兰嫣然", "萧薰儿，原名古薰儿。天蚕土豆所著异世大陆类玄幻小说《斗破苍穹》女主角之一，《武动乾坤》以及《大主宰》当中客串出场。为古族千金，天之骄女，古族近千年内斗帝血脉觉醒最完美者。拥有异火榜排名第四的金帝焚天炎，后转赠萧炎。"));
        dataList.add(new ThreeParameterBean("https://ss1.baidu.com/6ONXsjip0QIZ8tyhnq/it/u=2476474363,1910627444&fm=58&bpow=1200&bpoh=1920", "小医仙", "小医仙，原名古薰儿。天蚕土豆所著异世大陆类玄幻小说《斗破苍穹》女主角之一，《武动乾坤》以及《大主宰》当中客串出场。为古族千金，天之骄女，古族近千年内斗帝血脉觉醒最完美者。拥有异火榜排名第四的金帝焚天炎，后转赠萧炎。"));
        dataList.add(new ThreeParameterBean("https://ss1.baidu.com/6ONXsjip0QIZ8tyhnq/it/u=2476474363,1910627444&fm=58&bpow=1200&bpoh=1920", "萧厉", "萧厉，原名古薰儿。天蚕土豆所著异世大陆类玄幻小说《斗破苍穹》女主角之一，《武动乾坤》以及《大主宰》当中客串出场。为古族千金，天之骄女，古族近千年内斗帝血脉觉醒最完美者。拥有异火榜排名第四的金帝焚天炎，后转赠萧炎。"));
        //计算viewpager一共显示几页
        int pageSize = dataList.size() % item_grid_num == 0
                ? dataList.size() / item_grid_num
                : dataList.size() / item_grid_num + 1;
        for (int i = 0; i < pageSize; i++) {
            final GridView gridView = new GridView(this);
            //本类里面的adapter
            final GridViewAdapter adapter = new GridViewAdapter(dataList, i);
            //封装起来的adapter 其实都一样···
            final DialogGridViewAdapter adapter1 = new DialogGridViewAdapter(dataList, i, this);
            gridView.setNumColumns(number_columns);
            gridView.setAdapter(adapter1);
            gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    adapter1.changeState(position);
                    TextView tv = view.findViewById(R.id.tvGone);
                    TextView name = view.findViewById(R.id.name);
                    String string = name.getText().toString();
                    tv.setText(string);
                    ToastUtils.showShort(tv.getText().toString());
                }
            });
            adapter1.notifyDataSetChanged();
            gridList.add(gridView);
        }
        mAdapter.add(gridList);
    }


    class pagerAdapter extends PagerAdapter {

        Context mContext;
        private List<GridView> gridList;

          pagerAdapter() {
            gridList = new ArrayList<>();
        }

        public void add(List<GridView> datas) {
            if (gridList.size() > 0) {
                gridList.clear();
            }
            gridList.addAll(datas);
            notifyDataSetChanged();
        }

        @Override
        public int getCount() {
            return gridList.size();
        }

        @Override
        public int getItemPosition(Object object) {
            return POSITION_NONE;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            GridView gv = gridList.get(position);
            container.addView(gv);
            return gridList.get(position);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

    }

    class GridViewAdapter extends BaseAdapter {
        private List<ThreeParameterBean> dataList;
        boolean isClick = false;
        boolean isElse = false;
        int selectPosition;

        GridViewAdapter(List<ThreeParameterBean> datas, int page) {
            dataList = new ArrayList<>();
            //start end分别代表要显示的数组在总数据List中的开始和结束位置
            int start = page * QualityEvaluation.item_grid_num;
            int end = start + QualityEvaluation.item_grid_num;
            while ((start < datas.size()) && (start < end)) {
                dataList.add(datas.get(start));
                start++;
            }
        }

        @Override
        public int getCount() {
            return dataList.size();
        }

        @Override
        public Object getItem(int i) {
            return dataList.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
        @Override
        public View getView(int position, View itemView, ViewGroup viewGroup) {
            final ViewHolder mHolder;
            if (itemView == null) {
                mHolder = new ViewHolder();
                itemView = LayoutInflater.from(viewGroup.getContext())
                        .inflate(R.layout.choose_dialog_item, viewGroup, false);
                mHolder.iv_img = (ImageView) itemView.findViewById(R.id.icon);
                mHolder.name = (TextView) itemView.findViewById(R.id.name);
                mHolder.content = (TextView) itemView.findViewById(R.id.comment);
                mHolder.ll = itemView.findViewById(R.id.ll);
                itemView.setTag(mHolder);
            } else {
                mHolder = (ViewHolder) itemView.getTag();
            }
            ThreeParameterBean bean = dataList.get(position);
            if (bean != null) {
                Glide.with(QualityEvaluation.this).load(bean.getName()).into(mHolder.iv_img);

                mHolder.iv_img.setImageResource(R.drawable.test);
                mHolder.name.setText(bean.getContent());
                mHolder.content.setText(bean.getTime());
            }

            if (selectPosition == position) {
                mHolder.ll.setBackgroundResource(R.drawable.iem_bg);
                notifyDataSetChanged();
            } else {
                mHolder.ll.setBackground(null);
            }

            return itemView;
        }

        public void changeState(int pos) {
            selectPosition = pos;
            notifyDataSetChanged();

        }

        private class ViewHolder {
            private ImageView iv_img;
            private TextView name;
            private TextView content;
            LinearLayout ll;
        }
    }
}
