package hsy.com.hsy.adapter.fuctioin;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import hsy.com.hsy.R;
import hsy.com.hsy.bean.AppInfo;
import hsy.com.hsy.fragment.FunctionFragment;

public class HomeAddappAdapter extends BaseAdapter{
	
	private Context context;
	private List<AppInfo> list;
	private List<Boolean> mChecked;
	private boolean flag;
	public static Map<Integer, Boolean> isSelected; 
	HashMap<Integer,View> map = new HashMap<Integer,View>();


	public HomeAddappAdapter(Context context) {
		this.context=context;
	}
	
	public void setData(List<AppInfo> list){
		this.list=list;
		mChecked = new ArrayList<Boolean>();  
        for(int i=0;i<list.size();i++){  
            mChecked.add(false);  
        }
		notifyDataSetChanged();
	}

	@Override
	public int getCount() {
		if(list==null){
			return 0;
		}
		return list.size();
	}

	@Override
	public Object getItem(int position) {
		if(list==null){
			return null;
		}
		return list.get(position);
	}

	@Override
	public long getItemId(int position) {
		
		return position;
	}

	@Override
	public View getView(final int position, View convertView, ViewGroup viewGroup) {
		final AppInfo appInfo=list.get(position);
		final Holder holder;
		if(convertView==null){
			holder=new Holder();
			convertView=LayoutInflater.from(context).inflate(R.layout.home_add_app_item, null);
			holder.app_icon=(ImageView) convertView.findViewById(R.id.home_add_app_item_icon);
			holder.app_name=(TextView) convertView.findViewById(R.id.home_add_app_item_name);
			holder.check_state=(CheckBox) convertView.findViewById(R.id.home_add_app_item_checkbox);
			holder.layout=(RelativeLayout) convertView.findViewById(R.id.home_add_app_item_layout);
			map.put(position, convertView);
			convertView.setTag(holder);
		}else{

			holder=(Holder) convertView.getTag();
		}
		holder.app_icon.setImageDrawable(context.getResources().getDrawable(appInfo.getIcon()));
		holder.app_name.setText(appInfo.getAppName());
		holder.check_state.setChecked(appInfo.isState());
		
		holder.layout.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if(appInfo.isState()){
					appInfo.setState(false);
					holder.check_state.setChecked(false);
					FunctionFragment.addAppInfos.remove(appInfo);
				}else{
					if(FunctionFragment.addAppInfos.size() < 13){
						appInfo.setState(true);
						holder.check_state.setChecked(true);
						FunctionFragment.addAppInfos.addFirst(appInfo);
					}else{
						Toast.makeText(context, "不能添加更多应用到主页", Toast.LENGTH_SHORT).show();
					}
				}
			}
		});
		
		return convertView;
	}
	
	class Holder{
		private ImageView app_icon;
		private TextView app_name;
		public CheckBox check_state;
		private RelativeLayout layout;
	}

}
