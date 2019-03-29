package hsy.com.hsy.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import hsy.com.hsy.R;

public class NotifyItemAdapter extends BaseAdapter {
    Context mContext;
    int mCount;
    List<String> names;
    List<String> importants;
    List<String> times;
    List<String> contents;

    public NotifyItemAdapter(Context mContext, int mCount, List<String> names, List<String> importants, List<String> times, List<String> contents) {
        this.mContext = mContext;
        this.mCount = mCount;
        this.names = names;
        this.importants = importants;
        this.times = times;
        this.contents = contents;
    }

    @Override
    public int getCount() {
        return mCount;
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
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_notifyinschool, null);
            holder.item_title = (TextView) convertView.findViewById(R.id.tv_title);
            holder.item_importantof = (TextView) convertView.findViewById(R.id.tv_improtant);
            holder.item_time = (TextView) convertView.findViewById(R.id.tv_time);
            holder.item_content = (TextView) convertView.findViewById(R.id.tv_content);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.item_title.setText(names.get(position));
        holder.item_importantof.setText(importants.get(position));
        holder.item_time.setText(times.get(position));
        holder.item_content.setText(contents.get(position));

        if (holder.item_importantof.getText().equals("重要")){
            holder.item_importantof.setTextColor(mContext.getResources().getColor(R.color.blue_god));
            holder.item_importantof.setBackgroundResource(R.drawable.bg_notify_blue);
        }else if (holder.item_importantof.getText().equals("紧急")){
            holder.item_importantof.setTextColor(mContext.getResources().getColor(R.color.red));
            holder.item_importantof.setBackgroundResource(R.drawable.bg_notify_red);
        }else if (holder.item_importantof.getText().equals("普通")){
            holder.item_importantof.setTextColor(mContext.getResources().getColor(R.color.gary_font));
            holder.item_importantof.setBackgroundResource(R.drawable.bg_notify_normal);
        }
        return convertView;

    }

    class ViewHolder {
        TextView item_title;
        TextView item_importantof;
        TextView item_time;
        TextView item_content;
    }
}
