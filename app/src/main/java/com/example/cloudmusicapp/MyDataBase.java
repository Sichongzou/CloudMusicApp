package com.example.cloudmusicapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class MyDataBase extends SQLiteOpenHelper {
    public static final String CREATE_WORD="create table Word("
            +"id integer primary key autoincrement,"
            +"word text,"
            +"translate text)";

    private Context mContext;

    public MyDataBase(Context context, String name, SQLiteDatabase.CursorFactory factory,int version){
        super(context,name,factory,version);
        mContext=context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_WORD);
        Toast.makeText(mContext,"数据库创建成功",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("delete from tb_dict");
        sqLiteDatabase.execSQL("update sqlite_sequence SET seq = 0 where name ='tb_dict'");
    }


    //单词的添加方法
    public void writeData(SQLiteDatabase sqLiteDatabase,String word,String translate){
        ContentValues values = new ContentValues();
        values.put("word",word);
        values.put("translate",translate);
        sqLiteDatabase.insert("tb_dict",null,values);//保存功能
    }
}
