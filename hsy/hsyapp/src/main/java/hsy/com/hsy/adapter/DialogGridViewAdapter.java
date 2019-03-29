package hsy.com.hsy.adapter;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import hsy.com.hsy.R;
import hsy.com.hsy.activity.QualityEvaluation;
import hsy.com.hsy.bean.ThreeParameterBean;

public class DialogGridViewAdapter extends BaseAdapter {


    private List<ThreeParameterBean> dataList;
    boolean isClick = false;
    boolean isElse = false;
    int selectPosition;
    Context mContext;

    public DialogGridViewAdapter(List<ThreeParameterBean> datas, int page, Context context) {
        dataList = new ArrayList<>();
        //start end分别代表要显示的数组在总数据List中的开始和结束位置
        int start = page * QualityEvaluation.item_grid_num;
        int end = start + QualityEvaluation.item_grid_num;
        while ((start < datas.size()) && (start < end)) {
            dataList.add(datas.get(start));
            start++;
        }
        this.mContext =context;
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
            mHolder.tvGone = (TextView) itemView.findViewById(R.id.tvGone);
            mHolder.ll = itemView.findViewById(R.id.ll);
            itemView.setTag(mHolder);
        } else {
            mHolder = (ViewHolder) itemView.getTag();
        }
        ThreeParameterBean bean = dataList.get(position);
        if (bean != null) {
            Glide.with(mContext).load(bean.getName()).into(mHolder.iv_img);

            mHolder.name.setText(bean.getContent());
            mHolder.content.setText(bean.getTime());
        }

        if (selectPosition==position){
            mHolder.ll.setBackgroundResource(R.drawable.iem_bg);

            //这里有一个看不见的textview用来存放数值当然 也不用这么弄
            mHolder.tvGone.setText(mHolder.name.getText().toString());
            notifyDataSetChanged();
        }else {
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
        private TextView tvGone;
        LinearLayout ll;
    }

}
