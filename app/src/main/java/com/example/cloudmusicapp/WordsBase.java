package com.example.cloudmusicapp;

import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.SimpleAdapter;


import androidx.appcompat.app.AppCompatActivity;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordsBase extends AppCompatActivity {

    MyDataBase myDataBase;
    ListView listView;
    List<Map<String,Object>> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_words_base);

        myDataBase = new MyDataBase(WordsBase.this,"Word",null,1);
        ArrayList<Word> words = getWords();
        listView = (ListView)findViewById(R.id.list);
            list = new ArrayList<Map<String, Object>>();
            for (int i = 0;i < words.size() ;i++) {
                Map<String, Object> map = new HashMap<>();
            map.put("id",words.get(i).id+".");
            map.put("word", words.get(i).word);
            map.put("translate", words.get(i).translate);
            list.add(map);
        }
        //简单适配器 适配进入listView
        SimpleAdapter simpleAdapter = new SimpleAdapter(WordsBase.this,list, R.layout.list_item,
                new String[]{"id","word","translate"},new int[]{R.id.id,R.id.word,R.id.translate});

        listView.setAdapter(simpleAdapter);

    }
    //查询数据库内容并返回包含数据库内容的ArrayList
    private ArrayList<Word> getWords(){
        ArrayList<Word> words = new ArrayList<>();
        Cursor cursor = myDataBase.getReadableDatabase().query("Word",null,null,null,null,null,null);
        int i = 1;
        while(cursor.moveToNext()){
            Word word = new Word();
            //利用getColumnIndex：String 来获取列的下标，再根据下标获取cursor的值
            word.id = i;
            word.word = cursor.getString(cursor.getColumnIndex("word"));
            word.translate = cursor.getString(cursor.getColumnIndex("translate"));
            words.add(word);
            i++;
        }
        return words;
    }
}