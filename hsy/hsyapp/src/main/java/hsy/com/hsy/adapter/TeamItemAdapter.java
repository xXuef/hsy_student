package hsy.com.hsy.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import hsy.com.hsy.R;
import hsy.com.hsy.util.ToastUtils;

public class TeamItemAdapter extends BaseAdapter {

    Context mContext;
    List<String> iconUrl;
    List<String> names;
    List<String> numPeople;
    List<String> createTime;

    public TeamItemAdapter(Context mContext, List<String> iconUrl, List<String> names, List<String> numPeople, List<String> createTime) {
        this.mContext = mContext;
        this.iconUrl = iconUrl;
        this.names = names;
        this.numPeople = numPeople;
        this.createTime = createTime;
    }

    @Override
    public int getCount() {
        return names.size();
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
            convertView = LayoutInflater.from(mContext).inflate(R.layout.team_item, null, false);
            holder.icon =(CircleImageView) convertView.findViewById(R.id.iv_icon);
            holder.name = (TextView)convertView.findViewById(R.id.name);
            holder.num_people = (TextView)convertView.findViewById(R.id.num_people);
            holder.create_time = (TextView)convertView.findViewById(R.id.create_time);
            holder.join=(TextView) convertView.findViewById(R.id.join);

            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }

        RequestOptions options = new RequestOptions();
        options.placeholder(R.drawable.test);
        Glide.with(mContext).load(iconUrl.get(position)).apply(options).into(holder.icon);

        holder.name.setText(names.get(position));
        holder.num_people.setText(numPeople.get(position));
        holder.create_time.setText(createTime.get(position));
        holder.join.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtils.showShort("申请加入");
            }
        });

        return convertView;
    }

    class ViewHolder {
        CircleImageView icon;
        TextView name;
        TextView num_people;
        TextView create_time;
        TextView join;
    }
}
