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

import de.hdodenhof.circleimageview.CircleImageView;
import hsy.com.hsy.R;

public class ClassTrendsAdapter extends BaseAdapter {

    Context mContext;
    int listItemtCount;

    List<String> userIcon;
    List<String> userNmae;
    List<String> userDimsion;
    List<String> userTime;
    List<String> otherUserComment;

    public ClassTrendsAdapter(Context mContext, int listItemtCount, List<String> userIcon, List<String> userNmae, List<String> userDimsion, List<String> userTime, List<String> otherUserComment) {
        this.mContext = mContext;
        this.listItemtCount = listItemtCount;
        this.userIcon = userIcon;
        this.userNmae = userNmae;
        this.userDimsion = userDimsion;
        this.userTime = userTime;
        this.otherUserComment = otherUserComment;
    }

    @Override
    public int getCount() {
        return listItemtCount;
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
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_class_trends, null, false);
            holder.userIcon = (CircleImageView) convertView.findViewById(R.id.item_usericon);
            holder.username = (TextView) convertView.findViewById(R.id.item_username);
            holder.userCommentContent = (TextView) convertView.findViewById(R.id.item_dimension);
            holder.userCommentTime = (TextView) convertView.findViewById(R.id.item_time);
            holder.userCommentImageview = (ImageView) convertView.findViewById(R.id.item_comment_iv);
            holder.otheruserCommentContent = (TextView) convertView.findViewById(R.id.item_otheruser_comment);

            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }

        RequestOptions options = new RequestOptions();
        options.placeholder(R.drawable.baitu);
        Glide.with(mContext).load(userIcon.get(position))
                .apply(options)
                .into(holder.userIcon);
        holder.username.setText(userNmae.get(position));
        holder.userCommentContent.setText(userDimsion.get(position));
        holder.userCommentTime.setText(userTime.get(position));
        holder.otheruserCommentContent.setText(otherUserComment.get(position));

        return convertView;
    }

    class ViewHolder {
        CircleImageView userIcon;
        TextView username;
        TextView userCommentContent;
        TextView userCommentTime;
        ImageView userCommentImageview;
        TextView otheruserCommentContent;

    }
}
