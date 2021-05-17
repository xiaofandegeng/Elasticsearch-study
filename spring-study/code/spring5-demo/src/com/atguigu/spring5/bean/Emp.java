package com.atguigu.spring5.bean;

/**
 * <p>DESC: 员工类</p>
 * <p>DATE: 2021/5/17</p>
 * <p>VERSION:1.0.0</p>
 * <p>@AUTHOR: liaohongwei</p>
 */
public class Emp {

    private String ename;

    private String eGender;

    private Dept dept;

    public void setEname(String ename) {
        this.ename = ename;
    }

    public void seteGender(String eGender) {
        this.eGender = eGender;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }


    public Dept getDept() {
        return dept;
    }

    public void add() {
        System.out.println(ename + ":::" + eGender + ":::" + dept);
    }
}
