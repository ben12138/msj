package com.jlkj.msj.uitl;

import com.jlkj.msj.entity.Categroy;

import java.util.HashMap;
import java.util.Map;

/**
 * 分析用户的喜好
 * 得出用户推荐中各个类型菜谱的个数
 */
public class MenuCatetoryNumUtil {
    //构造方法私有化
    private MenuCatetoryNumUtil(){}

    //得出各个种类的所占个数
    public static Map<Categroy,Integer> getCategoryNum(String userId){
        Map<Categroy,Integer> map = null;
        map = new HashMap<>();
        return map;
    }
}
