package hsy.com.hsy.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import hsy.com.hsy.R;
import hsy.com.hsy.adapter.LibrartBookInfoAdapter;
import hsy.com.hsy.base.MyBaseActivity;
import hsy.com.hsy.view.HorizontalListView;

/**
 * 图书馆
 */
public class LibraryActivityMy extends MyBaseActivity {

    @BindView(R.id.book_no_back)
    TextView bookNoBack;
    @BindView(R.id.book_look_time)
    TextView bookLookTime;
    @BindView(R.id.book_recommend)
    HorizontalListView bookRecommend;
    @BindView(R.id.book_look_recently)
    HorizontalListView bookLookRecently;
    @BindView(R.id.takenotes)
    TextView takenotes;
    @BindView(R.id.order)
    TextView order;

    List<String> iconOne;
    List<String> iconOnes;
    List<String> bookName;
    List<String> bookNames;
    List<String> bookVerson;
    List<String> bookVersons;

    @Override
    public void initVariable() {
        setContentView(R.layout.activity_library);
        ButterKnife.bind(this);
        tool_title.setText("图书馆");
        initData();
    }
    private HorizontalListView mHlvCustomListWithDividerAndFadingEdge;
    @Override
    public void toLoad(Bundle savedInstanceState) {

        bookNoBack.setText("《列夫·托尔斯泰》");
        bookLookTime.setText("10小时");
        LibrartBookInfoAdapter adapter = new LibrartBookInfoAdapter(this, iconOnes, bookNames, bookVersons);
        bookRecommend.setAdapter(adapter);

        bookRecommend.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                ToastUtils.showShort(""+position);
            }
        });

//        ShowAllListDataUtill.setListViewHeightBasedOnChildren(bookRecommend);


        bookLookRecently.setAdapter(new LibrartBookInfoAdapter(this, iconOne, bookName, bookVerson));
    }


    private void initData() {

        iconOnes = new ArrayList<>();
        bookNames = new ArrayList<>();
        bookVersons = new ArrayList<>();
        for (int i = 0; i <3 ; i++) {
            iconOnes.add("123");
            iconOnes.add("123");
            bookNames.add("当代北京故宫史话");
            bookNames.add("中国百年实录");
            bookVersons.add("作者: 郭京宁");
            bookVersons.add("作者: 徐宪江");
        }



        iconOne = new ArrayList<>();
        iconOne.add("122");
        bookName = new ArrayList<>();
        bookName.add("安娜卡列尼娜");
        bookVerson = new ArrayList<>();
        bookVerson.add("作者: 列夫·托尔斯泰");

    }


    @OnClick({R.id.takenotes, R.id.order})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.takenotes:

                startActivity(new Intent(this, BookLendTakeNoteActivityMy.class));

                break;
            case R.id.order:
                startActivity(new Intent(this, BookOrderActivityMy.class));

                break;
        }
    }
}
