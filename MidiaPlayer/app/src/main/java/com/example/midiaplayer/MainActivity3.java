package com.example.midiaplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

public class MainActivity3 extends AppCompatActivity {

    MediaPlayer mediaPlayer;
    AudioManager audioManager;
    Button btnPlay3,btnStop3,btnPause3;
    Button btnMusica4,btnMusica5,btnMusica6;
    SeekBar barVolume3;
    int musica1,musica2,musica3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        musica1 = R.raw.coldplayclocks;
        musica2 = R.raw.coldplayxbtsmyuniverse;
        musica3 = R.raw.coldplayyellow;
        bootStrap();
        bootSeekBar();
    }

    public void bootStrap() {
        btnPlay3 = findViewById(R.id.btnPlay3);
        btnPause3 = findViewById(R.id.btnPause3);
        btnStop3 = findViewById(R.id.btnStop3);
        btnMusica4 = findViewById(R.id.btnMusica4);
        btnMusica5 = findViewById(R.id.btnMusica5);
        btnMusica6 = findViewById(R.id.btnMusica6);
        barVolume3 = findViewById(R.id.barVolume3);

        MediaPlayer.OnCompletionListener onCompletionListener = new
                MediaPlayer.OnCompletionListener()
                {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        releaseMediaPlayerResources(); // implementar main
                    }
                }; // vai pedir para implementar o método, implementar em main
    }

    public void Musica1(View v)
    {
        if (mediaPlayer != null && mediaPlayer.isPlaying())
            mediaPlayer.stop();

        mediaPlayer = MediaPlayer.create(getApplicationContext(),musica1);
    }

    public void Musica2(View v)
    {
        if (mediaPlayer != null && mediaPlayer.isPlaying())
            mediaPlayer.stop();

        mediaPlayer = MediaPlayer.create(getApplicationContext(),musica2);
    }

    public void Musica3(View v)
    {
        if (mediaPlayer != null && mediaPlayer.isPlaying())
            mediaPlayer.stop();

        mediaPlayer = MediaPlayer.create(getApplicationContext(),musica3);
    }

    public void Play(View v)
    {
        if (mediaPlayer != null)
            mediaPlayer.start();
    }

    public void Pause(View v)
    {
        if (mediaPlayer != null && mediaPlayer.isPlaying())
            mediaPlayer.pause();
    }

    public void Stop(View v)
    {
        if (mediaPlayer != null && mediaPlayer.isPlaying())
            mediaPlayer.stop();
    }


    @Override
    protected void onStop()
    { // se o aplicativo parar (home p.ex)

        releaseMediaPlayerResources();
        super.onStop();
    }

    private void releaseMediaPlayerResources() {
        if (mediaPlayer != null)
        {
            mediaPlayer.stop();
            mediaPlayer.release();
        }
    }

    protected void bootSeekBar()
    {
        audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        int volMax = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        barVolume3.setMax(volMax);
        int volume = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
        barVolume3.setProgress(volume);
        barVolume3.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)
            {
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, progress, 0);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar)
            {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar)
            {

            }

        });
    }

    protected void onDestroy()
    {
        super.onDestroy();

        if (mediaPlayer != null && mediaPlayer.isPlaying())
        {
            mediaPlayer.stop();
            mediaPlayer.release(); // libera recursos da memória
        }
    }

    public void VoltarTela(View v)
    {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}