package com.example.ibnukhseinapp4;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

      }
    public void open_phone(View view) {
        Intent intent = new Intent(getApplicationContext(),
                video_on_phone.class);
        startActivity(intent);
    }
    public void open_net(View view) {
        Intent intent = new Intent(getApplicationContext(),
                video_net.class);
        startActivity(intent);
    }

    public void open_audio(View view) {
        Intent intent = new Intent(getApplicationContext(),
                audio.class);
        startActivity(intent);
    }

}