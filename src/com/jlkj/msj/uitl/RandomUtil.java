package com.jlkj.msj.uitl;

import java.util.Date;
import java.util.UUID;

public class RandomUtil {

    private  RandomUtil(){}

    /**
     * 随机生成Id
     * 使用UUID+时间的方式生成，确保唯一性
     * @return
     */
    public static String getId(){
        UUID uuid = UUID.randomUUID();
        String uuidStr = uuid.toString();
        uuidStr.replaceAll("-","");
        Date date = new Date();
        uuidStr+=date.getTime();
        return uuidStr;
    }
}
