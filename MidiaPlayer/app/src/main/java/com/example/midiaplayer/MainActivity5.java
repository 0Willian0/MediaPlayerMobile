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

public class MainActivity5 extends AppCompatActivity {

    MediaPlayer mediaPlayer;
    AudioManager audioManager;
    Button btnPlay5,btnStop5,btnPause5;
    Button btnMusica10,btnMusica11,btnMusica12;
    SeekBar barVolume5;
    int musica1,musica2,musica3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        musica1 = R.raw.postmalonecircles;
        musica2 = R.raw.postmalonestay;
        musica3 = R.raw.postmalonewow;
        bootStrap();
        bootSeekBar();
    }

    public void bootStrap() {
        btnPlay5 = findViewById(R.id.btnPlay5);
        btnStop5 = findViewById(R.id.btnStop5);
        btnPause5 = findViewById(R.id.btnPause5);
        btnMusica10 = findViewById(R.id.btnMusica10);
        btnMusica11 = findViewById(R.id.btnMusica11);
        btnMusica12 = findViewById(R.id.btnMusica12);
        barVolume5 = findViewById(R.id.barVolume5);

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
        barVolume5.setMax(volMax);
        int volume = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
        barVolume5.setProgress(volume);
        barVolume5.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

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