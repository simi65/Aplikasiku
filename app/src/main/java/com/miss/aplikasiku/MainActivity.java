package com.miss.aplikasiku;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity {
    //set waktu lama sPlashscreen
    private static int LamaTampilSplash = 3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayShowEnabled(true);

        //MULAI KODING

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        // KODING
        setContentView(R.layout.activity_main);
        //KODING LAGI

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // to do auto generated stub
                Intent apasih = new Intent(MainActivity.this,aktifiti2.class);
                startActivity(apasih);

                // jeda setelah splashscren

                this.selesai();
                finish();
            }

            private void selesai(){
                //auto
            }
        },LamaTampilSplash);

    };
}

