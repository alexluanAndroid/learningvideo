package com.example.luanalex.blgame.Activities.GameModule;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;

import com.example.luanalex.blgame.R;

public class VideoActivity extends AppCompatActivity {

    MyVideoView videoView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        videoView = (MyVideoView) findViewById(R.id.video);
        String packagename = this.getPackageName();
        final String uri = ("android.resource://" + packagename + "/raw/vedio");
//        final String uri = ("android.resource://" + packagename + "/raw/output");

        videoView.setVideoURI(Uri.parse(uri));
        videoView.start();
        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                videoView.setVideoURI(Uri.parse(uri));
                videoView.start();
            }

        });
    }

}
