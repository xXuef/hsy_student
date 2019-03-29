package com.example.mytestmvp;

import android.os.AsyncTask;
import android.os.SystemClock;
import android.util.Log;

public class Presenter implements IFPresenter {

    private IFIsShowView isShowView;

    public Presenter(IFIsShowView isShowView) {
        this.isShowView = isShowView;
    }

    @Override
    public void show() {
        new AsyncTask<Void, Void, Void>() {

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                Log.d("joy99", "下载完成。");
                isShowView.show("Hello,MVP!");
            }

            @Override
            protected Void doInBackground(Void... params) {
                for (int i = 0; i < 3; i++) {
                    Log.d("joy99", "正在下载...预计剩余时间 " + (10 - i) + "秒");
                    SystemClock.sleep(1000);
                }
                return null;
            }
        }.execute();
    }
}
