package com.rlmonsalve.soundtest;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    MediaPlayer bgm;
    ImageView img;
    Bitmap soundOn;
    Bitmap soundOff;
    boolean toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img = (ImageView) findViewById(R.id.sound_button);
        soundOn = BitmapFactory.decodeResource(getResources(), R.drawable.btn_sonido_on);
        soundOff= BitmapFactory.decodeResource(getResources(), R.drawable.btn_sonido_off);

        toggle = true;
        img.setImageBitmap(soundOn);

        bgm = MediaPlayer.create(this,R.raw.background);
        bgm.start();
        bgm.setLooping(true);

    }

    public void toggleSound(View view){
        if(toggle){
            bgm.pause();
            toggle = false;
            img.setImageBitmap(soundOff);
        }else{
            bgm.start();
            toggle = true;
            img.setImageBitmap(soundOn);
        }
    }

    protected void  onResume(){
        super.onResume();
    }

    protected void onPause(){
        super.onPause();
        bgm.release();
    }
}
