package com.mybatis.Utils;

import org.junit.Test;

import java.util.UUID;

public class UuidUtils {
    public static String getId(){
        return UUID.randomUUID().toString().replaceAll("-","");
    }


}
