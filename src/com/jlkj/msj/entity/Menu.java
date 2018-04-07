package com.jlkj.msj.entity;

import java.util.Date;
import java.util.List;

/**
 * Menu实体类
 * 保存菜单的相关信息
 * 对应数据库menu表
 */
public class Menu {
    private int id;//id自增长，为物理主键
    private String menuId;//menuId为逻辑主键，根据UUID+时间生成，确保唯一性
    private UserInformation userInformation;//发布者信息
    private String title;//标题信息
    private String cover;//封面图片路径
    private String story;//背景故事信息
    private String food;//食材信息
    private String step;//步骤信息，保存为html文件的存储路径
    private String strCategroyId;//从数据库取出的类型id
    private Categroy[] categroyIds;//转化为详细的数组型的id，与categroy对应
    private Degree degree;//评分信息
    private List<Praise> praises;//点赞信息
    private Date sendTime;//发送时间
    private String praise;//点赞编号

    public Menu() {
    }

    public Menu(int id, String menuId, UserInformation userInformation, String title, String cover, String story, String food, String step, String strCategroyId, Degree degree, List<Praise> praises, Date sendTime,String praise) {
        this.id = id;
        this.menuId = menuId;
        this.userInformation = userInformation;
        this.title = title;
        this.cover = cover;
        this.story = story;
        this.food = food;
        this.step = step;
        this.strCategroyId = strCategroyId;
        this.degree = degree;
        this.praises = praises;
        this.sendTime = sendTime;
        this.praise = praise;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    public UserInformation getUserInformation() {
        return userInformation;
    }

    public void setUserInformation(UserInformation userInformation) {
        this.userInformation = userInformation;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getStory() {
        return story;
    }

    public void setStory(String story) {
        this.story = story;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public String getStep() {
        return step;
    }

    public void setStep(String step) {
        this.step = step;
    }

    public String getStrCategroyId() {
        return strCategroyId;
    }

    public void setStrCategroyId(String strCategroyId) {
        this.strCategroyId = strCategroyId;
    }

    public Categroy[] getCategroyIds() {
        return categroyIds;
    }

    public void setCategroyIds(Categroy[] categroyIds) {
        this.categroyIds = categroyIds;
    }

    public Degree getDegree() {
        return degree;
    }

    public void setDegree(Degree degree) {
        this.degree = degree;
    }

    public List<Praise> getPraises() {
        return praises;
    }

    public void setPraises(List<Praise> praises) {
        this.praises = praises;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    public String getPraise() {
        return praise;
    }

    public void setPraise(String praise) {
        this.praise = praise;
    }
}
