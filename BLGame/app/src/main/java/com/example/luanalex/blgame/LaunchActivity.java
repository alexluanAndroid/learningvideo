package com.example.luanalex.blgame;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.luanalex.blgame.Activities.PersonModule.PersonActivity;
import com.example.luanalex.blgame.DataCenter.LauncherData;

import java.util.Timer;
import java.util.TimerTask;


public class LaunchActivity extends AppCompatActivity {

    LauncherData launcherData = LauncherData.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);

        final Handler handler = new Handler(){
            @Override
            public void handleMessage(Message msg) {

                if (msg.what == 1){
                    Intent intent = new Intent();
                    intent.setClass(LaunchActivity.this, MainTabActivity.class);
                    startActivity(intent);
                    finish();
                }

                super.handleMessage(msg);
            }
        };

        final Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                Message message = new Message();
                if (launcherData.isLogin){
                    message.what = 1;
                }else{
                    message.what = 0;
                }

                handler.sendMessage(message);
                timer.cancel();
            }
        };
        timer.schedule(timerTask,1000,500); //延时1s，每隔500毫秒执行一次run方法

    }
}
