package com.example.lfc.myevenbustest.demo2;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.lfc.myevenbustest.R;

public class Main4Activity extends AppCompatActivity {
//    private TuneWheel tune;
    private TextView tvMsg;
    private Button btnSub;
    private Button btnAdd;

    private RadioRuler radioview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);


        initView();
    }

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
//            tvMsg.setText(radioview.getValue() + "星系");
        }


    };

    private void initView() {

        radioview = (RadioRuler) findViewById(R.id.radioview);

        btnSub = (Button) findViewById(R.id.btn_sub);
        btnAdd = (Button) findViewById(R.id.btn_add);
        radioview.setScrollListener(new RadioRuler.ScrollListener() {
            @Override
            public void onScroll() {

            }

            @Override
            public void onScrollEnd(float freq)
            {
                handler.sendEmptyMessage(1);

            }
        });

        btnSub.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
//                tune.setValueToChange(-1);
            }
        });
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


//                tune.setValueToChange(1);


            }
        });
        tvMsg = (TextView) findViewById(R.id.tv_msg);

//        tune = (TuneWheel) findViewById(R.id.tune);
////        tune.initViewParam(100, 110, TuneWheel.MOD_TYPE_ONE);
//        tune.initViewParam(100, 110, TuneWheel.MOD_TYPE_TEST);
//
//        tune.setValueChangeListener(new TuneWheel.OnValueChangeListener() {
//            @Override
//            public void onValueChange(float value) {
//
//                handler.sendEmptyMessage(1);
//            }
//        });
    }
}
