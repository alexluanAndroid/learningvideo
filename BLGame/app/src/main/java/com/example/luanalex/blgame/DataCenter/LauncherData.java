package com.example.luanalex.blgame.DataCenter;

/**
 * Created by luanalex on 2018/6/7.
 */

public class LauncherData {
    private static final LauncherData ourInstance = new LauncherData();

    public static LauncherData getInstance() {
        return ourInstance;
    }

    public Boolean isLogin;       // 判断是否登录

    private LauncherData() {
        initData();
    }

    private void initData(){
        this.isLogin = true;
    }

}
