package com.kingbirad.mylibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.kingbirdle.advertistingjar.view.AdvertistingView;
import com.socks.library.KLog;

import java.util.Objects;

/**
 * @author 86185
 */
public class MainActivity extends AppCompatActivity {

    private AdvertistingView mView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 去标题
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_main);
        mView = findViewById(R.id.View);
        KLog.e("包名：" + this.getPackageName());
        try {
            mView.initAdvertising(this);
        } catch (Exception e) {
            KLog.e("异常信息：" + e.toString());
        }

        mView.setAppPackageName(this.getPackageName());
        String path = mView.getQrCodePath();
        KLog.e("二维码路径：" + path);
        KLog.e("设备ID：" + mView.getDeviceId());
        KLog.e("获取经度：" + mView.getLongitude());
        KLog.e("获取纬度：" + mView.getLatitude());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        KLog.e("销毁");
        mView.stop();
    }

    public void stop(View view) {
        mView.videoStop();
    }

    public void pause(View view) {
        mView.videoPause();
    }

    public void start(View view) {
        mView.videoStart();
    }
}
