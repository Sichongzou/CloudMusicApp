package com.example.cloudmusicapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SearchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
    }
    public void search_me(View view){
        Intent intent=new Intent();
        intent.setClass(this,MeActivity.class);
        startActivity(intent);
    }
    public void search_main(View view){
        Intent intent=new Intent();
        intent.setClass(this,MainActivity.class);
        startActivity(intent);
    }
}