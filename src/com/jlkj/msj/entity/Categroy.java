package com.jlkj.msj.entity;

/**
 * Category实体类
 * 用于保存类别相关信息
 * 与数据库categroy表相对应
 */
public class Categroy {
    private int categroyId;//类别id，主键
    private String categroy;//类别信息
    private String categroyDescription;//类别详细描述信息

    public Categroy() {
    }

    public Categroy(int categroyId, String categroy, String categroyDescription) {
        this.categroyId = categroyId;
        this.categroy = categroy;
        this.categroyDescription = categroyDescription;
    }

    public int getCategroyId() {
        return categroyId;
    }

    public void setCategroyId(int categroyId) {
        this.categroyId = categroyId;
    }

    public String getCategroy() {
        return categroy;
    }

    public void setCategroy(String categroy) {
        this.categroy = categroy;
    }

    public String getCategroyDescription() {
        return categroyDescription;
    }

    public void setCategroyDescription(String categroyDescription) {
        this.categroyDescription = categroyDescription;
    }
}
