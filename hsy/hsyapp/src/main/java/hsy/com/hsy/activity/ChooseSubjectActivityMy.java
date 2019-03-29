package hsy.com.hsy.activity;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.BitmapCallback;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;
import fr.castorflex.android.verticalviewpager.VerticalViewPager;
import hsy.com.hsy.R;
import hsy.com.hsy.adapter.ChooseSubjectItemAdapter;
import hsy.com.hsy.adapter.DialogGridViewAdapter;
import hsy.com.hsy.base.MyBaseActivity;
import hsy.com.hsy.bean.ThreeParameterBean;
import hsy.com.hsy.bean.TwoParameterBean;
import hsy.com.hsy.util.ToastUtils;
import okhttp3.Call;

/**
 * 功能··选课界面
 */
public class ChooseSubjectActivityMy extends MyBaseActivity {

    @BindView(R.id.wuli)
    CircleImageView wuli;
    @BindView(R.id.huaxue)
    CircleImageView huaxue;
    @BindView(R.id.dili)
    CircleImageView dili;
    @BindView(R.id.zhengzhi)
    CircleImageView zhengzhi;
    @BindView(R.id.shengwu)
    CircleImageView shengwu;
    @BindView(R.id.shuxue)
    CircleImageView shuxue;
    @BindView(R.id.lv_history_choose)
    ListView lv_history_choose;

    @Override
    public void initVariable() {
        setContentView(R.layout.activity_choose_subject);
        ButterKnife.bind(this);
        tool_title.setText("选课");
    }

    @Override
    public void toLoad(Bundle savedInstanceState) {

        //试验
        String url = "http://d.hiphotos.baidu.com/image/pic/item/6159252dd42a2834171827b357b5c9ea14cebfcf.jpg";
        OkHttpUtils.get().url(url).build().execute(new BitmapCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {

            }

            @Override
            public void onResponse(Bitmap response, int id) {
//               wuli.setImageBitmap(response);
            }
        });

        List<TwoParameterBean> lists = new ArrayList<>();
        lists.add(new TwoParameterBean("2018.3.2", "语文、数学、英语"));
        lists.add(new TwoParameterBean("2018.1.25", "语文、数学、英语"));
        lists.add(new TwoParameterBean("2018.5.30", "语文、数学、英语"));

        lv_history_choose.setAdapter(new ChooseSubjectItemAdapter(ChooseSubjectActivityMy.this,lists));
    }


    boolean itemIs;

    @OnClick({R.id.wuli, R.id.huaxue, R.id.dili, R.id.zhengzhi, R.id.shengwu, R.id.shuxue})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.wuli:
                if (!itemIs) {
                    List<ThreeParameterBean> myList = new ArrayList<>();
                    myList.add(new ThreeParameterBean("https://ss0.baidu.com/6ONWsjip0QIZ8tyhnq/it/u=1967972454,1621682239&fm=58&bpow=496&bpoh=799", "萧炎", "资质卓绝，四岁练气，十岁拥有九段斗之气，十一岁成功凝聚斗之气旋，一跃成为家族百年之内最年轻的斗者。十二岁成为斗者却又连续三年功力倒退保持在斗之气三段，从此逐渐沦为遭人白眼的废柴。原因是名为药尘的八品巅峰炼药宗师的魂魄在母亲的遗物古戒中吸收他的斗气，在药尘停止吸收斗气后终于天赋重展，在药尘的帮助下一年时间突破斗者，震惊全城，后又在药尘的教导下，成为加玛帝国黑岩城最年轻的二品炼药师，凭借执着与信念闯荡大陆，不断取得辉煌的战绩。"));
                    myList.add(new ThreeParameterBean("https://ss1.baidu.com/6ONXsjip0QIZ8tyhnq/it/u=2476474363,1910627444&fm=58&bpow=1200&bpoh=1920", "萧薰儿", "萧薰儿，原名古薰儿。天蚕土豆所著异世大陆类玄幻小说《斗破苍穹》女主角之一，《武动乾坤》以及《大主宰》当中客串出场。为古族千金，天之骄女，古族近千年内斗帝血脉觉醒最完美者。拥有异火榜排名第四的金帝焚天炎，后转赠萧炎。"));
                    showDialog(myList, wuli, ChooseSubjectActivityMy.this);
                } else {
                    wuli.setImageResource(R.drawable.test);
                    itemIs = false;
                }
                break;
            case R.id.huaxue:
                if (!itemIs) {
                    List<ThreeParameterBean> myList = new ArrayList<>();
                    myList.add(new ThreeParameterBean("https://ss0.baidu.com/6ONWsjip0QIZ8tyhnq/it/u=1967972454,1621682239&fm=58&bpow=496&bpoh=799", "萧炎", "资质卓绝，四岁练气，十岁拥有九段斗之气，十一岁成功凝聚斗之气旋，一跃成为家族百年之内最年轻的斗者。十二岁成为斗者却又连续三年功力倒退保持在斗之气三段，从此逐渐沦为遭人白眼的废柴。原因是名为药尘的八品巅峰炼药宗师的魂魄在母亲的遗物古戒中吸收他的斗气，在药尘停止吸收斗气后终于天赋重展，在药尘的帮助下一年时间突破斗者，震惊全城，后又在药尘的教导下，成为加玛帝国黑岩城最年轻的二品炼药师，凭借执着与信念闯荡大陆，不断取得辉煌的战绩。"));
                    myList.add(new ThreeParameterBean("https://ss1.baidu.com/6ONXsjip0QIZ8tyhnq/it/u=2476474363,1910627444&fm=58&bpow=1200&bpoh=1920", "萧薰儿", "萧薰儿，原名古薰儿。天蚕土豆所著异世大陆类玄幻小说《斗破苍穹》女主角之一，《武动乾坤》以及《大主宰》当中客串出场。为古族千金，天之骄女，古族近千年内斗帝血脉觉醒最完美者。拥有异火榜排名第四的金帝焚天炎，后转赠萧炎。"));
                    showDialog(myList, huaxue, ChooseSubjectActivityMy.this);
                } else {
                    huaxue.setImageResource(R.drawable.test);
                    itemIs = false;
                }
                break;
            case R.id.dili:
                if (!itemIs) {
                    List<ThreeParameterBean> myList = new ArrayList<>();
                    myList.add(new ThreeParameterBean("https://ss0.baidu.com/6ONWsjip0QIZ8tyhnq/it/u=1967972454,1621682239&fm=58&bpow=496&bpoh=799", "萧炎", "资质卓绝，四岁练气，十岁拥有九段斗之气，十一岁成功凝聚斗之气旋，一跃成为家族百年之内最年轻的斗者。十二岁成为斗者却又连续三年功力倒退保持在斗之气三段，从此逐渐沦为遭人白眼的废柴。原因是名为药尘的八品巅峰炼药宗师的魂魄在母亲的遗物古戒中吸收他的斗气，在药尘停止吸收斗气后终于天赋重展，在药尘的帮助下一年时间突破斗者，震惊全城，后又在药尘的教导下，成为加玛帝国黑岩城最年轻的二品炼药师，凭借执着与信念闯荡大陆，不断取得辉煌的战绩。"));
                    myList.add(new ThreeParameterBean("https://ss1.baidu.com/6ONXsjip0QIZ8tyhnq/it/u=2476474363,1910627444&fm=58&bpow=1200&bpoh=1920", "萧薰儿", "萧薰儿，原名古薰儿。天蚕土豆所著异世大陆类玄幻小说《斗破苍穹》女主角之一，《武动乾坤》以及《大主宰》当中客串出场。为古族千金，天之骄女，古族近千年内斗帝血脉觉醒最完美者。拥有异火榜排名第四的金帝焚天炎，后转赠萧炎。"));
                    showDialog(myList, dili, ChooseSubjectActivityMy.this);
                } else {
                    dili.setImageResource(R.drawable.test);
                    itemIs = false;
                }
                break;
            case R.id.zhengzhi:
                if (!itemIs) {
                    List<ThreeParameterBean> myList = new ArrayList<>();
                    myList.add(new ThreeParameterBean("https://ss0.baidu.com/6ONWsjip0QIZ8tyhnq/it/u=1967972454,1621682239&fm=58&bpow=496&bpoh=799", "萧炎", "资质卓绝，四岁练气，十岁拥有九段斗之气，十一岁成功凝聚斗之气旋，一跃成为家族百年之内最年轻的斗者。十二岁成为斗者却又连续三年功力倒退保持在斗之气三段，从此逐渐沦为遭人白眼的废柴。原因是名为药尘的八品巅峰炼药宗师的魂魄在母亲的遗物古戒中吸收他的斗气，在药尘停止吸收斗气后终于天赋重展，在药尘的帮助下一年时间突破斗者，震惊全城，后又在药尘的教导下，成为加玛帝国黑岩城最年轻的二品炼药师，凭借执着与信念闯荡大陆，不断取得辉煌的战绩。"));
                    myList.add(new ThreeParameterBean("https://ss1.baidu.com/6ONXsjip0QIZ8tyhnq/it/u=2476474363,1910627444&fm=58&bpow=1200&bpoh=1920", "萧薰儿", "萧薰儿，原名古薰儿。天蚕土豆所著异世大陆类玄幻小说《斗破苍穹》女主角之一，《武动乾坤》以及《大主宰》当中客串出场。为古族千金，天之骄女，古族近千年内斗帝血脉觉醒最完美者。拥有异火榜排名第四的金帝焚天炎，后转赠萧炎。"));
                    showDialog(myList, zhengzhi, ChooseSubjectActivityMy.this);
                } else {
                    zhengzhi.setImageResource(R.drawable.test);
                    itemIs = false;
                }
                break;
            case R.id.shengwu:
                if (!itemIs) {
                    List<ThreeParameterBean> myList = new ArrayList<>();
                    myList.add(new ThreeParameterBean("https://ss0.baidu.com/6ONWsjip0QIZ8tyhnq/it/u=1967972454,1621682239&fm=58&bpow=496&bpoh=799", "萧炎", "资质卓绝，四岁练气，十岁拥有九段斗之气，十一岁成功凝聚斗之气旋，一跃成为家族百年之内最年轻的斗者。十二岁成为斗者却又连续三年功力倒退保持在斗之气三段，从此逐渐沦为遭人白眼的废柴。原因是名为药尘的八品巅峰炼药宗师的魂魄在母亲的遗物古戒中吸收他的斗气，在药尘停止吸收斗气后终于天赋重展，在药尘的帮助下一年时间突破斗者，震惊全城，后又在药尘的教导下，成为加玛帝国黑岩城最年轻的二品炼药师，凭借执着与信念闯荡大陆，不断取得辉煌的战绩。"));
                    myList.add(new ThreeParameterBean("https://ss1.baidu.com/6ONXsjip0QIZ8tyhnq/it/u=2476474363,1910627444&fm=58&bpow=1200&bpoh=1920", "萧薰儿", "萧薰儿，原名古薰儿。天蚕土豆所著异世大陆类玄幻小说《斗破苍穹》女主角之一，《武动乾坤》以及《大主宰》当中客串出场。为古族千金，天之骄女，古族近千年内斗帝血脉觉醒最完美者。拥有异火榜排名第四的金帝焚天炎，后转赠萧炎。"));
                    showDialog(myList, shengwu, ChooseSubjectActivityMy.this);
                } else {
                    shengwu.setImageResource(R.drawable.test);
                    itemIs = false;
                }
                break;
            case R.id.shuxue:
                if (!itemIs) {
                    List<ThreeParameterBean> myList = new ArrayList<>();
                    myList.add(new ThreeParameterBean("https://ss0.baidu.com/6ONWsjip0QIZ8tyhnq/it/u=1967972454,1621682239&fm=58&bpow=496&bpoh=799", "萧炎", "资质卓绝，四岁练气，十岁拥有九段斗之气，十一岁成功凝聚斗之气旋，一跃成为家族百年之内最年轻的斗者。十二岁成为斗者却又连续三年功力倒退保持在斗之气三段，从此逐渐沦为遭人白眼的废柴。原因是名为药尘的八品巅峰炼药宗师的魂魄在母亲的遗物古戒中吸收他的斗气，在药尘停止吸收斗气后终于天赋重展，在药尘的帮助下一年时间突破斗者，震惊全城，后又在药尘的教导下，成为加玛帝国黑岩城最年轻的二品炼药师，凭借执着与信念闯荡大陆，不断取得辉煌的战绩。"));
                    myList.add(new ThreeParameterBean("https://ss1.baidu.com/6ONXsjip0QIZ8tyhnq/it/u=2476474363,1910627444&fm=58&bpow=1200&bpoh=1920", "萧薰儿", "萧薰儿，原名古薰儿。天蚕土豆所著异世大陆类玄幻小说《斗破苍穹》女主角之一，《武动乾坤》以及《大主宰》当中客串出场。为古族千金，天之骄女，古族近千年内斗帝血脉觉醒最完美者。拥有异火榜排名第四的金帝焚天炎，后转赠萧炎。"));
                    showDialog(myList, shuxue, ChooseSubjectActivityMy.this);
                } else {
                    shuxue.setImageResource(R.drawable.test);
                    itemIs = false;
                }
                break;
        }
    }

    boolean isClick = false;
    public static int item_grid_num = 2;//每一页中GridView中item的数量
    public static int number_columns = 2;//gridview一行展示的数目
    private VerticalViewPager view_pager;
    private pagerAdapter mAdapter;
    private List<ThreeParameterBean> dataList;
    private List<GridView> gridList = new ArrayList<>();


    public void showDialog(final List<ThreeParameterBean> list, final CircleImageView clickView, Context context) {
        final Dialog dl = new Dialog(context, R.style.Chooesdialog);
        View layout = LayoutInflater.from(context).inflate(R.layout.dialog_choosesub, null, false);

        dl.addContentView(layout, new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT
                , LinearLayout.LayoutParams.WRAP_CONTENT));
        dl.setContentView(layout);
        ImageView cha = layout.findViewById(R.id.cha);
        TextView ok = layout.findViewById(R.id.tv_ok);
        GridView gv = layout.findViewById(R.id.gv);
        //初始化viewpager
        view_pager = layout.findViewById(R.id.viewpager);
        mAdapter = new pagerAdapter();
        view_pager.setAdapter(mAdapter);
        dataList = new ArrayList<>();//数据源
        //------初始化数据---------
        initDatas();
        WindowManager windowManager = getWindowManager();
        Display display = windowManager.getDefaultDisplay();
        final WindowManager.LayoutParams params = dl.getWindow().getAttributes();
        params.width = display.getWidth() - 50;
        dl.getWindow().setAttributes(params);

        cha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dl.dismiss();
            }
        });

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemIs = true;
                dl.dismiss();
                clickView.setImageResource(R.drawable.sel);
            }
        });


        dl.show();

    }

    private void initDatas() {
        if (dataList.size() > 0) {
            dataList.clear();
        }
        if (gridList.size() > 0) {
            gridList.clear();
        }
        //初始化数据
        dataList.add(new ThreeParameterBean("https://ss0.baidu.com/6ONWsjip0QIZ8tyhnq/it/u=1967972454,1621682239&fm=58&bpow=496&bpoh=799", "萧炎", "资质卓绝，四岁练气，十岁拥有九段斗之气，十一岁成功凝聚斗之气旋，一跃成为家族百年之内最年轻的斗者。十二岁成为斗者却又连续三年功力倒退保持在斗之气三段，从此逐渐沦为遭人白眼的废柴。原因是名为药尘的八品巅峰炼药宗师的魂魄在母亲的遗物古戒中吸收他的斗气，在药尘停止吸收斗气后终于天赋重展，在药尘的帮助下一年时间突破斗者，震惊全城，后又在药尘的教导下，成为加玛帝国黑岩城最年轻的二品炼药师，凭借执着与信念闯荡大陆，不断取得辉煌的战绩。"));
        dataList.add(new ThreeParameterBean("https://ss1.baidu.com/6ONXsjip0QIZ8tyhnq/it/u=2476474363,1910627444&fm=58&bpow=1200&bpoh=1920", "萧薰儿", "萧薰儿，原名古薰儿。天蚕土豆所著异世大陆类玄幻小说《斗破苍穹》女主角之一，《武动乾坤》以及《大主宰》当中客串出场。为古族千金，天之骄女，古族近千年内斗帝血脉觉醒最完美者。拥有异火榜排名第四的金帝焚天炎，后转赠萧炎。"));
        dataList.add(new ThreeParameterBean("https://ss0.baidu.com/6ONWsjip0QIZ8tyhnq/it/u=1967972454,1621682239&fm=58&bpow=496&bpoh=799", "药老", "资质卓绝，四岁练气，十岁拥有九段斗之气，十一岁成功凝聚斗之气旋，一跃成为家族百年之内最年轻的斗者。十二岁成为斗者却又连续三年功力倒退保持在斗之气三段，从此逐渐沦为遭人白眼的废柴。原因是名为药尘的八品巅峰炼药宗师的魂魄在母亲的遗物古戒中吸收他的斗气，在药尘停止吸收斗气后终于天赋重展，在药尘的帮助下一年时间突破斗者，震惊全城，后又在药尘的教导下，成为加玛帝国黑岩城最年轻的二品炼药师，凭借执着与信念闯荡大陆，不断取得辉煌的战绩。"));
        dataList.add(new ThreeParameterBean("https://ss1.baidu.com/6ONXsjip0QIZ8tyhnq/it/u=2476474363,1910627444&fm=58&bpow=1200&bpoh=1920", "纳兰嫣然", "萧薰儿，原名古薰儿。天蚕土豆所著异世大陆类玄幻小说《斗破苍穹》女主角之一，《武动乾坤》以及《大主宰》当中客串出场。为古族千金，天之骄女，古族近千年内斗帝血脉觉醒最完美者。拥有异火榜排名第四的金帝焚天炎，后转赠萧炎。"));
        dataList.add(new ThreeParameterBean("https://ss1.baidu.com/6ONXsjip0QIZ8tyhnq/it/u=2476474363,1910627444&fm=58&bpow=1200&bpoh=1920", "小医仙", "小医仙，原名古薰儿。天蚕土豆所著异世大陆类玄幻小说《斗破苍穹》女主角之一，《武动乾坤》以及《大主宰》当中客串出场。为古族千金，天之骄女，古族近千年内斗帝血脉觉醒最完美者。拥有异火榜排名第四的金帝焚天炎，后转赠萧炎。"));
        dataList.add(new ThreeParameterBean("https://ss1.baidu.com/6ONXsjip0QIZ8tyhnq/it/u=2476474363,1910627444&fm=58&bpow=1200&bpoh=1920", "萧厉", "萧厉，原名古薰儿。天蚕土豆所著异世大陆类玄幻小说《斗破苍穹》女主角之一，《武动乾坤》以及《大主宰》当中客串出场。为古族千金，天之骄女，古族近千年内斗帝血脉觉醒最完美者。拥有异火榜排名第四的金帝焚天炎，后转赠萧炎。"));
        dataList.add(new ThreeParameterBean("https://ss1.baidu.com/6ONXsjip0QIZ8tyhnq/it/u=2476474363,1910627444&fm=58&bpow=1200&bpoh=1920", "萧厉", "萧厉，原名古薰儿。天蚕土豆所著异世大陆类玄幻小说《斗破苍穹》女主角之一，《武动乾坤》以及《大主宰》当中客串出场。为古族千金，天之骄女，古族近千年内斗帝血脉觉醒最完美者。拥有异火榜排名第四的金帝焚天炎，后转赠萧炎。"));
        //计算viewpager一共显示几页
        int pageSize = dataList.size() % item_grid_num == 0
                ? dataList.size() / item_grid_num
                : dataList.size() / item_grid_num + 1;
        for (int i = 0; i < pageSize; i++) {
            final GridView gridView = new GridView(this);
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

    /**
     * 过气的不用 占地方
     * grideview的adapter
     */
    class itemAdapter extends BaseAdapter {

        List<ThreeParameterBean> lists;
        Context mContext;

        public itemAdapter(List<ThreeParameterBean> lists, Context mContext) {
            this.lists = lists;
            this.mContext = mContext;
        }

        @Override
        public int getCount() {
            return lists.size();
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            final ViewHolder holder;
            if (convertView == null) {
                holder = new ViewHolder();
                convertView = LayoutInflater.from(mContext).inflate(R.layout.choose_dialog_item, null, false);
                holder.icon = convertView.findViewById(R.id.icon);
                holder.ll = convertView.findViewById(R.id.ll);
                holder.name = convertView.findViewById(R.id.name);
                holder.comment = convertView.findViewById(R.id.comment);

                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }

            Glide.with(mContext).load(lists.get(position).getName() == "" ? R.drawable.test : lists.get(position).getName()).into(holder.icon);

            holder.name.setText(lists.get(position).getContent());
            holder.comment.setText(lists.get(position).getTime());
            return convertView;
        }


        class ViewHolder {
            LinearLayout ll;
            CircleImageView icon;
            TextView name;
            TextView comment;

        }
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
}
