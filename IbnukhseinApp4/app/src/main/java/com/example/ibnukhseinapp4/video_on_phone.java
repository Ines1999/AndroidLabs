package com.example.ibnukhseinapp4;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;
import android.widget.RadioButton;

public class video_on_phone extends AppCompatActivity {
    VideoView videoPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_on_phone);

    }

    public void onRadioButtonClicked(View view) {
        // если переключатель отмечен
        boolean checked = ((RadioButton) view).isChecked();

        // Получаем нажатый переключатель
        switch(view.getId()) {
            case R.id.be:
                if (checked){
                    play_vid(R.raw.be);
                }
                break;
            case R.id.du:
                if (checked){
                    play_vid(R.raw.du);
                }
                break;
            case R.id.lu:
                if (checked){
                    play_vid(R.raw.lu);
                }
                break;
            case R.id.pe:
                if (checked){
                    play_vid(R.raw.pe);
                }
                break;
        }
    }

    public void play_vid(int vid_id){

        //чтобы управлять потоком воспроизведения, нам надо получить объект VideoView
        videoPlayer =  (android.widget.VideoView)findViewById(R.id.videoPlayer);

        //Чтобы указать источник воспроизведения, необходим объект Uri. В данном случае с помощью выражения

        Uri myVideoUri= Uri.parse( "android.resource://" + getPackageName() + "/" + vid_id);
        //получаем адрес видеоролика внутри пакета приложения.
        //Затем этот Uri устанавливается у videoPlayerа
        videoPlayer.setVideoURI(myVideoUri);
        //С помощью класса MediaController мы можем добавить к VideoView дополнительно элементы управления
        MediaController mediaController = new MediaController(this);
        videoPlayer.setMediaController(mediaController);
        mediaController.setMediaPlayer(videoPlayer);
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
