package com.example.cloudmusicapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText userName,password;
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        userName=findViewById(R.id.editText_userName);
        password=findViewById(R.id.editText_password);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);
        getWindow().setStatusBarColor(Color.TRANSPARENT);
    }
    public void login(View view){
        if(userName.getText().toString().equals("Sichongzou")){
            if(password.getText().toString().equals("123456")){
                Intent intent=new Intent();
                intent.setClass(this,MainActivity.class);
                Bundle bundle = new Bundle();
                EditText editText=findViewById(R.id.editText_userName);
                bundle.putString("name",editText.getText().toString());
                intent.putExtras(bundle);
                startActivity(intent);
                Toast.makeText(this,"登陆成功!",Toast.LENGTH_SHORT).show();
                return;
            }
        }
        Toast.makeText(this,"用户名或密码错误，请重试。",Toast.LENGTH_SHORT).show();
    }
}