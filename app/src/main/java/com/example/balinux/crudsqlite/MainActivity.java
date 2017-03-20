package com.example.balinux.crudsqlite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

//    memindahkan activity ke create
    public void btnCreate(View v){
        Intent goCreate = new Intent(MainActivity.this,MainCreate.class);
        startActivity(goCreate);
    }

    public void btnRead(View v){
        Intent goRead = new Intent(MainActivity.this,MainRead.class);
        startActivity(goRead);
    }
}
