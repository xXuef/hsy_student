package hsy.com.hsy.fragment;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import hsy.com.hsy.R;
import hsy.com.hsy.base.BaseFragment;
import hsy.com.hsy.util.ToastUtils;

public class Fg_AdressSchool extends BaseFragment implements View.OnClickListener {


    private ListView lv;
    private PopupWindow mPopWindow;

    @Override
    protected int getLayoutId() {
        return R.layout.school_adress;
    }

    @Override
    protected void initParams(View view, Bundle savedInstanceState) {

        lv = (ListView) view.findViewById(R.id.lv_school_phone);
        final List<String> strings = new ArrayList<>();
        strings.add("政教处");
        strings.add("教务处");
        strings.add("行政处");
        lv.setAdapter(new BaseAdapter() {

            @Override
            public int getCount() {
                return strings.size();
            }

            @Override
            public Object getItem(int position) {
                return position;
            }

            @Override
            public long getItemId(int position) {
                return position;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                ViewHolder holder = null;
                if (holder == null) {
                    holder = new ViewHolder();
                    convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_school_adress, null, false);
                    holder.tv_text = convertView.findViewById(R.id.tv_text);
                    holder.iv_call = convertView.findViewById(R.id.iv_call);

                    convertView.setTag(holder);
                } else {
                    holder = (ViewHolder) convertView.getTag();
                }

                holder.tv_text.setText(strings.get(position));
                holder.iv_call.setImageResource(R.drawable.iphoneblue);
                holder.iv_call.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        showPopupWindow(v);
                    }
                });

                return convertView;
            }

            class ViewHolder {

                TextView tv_text;
                ImageView iv_call;
            }

        });


    }

    private void showPopupWindow(View view) {

        View contentView = LayoutInflater.from(getContext()).inflate(R.layout.call_school_popu, null);
        mPopWindow = new PopupWindow(contentView);
        mPopWindow.setWidth(LinearLayout.LayoutParams.WRAP_CONTENT);
        mPopWindow.setHeight(LinearLayout.LayoutParams.WRAP_CONTENT);

        LinearLayout tv1 = (LinearLayout) contentView.findViewById(R.id.one);
        LinearLayout tv2 = (LinearLayout) contentView.findViewById(R.id.two);
        tv1.setOnClickListener(this);
        tv2.setOnClickListener(this);
        mPopWindow.setBackgroundDrawable(new ColorDrawable(0x00000000));
        mPopWindow.setOutsideTouchable(true);
        mPopWindow.setFocusable(true);
        mPopWindow.showAsDropDown(view);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.one:
                ToastUtils.showShort("教导处主任正的");
                mPopWindow.dismiss();
                break;
            case R.id.two:
                ToastUtils.showShort("教导处主任副的");
                mPopWindow.dismiss();
                break;
        }
    }
}
