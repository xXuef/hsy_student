package hsy.com.hsy.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import hsy.com.hsy.R;

public class ApprocalAdapter extends BaseAdapter {
    public ApprocalAdapter(Context context, int counts, List<String> imageViews, List<String> names, List<String> questions, List<String> states) {
        this.context = context;
        this.counts = counts;
        this.imageViews = imageViews;
        this.names = names;
        this.questions = questions;
        this.states = states;
    }

    Context context;
    int counts;
    List<String> imageViews;
    List<String> names;
    List<String> questions;
    List<String> states;

    @Override
    public int getCount() {
        return counts;
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
            convertView = LayoutInflater.from(context).inflate(R.layout.item_approval, null, false);

            holder.circleImageView = convertView.findViewById(R.id.cirimage);
            holder.name = convertView.findViewById(R.id.name);
            holder.question = convertView.findViewById(R.id.question);
            holder.state = convertView.findViewById(R.id.state);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.circleImageView.setImageResource(R.drawable.test);
        holder.name.setText(names.get(position));
        holder.question.setText(questions.get(position));
        holder.state.setText(states.get(position));

        return convertView;
    }

    class ViewHolder {
        CircleImageView circleImageView;
        TextView name;
        TextView question;
        TextView state;
    }

}
