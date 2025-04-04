package com.example.thixemay;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class VideoMP extends AppCompatActivity {
    VideoView vv10;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_video_mp);

        vv10 = findViewById(R.id.vv10);
        String videoUrl = getIntent().getStringExtra("video_url");
        Uri videoUri = Uri.parse(videoUrl);


        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(vv10);
        vv10.setMediaController(mediaController);

        vv10.setVideoURI(videoUri);
        vv10.setOnPreparedListener(mp -> {
            mp.setVideoScalingMode(MediaPlayer.VIDEO_SCALING_MODE_SCALE_TO_FIT);
            vv10.start();
        });

    }
}