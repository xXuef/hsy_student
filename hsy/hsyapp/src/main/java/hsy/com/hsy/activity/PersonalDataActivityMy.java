package hsy.com.hsy.activity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import hsy.com.hsy.R;
import hsy.com.hsy.base.MyBaseActivity;

/**
 * 修改头像界面
 */
public class PersonalDataActivityMy extends MyBaseActivity {


    private CircleImageView student_icon;

    @Override
    public void initVariable() {
        setContentView(R.layout.activity_personal_data);
        tool_title.setText("个人信息");

        LinearLayout change_iv = (LinearLayout) findViewById(R.id.change_iv);
        student_icon = (CircleImageView) findViewById(R.id.student_icon);


        change_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PictureSelector.create(PersonalDataActivityMy.this)
                        .openGallery(PictureMimeType.ofAll())
                        .isCamera(true)// 是否显示拍照按钮 true or false
                        .selectionMode(PictureConfig.SINGLE)
                        .previewImage(true)//可否预览图片
                        .enableCrop(true)// 是否裁剪 true or false
                        .withAspectRatio(1,1)// int 裁剪比例
                        .forResult(PictureConfig.CHOOSE_REQUEST);

            }
        });
    }

    @Override
    public void toLoad(Bundle savedInstanceState) {

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
                    LocalMedia media = selectList.get(0);
                    Drawable drawable = Drawable.createFromPath(media.getPath());
                    student_icon.setImageDrawable(drawable);
                    break;
            }
        }
    }

}
