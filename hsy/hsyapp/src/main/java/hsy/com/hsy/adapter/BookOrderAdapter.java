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

public class BookOrderAdapter extends BaseAdapter {

    Context mConext;
    List<String> icons;
    List<String> names;
    List<String> lend_situtions;
    List<String> versons;

    public BookOrderAdapter(Context mConext, List<String> icons, List<String> names, List<String> lend_situtions, List<String> versons) {
        this.mConext = mConext;
        this.icons = icons;
        this.names = names;
        this.lend_situtions = lend_situtions;
        this.versons = versons;
    }


    private OnItemClickListener mOnItemClickListener;

    @Override
    public int getCount() {
        return icons.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder=null;
        if (convertView==null){
            holder = new ViewHolder();
            convertView = LayoutInflater.from(mConext).inflate(R.layout.book_order_item, null, false);
            holder.icon = (ImageView) convertView.findViewById(R.id.iv_icon);
            holder.name = (TextView) convertView.findViewById(R.id.name);
            holder.lendSituaioin = (TextView) convertView.findViewById(R.id.lend_situation);
            holder.verson = (TextView) convertView.findViewById(R.id.verson);
            convertView.setTag(holder);
        }else{
           holder = (ViewHolder) convertView.getTag();
        }

        RequestOptions options = new RequestOptions();
        options.placeholder(R.drawable.test);
        Glide.with(mConext).load(icons.get(position))
                .apply(options)
                .into(holder.icon);
        holder.name.setText(names.get(position));
        holder.lendSituaioin.setText(lend_situtions.get(position));
        holder.verson.setText(versons.get(position));

        if( mOnItemClickListener!= null&&holder.lendSituaioin.getText().equals("预约")){
            holder.lendSituaioin.setOnClickListener( new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mOnItemClickListener.onClick(position);
                }
            });
        }else if (mOnItemClickListener!= null&&holder.lendSituaioin.getText().equals("已借出")){
            holder.lendSituaioin.setTextColor(mConext.getResources().getColor(R.color.gary_font));
            holder.lendSituaioin.setBackgroundResource(R.drawable.bg_order_gray);
        }
        return convertView;
    }

    public interface OnItemClickListener{
        void onClick( int position);
    }
    public void setOnItemClickListener(OnItemClickListener onItemClickListener ){
        this. mOnItemClickListener=onItemClickListener;
    }


    public class ViewHolder {
        ImageView icon;
        TextView name;
        TextView lendSituaioin;
        TextView verson;

    }



}
