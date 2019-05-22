package com.example.ibnukhseinapp4;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

public class video_net extends AppCompatActivity {
    VideoView videoPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_net);
        //чтобы управлять потоком воспроизведения, нам надо получить объект VideoView
        videoPlayer =  (VideoView)findViewById(R.id.videoPlayer);

        //С помощью класса MediaController мы можем добавить к VideoView дополнительно элементы управления
        MediaController mediaController = new MediaController(this);
        videoPlayer.setMediaController(mediaController);
        mediaController.setMediaPlayer(videoPlayer);

        videoPlayer =  (VideoView)findViewById(R.id.videoPlayer);
        videoPlayer.setVideoPath("http://video.ch9.ms/ch9/507d/71f4ef0f-3b81-4d2c-956f-c56c81f9507d/AndroidEmulatorWithMacEmulator.mp4");
    }

    //Чтобы управлять видеопотоком, обработчики нажатия кнопко вызывают соответствующее действие:
    public void play(View view){
        videoPlayer.start();
    }
    public void pause(View view){
        videoPlayer.pause();
    }
    public void stop(View view){
        videoPlayer.stopPlayback();
        videoPlayer.resume();
    }
}
