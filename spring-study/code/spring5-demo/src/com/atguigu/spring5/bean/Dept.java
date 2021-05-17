package com.atguigu.spring5.bean;

/**
 * <p>DESC: 部门类</p>
 * <p>DATE: 2021/5/17</p>
 * <p>VERSION:1.0.0</p>
 * <p>@AUTHOR: liaohongwei</p>
 */
public class Dept {

    private String dname;

    public void setDname(String dname) {
        this.dname = dname;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "dname='" + dname + '\'' +
                '}';
    }
}
