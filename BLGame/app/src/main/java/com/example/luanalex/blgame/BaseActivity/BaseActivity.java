package com.example.luanalex.blgame.BaseActivity;

import android.os.Bundle;
import android.app.Activity;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.example.luanalex.blgame.R;

public class BaseActivity extends AppCompatActivity implements View.OnClickListener {

    protected android.support.v7.app.ActionBar actionBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_base);
        actionBar = getSupportActionBar();
        if(actionBar != null){

            this.setCustomActionBar();
        }
    }
    protected void setCustomActionBar() {
        ActionBar.LayoutParams lp =new ActionBar.LayoutParams(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.MATCH_PARENT, Gravity.CENTER);
        View mActionBarView = LayoutInflater.from(this).inflate(R.layout.activity_nav, null);
        actionBar.setCustomView(mActionBarView, lp);
        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setDisplayShowHomeEnabled(false);
        actionBar.setDisplayShowTitleEnabled(false);
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolBar);
        toolbar.setTitle("");
        toolbar.setSubtitle("");
        toolbar.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
//        actionBar.setDisplayHomeAsUpEnabled(true);
        TextView titleV = (TextView)findViewById(R.id.titleV);
        titleV.setText("title");

//        navleftbtn = (Button)findViewById(R.id.navleftbtn);
//        navrightbtn = (Button)findViewById(R.id.navrightbtn);
//        titleview = (TextView)findViewById(R.id.navtitleview);
//
//        navleftbtn.setOnClickListener(new pop());
//        navrightbtn.setOnClickListener(new pop());
//        actionBar.setHomeButtonEnabled(true);
//        actionBar.setDisplayHomeAsUpEnabled(true);
//        setSupportActionBar(toolbar);
    }

    @Override
    public void onClick(View view) {

    }
}
