package hsy.com.hsy.activity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.gyf.barlibrary.ImmersionBar;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;

import java.util.ArrayList;
import java.util.List;

import hsy.com.hsy.R;

/**
 * 发布动态
 */
public class SendPlayActivity extends AppCompatActivity implements View.OnClickListener {

    private GridView gv;
    List<Bitmap> bitmaps = new ArrayList<>();
    private myadapter adapter;
    private TextView tv_send;
    private GridView gridView;
    private EditText editText;
    private Bitmap bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send__play_);

        ImmersionBar.with(this).statusBarColor(R.color.stabar_color).fitsSystemWindows(true).init();

        TextView tv_end = (TextView) findViewById(R.id.end);
        tv_send = (TextView) findViewById(R.id.send);
        gridView = findViewById(R.id.ll);
        editText = findViewById(R.id.ed);

        gv = findViewById(R.id.ll);
        tv_end.setOnClickListener(this);
        tv_send.setOnClickListener(this);

        adapter = new myadapter(bitmaps, this);
        BitmapDrawable drawable = (BitmapDrawable) getResources().getDrawable(R.drawable.add);
        Bitmap bitmap = drawable.getBitmap();
        adapter.addData(bitmap);
        gv.setAdapter(adapter);
        adapter.notifyDataSetChanged();

//        //adater本身就有一个条目
//        if (editText.getText().length()>0||adapter.getCount()>1){
//            tv_send.setTextColor(getResources().getColor(R.color.blue_god));
//        }
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.length() > 0) {
                    tv_send.setTextColor(getResources().getColor(R.color.blue));
                } else {
                    tv_send.setTextColor(getResources().getColor(R.color.white));
                }
            }
        });
        if (adapter.getCount() > 1) {
            tv_send.setTextColor(getResources().getColor(R.color.blue));
        } else {
            tv_send.setTextColor(getResources().getColor(R.color.white));
        }

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
//        if (event.getAction()==)
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.end:
                finish();
                break;
            case R.id.send:

                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case PictureConfig.CHOOSE_REQUEST:
                    // 图片、视频、音频选择结果回调
                    List<LocalMedia> selectList = PictureSelector.obtainMultipleResult(data);
                    // 例如 LocalMedia 里面返回三种path
                    // 1.media.getPath(); 为原图path
                    // 2.media.getCutPath();为裁剪后path，需判断media.isCut();是否为true  注意：音视频除外
                    // 3.media.getCompressPath();为压缩后path，需判断media.isCompressed();是否为true  注意：音视频除外
                    // 如果裁剪并压缩了，以取压缩路径为准，因为是先裁剪后压缩的

                    for (LocalMedia s : selectList) {
                        String cutPath = s.getPath();
                        Bitmap bitmap = BitmapFactory.decodeFile(cutPath);
                        bitmaps.add(bitmap);
                    }

                    BitmapDrawable drawable = (BitmapDrawable) getResources().getDrawable(R.drawable.add);
                    bitmap = drawable.getBitmap();
                    if (bitmaps.size()!=0) {
                        adapter.setData(bitmaps);
                    }
                    adapter.addData(bitmap);
                    adapter.notifyDataSetChanged();

                    break;
            }
        }
    }

    class myadapter extends BaseAdapter {

        List<Bitmap> imageViews;
        Context mContext;

        public myadapter(List<Bitmap> imageViews, Context mContext) {
            this.imageViews = imageViews;
            this.mContext = mContext;
        }

        public void setData(List<Bitmap> lists) {
            this.imageViews = lists;
        }

        private void addData(Bitmap iv) {
            imageViews.add(iv);
        }

        private void removeData(Bitmap iv) {
            imageViews.remove(iv);
        }


        @Override
        public int getCount() {
            return imageViews.size();
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
            ViewHolder holder;
            if (convertView == null) {
                holder = new ViewHolder();
                convertView = LayoutInflater.from(mContext).inflate(R.layout.choess_imagview, null, false);
                holder.iv = convertView.findViewById(R.id.iv);
                holder.close = convertView.findViewById(R.id.cha);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            //获取屏幕的宽度
            Resources resources = mContext.getResources();
            DisplayMetrics dm = resources.getDisplayMetrics();
            int width = dm.widthPixels;

            holder.iv.setImageBitmap(imageViews.get(position));
            ViewGroup.LayoutParams layoutParams = holder.iv.getLayoutParams();
            layoutParams.height = width / 6;
            layoutParams.width = width / 6;
            holder.iv.setLayoutParams(layoutParams);
            if (position == imageViews.size() - 1) {
                holder.iv.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //点击最后一个条目清楚
                        imageViews.clear();
                        PictureSelector.create(SendPlayActivity.this)
                                .openGallery(PictureMimeType.ofAll())
                                .isCamera(true)// 是否显示拍照按钮 true or false
                                .selectionMode(PictureConfig.MULTIPLE)
                                .maxSelectNum(3)
                                .minSelectNum(0)
                                .previewImage(true)//可否预览图片
                                .enableCrop(false)// 是否裁剪 true or false
                                .forResult(PictureConfig.CHOOSE_REQUEST);
                    }
                });
            }
            return convertView;
        }

        class ViewHolder {
            ImageView iv;
            ImageView close;
        }
    }
}
