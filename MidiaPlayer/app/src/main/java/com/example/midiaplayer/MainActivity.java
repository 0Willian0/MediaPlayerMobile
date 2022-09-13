package com.example.midiaplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void DuaLipa(View v)
    {
        Intent i = new Intent(v.getContext(), MainActivity2.class);
        Bundle params= new Bundle();
        i.putExtras(params);
        startActivity(i);
    }

    public void Coldplay(View v)
    {
        Intent i = new Intent(v.getContext(), MainActivity3.class);
        Bundle params= new Bundle();
        i.putExtras(params);
        startActivity(i);
    }
    public void AvrilLavigne(View v)
    {
        Intent i = new Intent(v.getContext(), MainActivity4.class);
        Bundle params= new Bundle();
        i.putExtras(params);
        startActivity(i);
    }
    public void PostMalone(View v)
    {
        Intent i = new Intent(v.getContext(), MainActivity5.class);
        Bundle params= new Bundle();
        i.putExtras(params);
        startActivity(i);
    }
}