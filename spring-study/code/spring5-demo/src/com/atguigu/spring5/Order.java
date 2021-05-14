package com.atguigu.spring5;

/**
 * <p>DESC: TODO</p>
 * <p>DATE: 2021/5/14</p>
 * <p>VERSION:1.0.0</p>
 * <p>@AUTHOR: liaohongwei</p>
 */
public class Order {

    private String oname;
    private String oaddress;

    public Order(String oname, String oaddress) {
        this.oname = oname;
        this.oaddress = oaddress;
    }

    public void testOrder() {
        System.out.println(oname + ":::" + oaddress);
    }
}
