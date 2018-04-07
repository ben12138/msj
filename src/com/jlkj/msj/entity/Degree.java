package com.jlkj.msj.entity;

/**
 *
 */
public class Degree {
    private int id;
    private String degreeId;
    private int degreeNum;
    private double degree;

    public Degree() {
    }

    public Degree(String degreeId, int degreeNum, double degree) {
        this.degreeId = degreeId;
        this.degreeNum = degreeNum;
        this.degree = degree;
    }

    public Degree(int id, String degreeId, int degreeNum, double degree) {
        this.id = id;
        this.degreeId = degreeId;
        this.degreeNum = degreeNum;
        this.degree = degree;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDegreeId() {
        return degreeId;
    }

    public void setDegreeId(String degreeId) {
        this.degreeId = degreeId;
    }

    public int getDegreeNum() {
        return degreeNum;
    }

    public void setDegreeNum(int degreeNum) {
        this.degreeNum = degreeNum;
    }

    public double getDegree() {
        return degree;
    }

    public void setDegree(double degree) {
        this.degree = degree;
    }
}
