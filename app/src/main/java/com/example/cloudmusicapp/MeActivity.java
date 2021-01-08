package com.example.cloudmusicapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_me);
    }
    public void me_main(View view){
        Intent intent=new Intent();
        intent.setClass(this,MainActivity.class);
        startActivity(intent);
    }
    public void me_search(View view){
        Intent intent=new Intent();
        intent.setClass(this,SearchActivity.class);
        startActivity(intent);
    }
}