package com.example.cloudmusicapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.cloudmusicapp.FanYiApi.TransApi;
import com.example.cloudmusicapp.gsonpackage.RequestResult;
import com.google.gson.Gson;


public class FanyiActivity extends AppCompatActivity {
    Button buttonzh,buttonen;
    EditText editText;
    TextView textView;
    private TransApi api;

    private static final String APP_ID = "20210109000666952";
    private static final String SECURITY_KEY = "QB_Kf7VY_jzVuG9EqAA6";
    @SuppressLint("HandlerLeak")
    Handler handler=new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            Bundle data = msg.getData();
            String value = data.getString("query");
            Log.d("TAG", "handleMessage: "+ value);
            Gson gson=new Gson();
            RequestResult requestResult=gson.fromJson(value, RequestResult.class);
            textView.setText(requestResult.trans_result.get(0).dst);
        }
    };
    //翻译成中文的线程
    Runnable tochinese =new Runnable() {
        @Override
        public void run() {
            String query=editText.getText().toString();
            api=new TransApi(APP_ID,SECURITY_KEY);
            query=api.getTransResult(query,"auto","zh");
            Message message = new Message();
            Bundle data = new Bundle();
            Log.d("run", "run: "+query);
            data.putString("query",query);
            message.setData(data);
            handler.sendMessage(message);
        }
    };
    //翻译成英文的线程
    Runnable toenglish=new Runnable() {
        @Override
        public void run() {
            String query=editText.getText().toString();
            api=new TransApi(APP_ID,SECURITY_KEY);
            query=api.getTransResult(query,"auto","en");
            Message message = new Message();
            Bundle data = new Bundle();
            Log.d("run", "run: "+query);
            data.putString("query",query);
            message.setData(data);
            handler.sendMessage(message);
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fanyi);
        //初始化
        buttonzh=findViewById(R.id.zh_btn_fanyi);
        buttonen=findViewById(R.id.en_btn_fanyi);
        editText=findViewById(R.id.fanyi_inputText);
        textView=findViewById(R.id.fanyi_outputText);
        //请求百度APi翻译成中文
        buttonzh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread(tochinese).start();
            }
        });
        //调用百度API翻译成英文
        buttonen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread(toenglish).start();
            }
        });
    }

}