package com.jlkj.msj.entity;

/**
 * 对于点赞，举报，评分的类别的类
 */
public class Type {
    private Type(){};
    public static int MENU = 1;//对菜谱的分类编号
    public static int PRODUCTION = 2;//作品的分类编号
    public static int COMMENT = 3;//评论的分类编号
    public static int QUESTION = 4;//问题的编号
    public static int ANSWER = 5;//问题回答的编号
    public static int LIVE_SHOW = 6;//直播的编号
    public static int VIDEO = 7;//视频的编号
}
