package com.jlkj.msj.entity;

/**
 * Authority实体类
 * 存放所有的权限信息
 * 与数据库authority表对应
 */
public class Authority {
    private int authorityId;//权限id
    private String authority;//权限内容
    private String anthorityDescription;//权限详细描述

    public Authority() {
    }

    public Authority(int authorityId, String authority, String anthorityDescription) {
        this.authorityId = authorityId;
        this.authority = authority;
        this.anthorityDescription = anthorityDescription;
    }

    public int getAuthorityId() {
        return authorityId;
    }

    public void setAuthorityId(int authorityId) {
        this.authorityId = authorityId;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public String getAnthorityDescription() {
        return anthorityDescription;
    }

    public void setAnthorityDescription(String anthorityDescription) {
        this.anthorityDescription = anthorityDescription;
    }
}
