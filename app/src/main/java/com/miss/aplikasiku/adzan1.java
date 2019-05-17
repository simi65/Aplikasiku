package com.miss.aplikasiku;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.IOException;

public class adzan1 extends AppCompatActivity {

    private Button btnPlay;
    private Button btnPause;
    private Button btnStop;
    private MediaPlayer mp;
    private Spinner listItem;

    int[] suara = {
            R.raw.adzan_muhammad_thaha,
            R.raw.athan_egypt,
            R.raw.adzan_mekkah,
            R.raw.adan_madinah_32_16,

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adzan1);

        Button btnback = (Button) findViewById(R.id.submit);

        btnback.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub
                stop();
                finish();

                //menggunakan intent untuk berpindah ke activity sebelumnya
            }
        });




        mp = new MediaPlayer();

        btnPlay = (Button) findViewById(R.id.btnPLAY);
        btnPause = (Button) findViewById(R.id.btnPAUSE);
        btnStop = (Button) findViewById(R.id.btnSTOP);
        listItem = (Spinner) findViewById(R.id.listItem);

        listItem.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {



            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                mp = MediaPlayer.create(adzan1.this, suara[position]);

            }


            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        stateAwal();

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                play();
                btnPlay.setEnabled(false);
                btnPause.setEnabled(true);
                btnStop.setEnabled(true);
            }
        });

        btnPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pause();
            }
        });

        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stop();
            }
        });
    }

    /** State Awal / Pertama Dijalankan */
    public void stateAwal(){
        btnPlay.setEnabled(true);
        btnPause.setEnabled(false);
        btnStop.setEnabled(false);
    }

    /** Dijalankan Oleh Tombol Play */
    private void play() {

        try {
            mp.prepare();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        /** Menjalankan Audio */
        mp.start();

        /** Penanganan Ketika Suara Berakhir */
        mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                stateAwal();
            }
        });
    }

    /** Dijalankan Oleh Tombol Pause */
    public void pause(){
        if(mp.isPlaying()){
            if(mp!=null){
                mp.pause();

            }
        } else {
            if(mp!=null){
                mp.start();

            }
        }
    }


    /** Dijalankan Oleh Tombol Stop */
    public void stop(){
        mp.stop();

        try{
            mp.prepare();
            mp.seekTo(0);
        }catch (Throwable t) {
            t.printStackTrace();
        }

        stateAwal();
    }



}


