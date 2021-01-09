package com.example.cloudmusicapp.gsonpackage;

import java.util.ArrayList;
import java.util.List;

//转义json所使用的类
public class RequestResult {
    public String from;
    public String to;
    public List<Trans_result> trans_result;
    public class Trans_result{
        public String src;
        public String dst;
    }
}
