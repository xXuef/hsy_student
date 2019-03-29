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

public class LibrartBookInfoAdapter extends BaseAdapter {

    Context mContext;
    List<String> bookIcons;
    List<String> bookNames;
    List<String> bookVersons;

    public LibrartBookInfoAdapter(Context mContext, List<String> bookIcons, List<String> bookNames, List<String> bookVersons) {
        this.mContext = mContext;
        this.bookIcons = bookIcons;
        this.bookNames = bookNames;
        this.bookVersons = bookVersons;
    }

    @Override
    public int getCount() {
        return bookIcons.size();
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
            convertView = LayoutInflater.from(mContext).inflate(R.layout.book_info, null, false);
            holder.bookIcon = (ImageView) convertView.findViewById(R.id.book_icon);
            holder.bookName = (TextView) convertView.findViewById(R.id.bookname);
            holder.bookVerson = (TextView) convertView.findViewById(R.id.verson);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        RequestOptions options = new RequestOptions();
        options.placeholder(R.drawable.test);
        Glide.with(mContext).load(bookIcons.get(position))
                .apply(options).into(holder.bookIcon);
        holder.bookName.setText(bookNames.get(position));
        holder.bookVerson.setText(bookVersons.get(position));

        return convertView;
    }

    class ViewHolder {
        ImageView bookIcon;
        TextView bookName;
        TextView bookVerson;
    }
}
