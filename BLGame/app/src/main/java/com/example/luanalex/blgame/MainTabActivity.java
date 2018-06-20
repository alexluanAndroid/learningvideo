package com.example.luanalex.blgame;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.ClipData;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.example.luanalex.blgame.BaseActivity.BaseActivity;
import com.example.luanalex.blgame.Fragments.ChatActivityFragment;
import com.example.luanalex.blgame.Fragments.GameActivityFragment;
import com.example.luanalex.blgame.Fragments.MineActivityFragment;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

public class MainTabActivity extends BaseActivity implements ChatActivityFragment.OnFragmentInteractionListener,MineActivityFragment.OnFragmentInteractionListener,GameActivityFragment.OnFragmentInteractionListener {

//    private TextView navTitle ;
    private FragmentManager manager;

    MineActivityFragment mine;
    GameActivityFragment game;
    ChatActivityFragment chat;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    showFragment(0);
                    return true;
                case R.id.navigation_dashboard:
                    showFragment(1);
                    return true;
                case R.id.navigation_notifications:
                    showFragment(2);
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_tab);

        Bundle bundle = new Bundle();
        bundle.putString("name","alexuan");

        mine = new MineActivityFragment();
        game = new GameActivityFragment();
        chat = new ChatActivityFragment();

        mine.setArguments(bundle);

        manager = getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.content,mine);
        transaction.add(R.id.content,game);
        transaction.add(R.id.content,chat);

        transaction.hide(mine);
        transaction.hide(game);
        transaction.hide(chat);

        transaction.commit();

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        Menu menu = navigation.getMenu();
        int selectedIndex = 2;
            MenuItem item = menu.getItem(selectedIndex);
            navigation.setSelectedItemId(navigation.getMenu().getItem(selectedIndex).getItemId());
            mOnNavigationItemSelectedListener.onNavigationItemSelected(item);
        Boolean list =  transaction.isEmpty();
        Log.i("","");

        final Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {

                timer.cancel();
            }
        };
        timer.schedule(timerTask,4000,5000); //延时1s，每隔500毫秒执行一次run方法

    }

    public void reset(){
        mine.resetContent();
    }

    private void showFragment(int index){
        android.support.v4.app.FragmentTransaction transaction = manager.beginTransaction();

        hideallFragment();

        switch (index){
            case 0:
//                navTitle.setText("game");
                transaction.show(game);
                break;
            case 1:
//                navTitle.setText("chat");
                transaction.show(chat);
                break;
            case 2:
//                navTitle.setText("mine");
                transaction.show(mine);
                break;
            default:

                break;
        }
        transaction.commit();
    }

    private void hideallFragment(){
        android.support.v4.app.FragmentTransaction transaction = manager.beginTransaction();

        transaction.hide(mine);
        transaction.hide(game);
        transaction.hide(chat);
        transaction.commit();
    }
    @Override
    public void onFragmentInteraction(Uri uri) {
        Toast.makeText(this,"asdfasdfads",Toast.LENGTH_LONG).show();
    }

}
