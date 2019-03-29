package hsy.com.hsy.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

import hsy.com.hsy.R;

/**
 * Created by Administrator on 2018/4/21.
 */

public class SchoolItemAdapter extends BaseAdapter {

    Context mContent;
    int count;
    List<String> school_icon;
    List<String> school_name;
    List<String> school_of;
    List<String> school_type;
    List<String> hots;
    List<String> national_ranking;

    public SchoolItemAdapter(Context mContent, int count, List<String> icon, List<String> school_name, List<String> school_of, List<String> school_type, List<String> hots, List<String> national_ranking) {
        this.mContent = mContent;
        this.count = count;
        this.school_icon = icon;
        this.school_name = school_name;
        this.school_of = school_of;
        this.school_type = school_type;
        this.hots = hots;
        this.national_ranking = national_ranking;
    }

    @Override
    public int getCount() {
        return count;
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
            convertView = LayoutInflater.from(mContent).inflate(R.layout.school_item, null, false);
            holder.schoolIcon = convertView.findViewById(R.id.iv_schoolicon);
            holder.schoolName = convertView.findViewById(R.id.tv_schoolname);
            holder.schoolOf = convertView.findViewById(R.id.tv_schoolof);
            holder.schoolType = convertView.findViewById(R.id.tv_schooltype);
            holder.schoolHot = convertView.findViewById(R.id.tv_schoolhot);
            holder.schoolRanking = convertView.findViewById(R.id.tv_schoolranking);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        RequestOptions options = new RequestOptions();
        options.placeholder(R.drawable.test);
        Glide.with(mContent)
                .load(school_icon.get(position))
                .apply(options)
                .into(holder.schoolIcon);

        holder.schoolName.setText(school_name.get(position) + "");
        holder.schoolOf.setText(school_of.get(position) + "");
        holder.schoolType.setText(school_type.get(position) + "");
        holder.schoolHot.setText(hots.get(position) + "");
        holder.schoolRanking.setText(national_ranking.get(position) + "");
        return convertView;
    }

    class ViewHolder {


        ImageView schoolIcon;
        TextView schoolName;
        TextView schoolOf;
        TextView schoolType;
        TextView schoolHot;
        TextView schoolRanking;
    }
}
