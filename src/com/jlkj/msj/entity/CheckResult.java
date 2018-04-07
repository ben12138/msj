package com.jlkj.msj.entity;

/**
 * CheckResult实体类
 * 用于保存审核的结果信息
 * 和数据库的check_result表对应
 */
public class CheckResult {
    private int resultId;//id自增长，为物理主键
    private String result;//处理结果信息
    private String resultDescription;//处理结果信息描述

    public CheckResult() {
    }

    public CheckResult(int resultId, String result, String resultDescription) {
        this.resultId = resultId;
        this.result = result;
        this.resultDescription = resultDescription;
    }

    public int getResultId() {
        return resultId;
    }

    public void setResultId(int resultId) {
        this.resultId = resultId;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getResultDescription() {
        return resultDescription;
    }

    public void setResultDescription(String resultDescription) {
        this.resultDescription = resultDescription;
    }
}
