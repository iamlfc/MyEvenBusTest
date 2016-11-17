package com.example.lfc.myevenbustest;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;


public class MainActivity extends AppCompatActivity {
    private TextView tvMsg;
    private Button btn01;

    private TextView tvSdisok;
    private TextView tvSdpath;
    private TextView tvSdfreeroom;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

// TODO: 2016/11/11  第一步  注册
        EventBus.getDefault().register(this);

        initView();
    }

    private void initView() {


        tvSdisok = (TextView) findViewById(R.id.tv_sdisok);
        tvSdpath = (TextView) findViewById(R.id.tv_sdpath);
        tvSdfreeroom = (TextView) findViewById(R.id.tv_sdfreeroom);


        tvMsg = (TextView) findViewById(R.id.tv_msg);
        btn01 = (Button) findViewById(R.id.btn_01);
        btn01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(MainActivity.this, Main2Activity.class));
            }
        });
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(MsgEvent event) {
    /* Do something */

        String str_msg = event.getStr_data();


        Log.d("--lfc", "我胡汉三又回来了！");
        tvMsg.setTextColor(Color.RED);
        tvMsg.setText("这TM的就成了？" + "\n" + str_msg);

        btn01.setText("再点我就打你哦！");

        String string = "";
        if (SDCardUtils.isMounted()) {
            string = "经判定，该SD卡可放心使用";
        } else {
            string = "这SD卡有毒，不能使用啊";

        }
        tvSdisok.setText(string);
        tvSdpath.setText(SDCardUtils.getSDCardPath());
        tvSdfreeroom.setText("SD卡的总大小" + SDCardUtils.getSDTotalSize(MainActivity.this)
                + "\n SD卡可用大小" + SDCardUtils.getSDAvailableSize(MainActivity.this)
                + "\n  测试看看大小 " + SDCardUtils.getSDCardSize(MainActivity.this));
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();

        // TODO: 2016/11/11     反注册
        EventBus.getDefault().unregister(this);
    }
}
