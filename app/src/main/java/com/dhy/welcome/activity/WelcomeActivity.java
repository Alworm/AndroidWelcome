package com.dhy.welcome.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

import com.dhy.welcome.R;

import java.util.Timer;
import java.util.TimerTask;

public class WelcomeActivity extends Activity {
    private int time = 5;
    private TextView txtView;
    private Timer timer = new Timer();
    private Handler handler;
    private Runnable runnable;
    //登录 记住用户名  用户名  密码  输入框  验证  跳转  多选框 是否记住用户名
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        findView();
    }

    private void findView() {
        txtView = findViewById(R.id.txt_view);
        txtView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WelcomeActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
                if(runnable!=null){
                    handler.removeCallbacks(runnable);
                }
            }
        });
        timer.schedule(timerTask,1000,1000);
        handler = new Handler();
        handler.postDelayed(runnable=new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(WelcomeActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        }, 5000);
    }

    TimerTask timerTask = new TimerTask() {
        @Override
        public void run() {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    time--;
                    txtView.setText("跳转 "+time);
                    if(time<0){
                        timer.cancel();
                    }
                }
            });
        }
    };

}
