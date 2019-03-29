package hsy.com.hsy.fragment;

import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.bin.david.form.core.SmartTable;
import com.bin.david.form.data.CellInfo;
import com.bin.david.form.data.column.Column;
import com.bin.david.form.data.format.bg.ICellBackgroundFormat;
import com.bin.david.form.data.table.TableData;
import com.bin.david.form.listener.OnColumnItemClickListener;

import java.util.ArrayList;
import java.util.List;

import hsy.com.hsy.R;
import hsy.com.hsy.activity.SpecialtyDirectionActivity;
import hsy.com.hsy.base.BaseFragment;
import hsy.com.hsy.bean.table.SpecialtyTable;
import hsy.com.hsy.util.ToastUtils;

/**
 * Created by Administrator on 2018/4/21.
 */

public class Fg_School_Ben extends BaseFragment {

    private EditText et_school;
    private ImageView iv_search;

    @Override
    protected int getLayoutId() {
        return R.layout.fg_school_ben;
    }

    @Override
    protected void initParams(View view, Bundle savedInstanceState) {

        SmartTable table = view.findViewById(R.id.table);
        et_school = view.findViewById(R.id.et_school);
        iv_search = view.findViewById(R.id.iv_search);

        //处理edittext的变化
        initEditText();
        List<Column> list = new ArrayList<>();
        List<SpecialtyTable> specialtyTables = new ArrayList<>();
        Column<String> studyType = new Column<>("学科类别", "studyType");
        //设置单元格合并
        studyType.setAutoMerge(true);
        Column<String> subjectType = new Column<>("专业类别", "subjectType");
        subjectType.setAutoMerge(true);
        Column<String> subjectName = new Column<>("专业名称", "subjectName");
        Column<String> detailed = new Column<>("详细", "detailed");

        list.add(studyType);
        list.add(subjectType);
        list.add(subjectName);
        list.add(detailed);

        specialtyTables.add(new SpecialtyTable("哲学01", "哲学类", "哲学", "点击查看"));
        specialtyTables.add(new SpecialtyTable("哲学01", "哲学类", "逻辑学", "点击查看"));
        specialtyTables.add(new SpecialtyTable("哲学01", "哲学类", "宗教学", "点击查看"));
        specialtyTables.add(new SpecialtyTable("哲学01", "哲学类", "伦理学", "点击查看"));
        specialtyTables.add(new SpecialtyTable("经济学02", "经济学类", "经济学", "点击查看"));
        specialtyTables.add(new SpecialtyTable("经济学02", "经济学类", "资源与环境经济学", "点击查看"));
        specialtyTables.add(new SpecialtyTable("经济学02", "经济学类", "国民经济管理", "点击查看"));
        specialtyTables.add(new SpecialtyTable("经济学02", "经济学类", "体育经济", "点击查看"));
        specialtyTables.add(new SpecialtyTable("经济学02", "经济学类", "商务经济学", "点击查看"));
        specialtyTables.add(new SpecialtyTable("经济学02", "经济学类", "能源经济", "点击查看"));

        TableData<SpecialtyTable> tableData = new TableData<>("", specialtyTables, list);

        //取消表格的xy的索引值
        table.getConfig().setShowXSequence(false);
        table.getConfig().setShowYSequence(false);
        //字体大小
        table.getConfig().getContentStyle().setTextSpSize(getContext(), 18);
        //设置列里面的文字颜色
        table.getConfig().setContentCellBackgroundFormat(new ICellBackgroundFormat<CellInfo>() {
            @Override
            public void drawBackground(Canvas canvas, Rect rect, CellInfo cellInfo, Paint paint) {

            }

            @Override
            public int getTextColor(CellInfo cellInfo) {

                if (cellInfo.column.getColumnName().equals("详细")) {
                    return ContextCompat.getColor(getContext(), R.color.blue_god);
                }
                return 0;
            }
        });

        table.setTableData(tableData);
//        table.notifyDataChanged();

        //表格列的点击事件
        detailed.setOnColumnItemClickListener(new OnColumnItemClickListener<String>() {
            @Override
            public void onClick(Column<String> column, String value, String s, int position) {

                ToastUtils.showShort("第" + position + "条");
                Intent intent = new Intent(getContext(), SpecialtyDirectionActivity.class);
                startActivity(intent);
            }
        });

    }

    /**
     * Description:监听edittext的变化
     * Data: 2018/6/9 17:37
     */
    private void initEditText() {
        et_school.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                //编辑框内容变化之前会调用该方法，s为编辑框内容变化之前的内容
                Log.i("beforeTextChanged", s.toString());
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //只要编辑框内容有变化就会调用该方法，s为编辑框变化后的内容
                Log.i("onTextChanged", s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
                //编辑框内容变化之后会调用该方法，s为编辑框内容变化后的内容
                Log.i("afterTextChanged", s.toString());
                if (s.length()>0){
                    iv_search.setVisibility(View.INVISIBLE);
                }else {
                    iv_search.setVisibility(View.VISIBLE);
                }

            }
        });
    }
}
