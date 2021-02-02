package com.example.hello.shiro.util;


import java.util.UUID;

public class IDUtil {

    public static String getID(){
        return generateUUID();
    }

    public static String generateUUID(){
        return UUID.randomUUID().toString().replace("-","");
    }

}
