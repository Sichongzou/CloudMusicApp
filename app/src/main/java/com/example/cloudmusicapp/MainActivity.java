package com.example.cloudmusicapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void main_me(View view){
        Intent intent=new Intent();
        intent.setClass(this,MeActivity.class);
        startActivity(intent);
    }
    public void main_search(View view){
        Intent intent=new Intent();
        intent.setClass(this,SearchActivity.class);
        startActivity(intent);
    }
}