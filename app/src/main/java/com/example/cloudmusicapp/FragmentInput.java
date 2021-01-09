package com.example.cloudmusicapp;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.cloudmusicapp.MyDataBase;




public class FragmentInput extends Fragment {
    Button button,btnFanyi;
    EditText editText_word,editText_translate;
    MyDataBase myDataBase;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_input,null);
        myDataBase = new MyDataBase(getActivity(),"Word",null,1);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        editText_word = view.findViewById(R.id.input_et_words);
        editText_translate = view.findViewById(R.id.input_et_translate);
        button = view.findViewById(R.id.input_btn);
        btnFanyi=view.findViewById(R.id.fanyi_btn);
        //点击录入按钮
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    String word = editText_word.getText().toString();
                    String translate = editText_translate.getText().toString();
                    if (word.isEmpty() || editText_translate.getText().toString().isEmpty()){
                        Toast.makeText(getActivity(),"请输入数据!",Toast.LENGTH_SHORT).show();
                    }else{
                        myDataBase.writeData(myDataBase.getReadableDatabase(),word,translate);
                        Toast.makeText(getActivity(),"录入成功！",Toast.LENGTH_SHORT).show();
                        editText_translate.setText("");
                        editText_word.setText("");
                        editText_word.requestFocus();
                }

            }
        });
        //在线翻译按钮
        btnFanyi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(),FanyiActivity.class);
                startActivity(intent);
            }
        });
    }
}
