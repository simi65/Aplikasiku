package com.miss.aplikasiku;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class aktifiti2 extends AppCompatActivity implements View.OnClickListener {


    //todo 1 deklarasikan

    Button adzan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aktifiti2);

        adzan = findViewById(R.id.adzan);

        adzan.setOnClickListener(this);
    }
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setMessage("Apa kalian ingin Exit?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        aktifiti2.this.finish();
                    }
                })
                .setNegativeButton("No", null)
                .show();
    }

    @Override public boolean onCreateOptionsMenu(Menu menu) {
// Inflate the menu; this adds items to the action bar if it is present. getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.adzan:
                //kasih alamat untuk perpidahan activity
                Intent pindah_activity = new Intent(aktifiti2.this, adzan1.class);
                //untuk perpindahan activity
                startActivity(pindah_activity);
                break;


        }

    }
}
