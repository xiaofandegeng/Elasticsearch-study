package com.atguigu.spring5;

/**
 * <p>DESC: TODO</p>
 * <p>DATE: 2021/5/14</p>
 * <p>VERSION:1.0.0</p>
 * <p>@AUTHOR: liaohongwei</p>
 */
public class Book {

    private String bname;

    private String bauthor;

    public void setBname(String bname) {
        this.bname = bname;
    }

    public void setBauthor(String bauthor) {
        this.bauthor = bauthor;
    }

    public void testDemo(){
        System.out.println(bname + ":::" + bauthor);
    }
}
