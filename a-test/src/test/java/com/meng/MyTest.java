package com.meng;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.tomcat.util.codec.binary.Base64;
import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.net.*;
import java.util.ArrayList;
import java.util.List;

public class MyTest {
    public static void main(String[] args) throws UnsupportedEncodingException {
       new MyTest().a();

    }

    public void a(){
        b();
    }

    public void b(){
a();
    }



}

