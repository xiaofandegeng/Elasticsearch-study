package com.atguigu.spring5.collectionType;

import java.util.List;

/**
 * <p>DESC: TODO</p>
 * <p>DATE: 2021/5/17</p>
 * <p>VERSION:1.0.0</p>
 * <p>@AUTHOR: liaohongwei</p>
 */
public class Book {

    public void setList(List<String> list) {
        this.list = list;
    }

    private List<String> list;


    public void test() {
        System.out.println(list);
    }
}
