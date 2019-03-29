package hsy.com.hsy.activity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;

import java.util.ArrayList;
import java.util.List;

import hsy.com.hsy.R;
import hsy.com.hsy.base.MyBaseActivity;
import hsy.com.hsy.util.ToastUtils;

/**
 * 我要反馈界面
 */
public class CoupleBackActivityMy extends MyBaseActivity {


    private ImageView addIv;
    private ImageView imageView1;
    private ImageView imageView2;
    private TextView commit_ok;
    private GridView gv;
    List<Bitmap> bitmaps = new ArrayList<>();
    private myadapter adapter;
    private LinearLayout iv_ll;

    @Override
    public void initVariable() {
        setContentView(R.layout.activity_couple_back);
        tool_title.setText("我要反馈");
        addIv = (ImageView) findViewById(R.id.add_iv);

        imageView1 = (ImageView) findViewById(R.id.iv_1);
        imageView2 = (ImageView) findViewById(R.id.iv_2);
        imageView1.setVisibility(View.GONE);
        imageView2.setVisibility(View.GONE);
        commit_ok = (TextView) findViewById(R.id.commit_ok);

        //跟发送动态同步 直接将之前的布局gone  避免删除代码之后出现空指针
        iv_ll = findViewById(R.id.iv_ll);
        iv_ll.setVisibility(View.GONE);

        gv = findViewById(R.id.gv);
        adapter = new myadapter(bitmaps, this);
        BitmapDrawable drawable = (BitmapDrawable) getResources().getDrawable(R.drawable.add);
        Bitmap bitmap = drawable.getBitmap();
        adapter.addData(bitmap);
        gv.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }

    @Override
    public void toLoad(Bundle savedInstanceState) {

        commit_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtils.showShort("提交");
            }
        });

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
//                    if (selectList.size() == 1) {
//                        LocalMedia media1 = selectList.get(0);
//                        Drawable drawable1 = Drawable.createFromPath(media1.getPath());
//                        imageView1.setImageDrawable(drawable1);
//                        imageView1.setVisibility(View.VISIBLE);
//                    } else if (selectList.size() >= 2) {
//                        LocalMedia media1 = selectList.get(0);
//                        Drawable drawable1 = Drawable.createFromPath(media1.getPath());
//                        imageView1.setImageDrawable(drawable1);
//                        imageView1.setVisibility(View.VISIBLE);
//                        LocalMedia media2 = selectList.get(1);
//                        Drawable drawable2 = Drawable.createFromPath(media2.getPath());
//                        imageView2.setImageDrawable(drawable2);
//                        imageView2.setVisibility(View.VISIBLE);
//                    }

                    for (LocalMedia s : selectList) {
                        String cutPath = s.getPath();
                        Bitmap bitmap = BitmapFactory.decodeFile(cutPath);
                        bitmaps.add(bitmap);
                    }

                    BitmapDrawable drawable = (BitmapDrawable) getResources().getDrawable(R.drawable.add);
                    Bitmap bitmap = drawable.getBitmap();
                    adapter.addData(bitmap);
                    adapter.setData(bitmaps);
                    adapter.notifyDataSetChanged();

                    break;
            }
        }
    }



    class myadapter extends BaseAdapter {

        List<Bitmap> imageViews;
        Context mContext;

        public myadapter(List<Bitmap> imageViews,Context mContext) {
            this.imageViews = imageViews;
            this.mContext = mContext;
        }

        public void setData(List<Bitmap> lists) {
            this.imageViews = lists;
        }

        private void addData(Bitmap iv) {
            imageViews.add(iv);
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
            layoutParams.height =width/6;
            layoutParams.width=width/6;
            holder.iv.setLayoutParams(layoutParams);
            if (position==imageViews.size()-1){
                holder.iv.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //点击最后一个条目清除
                        imageViews.clear();
                        PictureSelector.create(CoupleBackActivityMy.this)
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
        }
    }
}
