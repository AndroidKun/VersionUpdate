package com.androidkun.versionupdatedemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.androidkun.versionupdate.VersionUpdateService;

public class MainActivity extends AppCompatActivity {

    private String url = "http://file.popcap.com.cn/pvz2_android/pvz2_android_HD.apk";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = (Button) findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                VersionUpdateService.beginUpdate(MainActivity.this,"Demo",url,R.mipmap.icon,"com.androidkun.versionupdatedemo.Main2Activity");
            }
        });

      }
}
