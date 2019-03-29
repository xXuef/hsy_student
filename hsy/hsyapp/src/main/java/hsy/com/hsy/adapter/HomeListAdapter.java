package hsy.com.hsy.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import hsy.com.hsy.R;

/**
 * Created by Administrator on 2018/4/23.
 */

public class HomeListAdapter extends BaseAdapter {

    List<String> title_name;
    List<String> title_time;
    List<String> userIcon;
    List<String> content;
    Boolean isVisibility;
    Boolean isShowUserIcon;
    List<String> imagViews;
    List<String> content_commit;
    Context mContext;

    public HomeListAdapter(List<String> title_name, List<String> title_time, List<String> content, Boolean isShowUserIcon, List<String> userIcon, Boolean isVisibility, List<String> imagViews, List<String> content_commit, Context mContext) {
        this.userIcon = userIcon;
        this.isShowUserIcon = isShowUserIcon;
        this.title_name = title_name;
        this.title_time = title_time;
        this.content = content;
        this.isVisibility = isVisibility;
        this.imagViews = imagViews;
        this.content_commit = content_commit;
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return title_name.size();
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
            convertView = LayoutInflater.from(mContext).inflate(R.layout.school_inside_state, null);
            holder.name = convertView.findViewById(R.id.item_name);
            holder.item_time = convertView.findViewById(R.id.item_time);
            holder.item_content = convertView.findViewById(R.id.item_content);
            holder.itemiv1 = convertView.findViewById(R.id.iv_1);
            holder.itemiv2 = convertView.findViewById(R.id.iv_2);
            holder.itemiv3 = convertView.findViewById(R.id.iv_3);
            holder.itemiv4 = convertView.findViewById(R.id.iv_4);
            holder.commit_imagview = convertView.findViewById(R.id.information);
            holder.commit_content = convertView.findViewById(R.id.comment_content);
            holder.imagview_add = convertView.findViewById(R.id.imagview_add);
            holder.userIv = convertView.findViewById(R.id.userIv);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        RequestOptions options = new RequestOptions();
        options.placeholder(R.drawable.test);
        if (isShowUserIcon) {
            holder.userIv.setVisibility(View.VISIBLE);
            Glide.with(mContext)
                    .load(userIcon.get(position))
                    .apply(options)
                    .into(holder.itemiv1);
        } else {
            holder.userIv.setVisibility(View.GONE);
        }
        holder.name.setText(title_name.get(position) + "");
        holder.item_time.setText(title_time.get(position) + "");
        holder.item_content.setText(content.get(position) + "");


        if (imagViews == null) {
            holder.imagview_add.setVisibility(View.GONE);
        } else {
            //四个或者少于四个图片的url String
            if (imagViews.get(position) != null) {
                String s = imagViews.get(position);
                Log.e("切割字符", s);
//                String replace = s.replace("\"", "");

                if (s.contains("##")) {
                    String[] split = s.split("##");
                    if (split.length == 1) {
                        Log.e("切割数组", "1" + new String(String.valueOf(split)).toString());
                        holder.imagview_add.setVisibility(View.VISIBLE);
                        holder.itemiv1.setVisibility(View.VISIBLE);
                        Glide.with(mContext)
                                .load(split[0])
                                .apply(options)
                                .into(holder.itemiv1);
                    } else if (split.length == 2) {
                        Log.e("切割数组", "2" + new String(String.valueOf(split)).toString());
                        Glide.with(mContext)
                                .load(split[0])
                                .apply(options)
                                .into(holder.itemiv1);
                        Glide.with(mContext)
                                .load(split[1])
                                .apply(options)
                                .into(holder.itemiv2);
                        holder.imagview_add.setVisibility(View.VISIBLE);
                        holder.itemiv1.setVisibility(View.VISIBLE);
                        holder.itemiv2.setVisibility(View.VISIBLE);
                    } else if (split.length == 3) {
                        Log.e("切割数组", "3" + new String(String.valueOf(split)).toString());
                        Glide.with(mContext)
                                .load(split[0])
                                .apply(options)
                                .into(holder.itemiv1);
                        Glide.with(mContext)
                                .load(split[1])
                                .apply(options)
                                .into(holder.itemiv2);
                        Glide.with(mContext)
                                .load(split[2])
                                .apply(options)
                                .into(holder.itemiv3);
                        holder.imagview_add.setVisibility(View.VISIBLE);
                        holder.itemiv1.setVisibility(View.VISIBLE);
                        holder.itemiv2.setVisibility(View.VISIBLE);
                        holder.itemiv3.setVisibility(View.VISIBLE);
                    } else if (split.length >= 4) {
                        Log.e("切割数组", "4" + new String(String.valueOf(split)).toString());
                        Glide.with(mContext)
                                .load(split[0])
                                .apply(options)
                                .into(holder.itemiv1);
                        Glide.with(mContext)
                                .load(split[1])
                                .apply(options)
                                .into(holder.itemiv2);
                        Glide.with(mContext)
                                .load(split[2])
                                .apply(options)
                                .into(holder.itemiv3);
                        Glide.with(mContext)
                                .load(split[3])
                                .apply(options)
                                .into(holder.itemiv4);
                        holder.imagview_add.setVisibility(View.VISIBLE);
                        holder.itemiv1.setVisibility(View.VISIBLE);
                        holder.itemiv2.setVisibility(View.VISIBLE);
                        holder.itemiv3.setVisibility(View.VISIBLE);
                        holder.itemiv4.setVisibility(View.VISIBLE);
                    }
                } else {
                    if (s.equals("null")) {
                        holder.imagview_add.setVisibility(View.GONE);
                    } else {
                        Log.e("切割数组", "单条URL" + s);
                        holder.imagview_add.setVisibility(View.VISIBLE);
                        holder.itemiv1.setVisibility(View.VISIBLE);
                        Glide.with(mContext)
                                .load(s)
                                .apply(options)
                                .into(holder.itemiv1);
                        holder.imagview_add.setVisibility(View.VISIBLE);
                        holder.itemiv1.setVisibility(View.VISIBLE);
                    }
                }
            }
        }


        if (isVisibility) {
            holder.commit_imagview.setVisibility(View.VISIBLE);
            if (content_commit != null) {
                holder.commit_content.setVisibility(View.VISIBLE);
                holder.commit_content.setText(content_commit.get(position));
            }
        }
        return convertView;
    }

    public final class ViewHolder {
        public TextView name;
        public TextView item_time;
        public TextView item_content;

        public LinearLayout imagview_add;
        public ImageView itemiv1;
        public ImageView itemiv2;
        public ImageView itemiv3;
        public ImageView itemiv4;
        public CircleImageView userIv;

        public ImageView commit_imagview;
        public TextView commit_content;

    }
}
