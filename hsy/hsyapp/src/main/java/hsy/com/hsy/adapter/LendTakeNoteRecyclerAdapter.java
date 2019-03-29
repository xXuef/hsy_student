package hsy.com.hsy.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import hsy.com.hsy.R;

public class LendTakeNoteRecyclerAdapter extends RecyclerView.Adapter<LendTakeNoteRecyclerAdapter.ViewHolder> {

    Context mContext;
    List<String> bookNames;
    List<String> bookVersons;
    List<String> bookShouldBackTime;
    List<String> bookIconUrls;
    List<String> timeNums;


    public LendTakeNoteRecyclerAdapter(Context mContext, List<String> bookIconUrls, List<String> bookNames, List<String> bookVersons, List<String> bookShouldBackTime,List<String> timeNums) {
        this.mContext = mContext;
        this.bookIconUrls = bookIconUrls;
        this.bookNames = bookNames;
        this.bookVersons = bookVersons;
        this.bookShouldBackTime = bookShouldBackTime;
        this.timeNums = timeNums;
    }


    class ViewHolder extends RecyclerView.ViewHolder {
        TextView bookName;
        TextView bookVerson;
        TextView shouleBackTime;
        TextView coutiueLend;
        TextView timeNum;

        public ViewHolder(View view) {
            super(view);
            bookName = (TextView) view.findViewById(R.id.bookname);
            bookVerson = (TextView) view.findViewById(R.id.verson);
            shouleBackTime = view.findViewById(R.id.should_backtime);
            coutiueLend = view.findViewById(R.id.continue_lend);
            timeNum =view.findViewById(R.id.time_num);
        }
    }


    @Override
    public int getItemCount() {
        return bookIconUrls.size();
    }

    @Override
    public LendTakeNoteRecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.book_info_lendnotes, null, false);

        ViewHolder holder = new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(LendTakeNoteRecyclerAdapter.ViewHolder holder, int position) {
//        RequestOptions options = new RequestOptions();
//        options.placeholder(R.drawable.test);
//        Glide.with(mContext).load(bookIconUrls.get(position))
//                .apply(options).into(holder.bookIcon);

        holder.bookName.setText(bookNames.get(position));
        holder.bookVerson.setText(bookVersons.get(position));
        holder.shouleBackTime.setText(bookShouldBackTime.get(position));
        holder.timeNum.setText(timeNums.get(position));

    }


}
