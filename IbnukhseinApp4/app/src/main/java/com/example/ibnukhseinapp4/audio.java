package com.example.ibnukhseinapp4;


import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.Toast;

public class audio extends AppCompatActivity {

    MediaPlayer mPlayer;
    Button startButton, pauseButton, stopButton;
    SeekBar volumeControl;
    AudioManager audioManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio);

       }


    public void onRadioButtonClicked(View view) {

        // если переключатель отмечен
        boolean checked = ((RadioButton) view).isChecked();

        // Получаем нажатый переключатель
        switch(view.getId()) {
            case R.id.bim:
                if (checked){
                    play_vid(R.raw.bim);
                }
                break;
            case R.id.impos:
                if (checked){
                    play_vid(R.raw.impos);
                }
                break;
            case R.id.ras:
                if (checked){
                    play_vid(R.raw.ras);
                }
                break;
            case R.id.roses:
                if (checked){
                    play_vid(R.raw.roses);
                }
                break;
        }
    }

    public void play_vid(int vid_id){
        if(mPlayer!=null){mPlayer.stop();}

        mPlayer=MediaPlayer.create(this, vid_id);

        mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                stopPlay();
            }
        });
        startButton = (Button) findViewById(R.id.start);
        pauseButton = (Button) findViewById(R.id.pause);
        stopButton = (Button) findViewById(R.id.stop);

        // Получаем доступ к менеджеру звуков
        audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
//получить максимальный объем
        int maxVolume = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        int curValue = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);

        volumeControl = (SeekBar) findViewById(R.id.volumeControl);
        volumeControl.setMax(maxVolume);
        volumeControl.setProgress(curValue);
        volumeControl.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                //Для управления громкостью звука применяется класс AudioManager. А в с помощью вызова
                //в качестве второго параметра можно передать нужное значение громкости.
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, progress, 0);
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }
    private void stopPlay(){
        mPlayer.stop();

        try {
            mPlayer.prepare();
            mPlayer.seekTo(0);

        }
        catch (Throwable t) {
            Toast.makeText(this, t.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    public void play(View view){ mPlayer.start();
      }
    public void pause(View view){ mPlayer.pause();
            }
    public void stop(View view){ stopPlay();
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mPlayer.isPlaying()) {
            stopPlay();
        }
    }
}