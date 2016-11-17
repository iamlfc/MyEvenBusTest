package com.example.lfc.myevenbustest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.lfc.myevenbustest.demo2.Main4Activity;


public class Main2Activity extends AppCompatActivity {
    private Button btnTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        initView();
    }

    private void initView() {


        btnTest = (Button) findViewById(R.id.btn_test);
        btnTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {


                startActivity(new Intent(Main2Activity.this, Main4Activity.class));
//                EventBus.getDefault().post(new MsgEvent("我就他妈的日了狗了！"));
//                finish();


//                ACTION_SOUND_SETTINGS
// 应用列表
//                Intent intent = new Intent(Settings.ACTION_MANAGE_ALL_APPLICATIONS_SETTINGS);
//                startActivity(intent);

//                27. ACTION_SOUND_SETTINGS // 跳转到声音设置界面
//                Intent intent = new Intent(Settings.ACTION_SOUND_SETTINGS);
//                startActivity(intent);


//                通讯录
//                Intent i = new Intent(Intent.ACTION_PICK);
//                i.setType("vnd.android.cursor.dir/phone");
//                startActivityForResult(i, 0);


//                6. ACTION_INTERNAL_STORAGE_SETTINGS // 跳转存储设置界面【内部存储】

//                Intent intent = new Intent(Settings.ACTION_INTERNAL_STORAGE_SETTINGS);
//                startActivity(intent);
//                或者：

//                ACTION_MEMORY_CARD_SETTINGS ： // 跳转 存储设置 【记忆卡存储】
//
//                Intent intent = new Intent(Settings.ACTION_MEMORY_CARD_SETTINGS);
//                startActivity(intent);


                // TODO: 2016/11/14   跳转文件管理器页面
//
//                final int REQUEST_CODE_SELECT_IMAGE = 1;
//                Intent openAlbumIntent = new Intent(Intent.ACTION_GET_CONTENT);
//                openAlbumIntent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "file/*");
////                openAlbumIntent.setDataAndType(MediaStore.Files.getContentUri(), "file/*");
//                startActivityForResult(openAlbumIntent, REQUEST_CODE_SELECT_IMAGE);


            }
        });

    }
}
