package hsy.com.hsy.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import hsy.com.hsy.R;
import hsy.com.hsy.bean.ThreeParameterBean;

public class TableAdapter extends BaseAdapter {

    List<ThreeParameterBean> lists;
    Context mContext;

    public TableAdapter(List<ThreeParameterBean> lists, Context mContext) {
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
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = LayoutInflater.from(mContext).inflate(R.layout.table_item, null, false);
            holder.name = convertView.findViewById(R.id.name);
            holder.content = convertView.findViewById(R.id.content);
            holder.time = convertView.findViewById(R.id.time);
            holder.view = convertView.findViewById(R.id.view);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        if (position == 0) {
            holder.view.setVisibility(View.VISIBLE);
            holder.name.setTextSize(16);
            holder.content.setTextSize(16);
            holder.time.setTextSize(16);
            holder.name.setBackgroundColor(Color.parseColor("#E4F0FB"));
            holder.content.setBackgroundColor(Color.parseColor("#E4F0FB"));
            holder.time.setBackgroundColor(Color.parseColor("#E4F0FB"));
        }
        holder.name.setText(lists.get(position).getName());
        holder.content.setText(lists.get(position).getContent());
        holder.time.setText(lists.get(position).getTime());
        return convertView;
    }

    class ViewHolder {
        TextView name;
        TextView content;
        TextView time;
        View view;
    }
}
