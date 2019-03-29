package hsy.com.hsy.base;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import hsy.com.hsy.util.SharePreUtil;


/**
 * basefragment
 */
public abstract class BaseFragment extends Fragment {
    private Context context;

    protected void click(String appId){
        if ("10001".equals(appId)) {
            Toast.makeText(getContext(), "第1个应用", Toast.LENGTH_SHORT).show();
        }else if ("10002".equals(appId)) {
            Toast.makeText(getContext(), "第2个应用", Toast.LENGTH_SHORT).show();
        }else if ("10003".equals(appId)) {
            Toast.makeText(getContext(), "第3个应用", Toast.LENGTH_SHORT).show();
        }
        else if ("10004".equals(appId)) {
            Toast.makeText(getContext(), "第4个应用", Toast.LENGTH_SHORT).show();
        }
        else if ("10005".equals(appId)) {
            Toast.makeText(getContext(), "第5个应用", Toast.LENGTH_SHORT).show();
        }
        else if ("10006".equals(appId)) {
            Toast.makeText(getContext(), "第6个应用", Toast.LENGTH_SHORT).show();
        }
        else if ("10007".equals(appId)) {
            Toast.makeText(getContext(), "第7个应用", Toast.LENGTH_SHORT).show();
        }
        else if ("10008".equals(appId)) {
            Toast.makeText(getContext(), "第8个应用", Toast.LENGTH_SHORT).show();
        }
        else if ("10009".equals(appId)) {
            Toast.makeText(getContext(), "第9个应用", Toast.LENGTH_SHORT).show();
        }
    }
    /**
     * SharedPreferences
     */
    protected SharePreUtil sp;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutId(), container, false);
        context = getActivity();
        sp = new SharePreUtil(context);
        initParams(view,savedInstanceState);

        return view;
    }
    /**
     * 初始化布局
     *
     * @author blue
     */
    protected abstract int getLayoutId();

    /**
     * 参数设置
     *
     * @author blue
     */
    protected abstract void initParams(View view, Bundle savedInstanceState);

}
