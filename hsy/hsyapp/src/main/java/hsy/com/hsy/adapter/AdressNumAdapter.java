package hsy.com.hsy.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import hsy.com.hsy.R;
import hsy.com.hsy.util.ToastUtils;

public class AdressNumAdapter extends RecyclerView.Adapter<AdressNumAdapter.ViewHolder> {

    Context mContext;
    List<String> phoneIcons;
    List<String> phoneNames;
    List<String> phoneClass;
    List<String> profession;

    public AdressNumAdapter(Context mContext, List<String> phoneIcons, List<String> phoneNames, List<String> phoneClass, List<String> profession) {
        this.mContext = mContext;
        this.phoneIcons = phoneIcons;
        this.phoneNames = phoneNames;
        this.phoneClass = phoneClass;
        this.profession = profession;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CircleImageView phone_icon;
        TextView phone_name;
        TextView phone_class;
        TextView profession;
        ImageView phone_call;

        public ViewHolder(View view) {
            super(view);
            phone_icon = (CircleImageView) view.findViewById(R.id.phone_icon);
            phone_name = (TextView) view.findViewById(R.id.phone_name);
            phone_class = (TextView) view.findViewById(R.id.phone_class);
            profession = (TextView) view.findViewById(R.id.profession);
            phone_call = (ImageView) view.findViewById(R.id.call);
        }
    }

    @Override
    public int getItemCount() {
        return phoneIcons.size();
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.phonenumitem, null, false);
        ViewHolder holder = new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        RequestOptions options = new RequestOptions();
        options.placeholder(R.drawable.test);
        Glide.with(mContext)
                .load(phoneIcons.get(position))
                .apply(options)
                .into(holder.phone_icon);
        holder.phone_name.setText(phoneNames.get(position));
        holder.phone_class.setText(phoneClass.get(position));
        holder.phone_call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtils.showShort("拨打电话");

                //用intent启动拨打电话
                Intent intent = new Intent(Intent.ACTION_CALL,Uri.parse("tel:"+"11111"));
//                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                mContext.startActivity(intent);

            }
        });

        if (profession == null || profession.get(position).equals(null) ||  profession.get(position).equals("")) {
            holder.profession.setVisibility(View.INVISIBLE);
        } else {
            holder.profession.setText(profession.get(position));
        }
    }


}
