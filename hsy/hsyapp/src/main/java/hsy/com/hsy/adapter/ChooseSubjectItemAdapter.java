package hsy.com.hsy.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import hsy.com.hsy.R;
import hsy.com.hsy.bean.TwoParameterBean;

/**
 * 历史选课内容的adapter
 */
public class ChooseSubjectItemAdapter extends BaseAdapter {

   Context mContext;
   List<TwoParameterBean> list;

    public ChooseSubjectItemAdapter(Context mContext, List<TwoParameterBean> list) {
        this.mContext = mContext;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
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
        ViewHolder holder;
        if (convertView==null){
            holder = new ViewHolder();
            convertView = LayoutInflater.from(mContext).inflate(R.layout.history_choose_item,null,false);
            holder.name = convertView.findViewById(R.id.time);
            holder.content = convertView.findViewById(R.id.content);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.name.setText(list.get(position).getName());
        holder.content.setText(list.get(position).getContent());

        return convertView;
    }
    class ViewHolder{
        TextView name;
        TextView content;
    }
}
