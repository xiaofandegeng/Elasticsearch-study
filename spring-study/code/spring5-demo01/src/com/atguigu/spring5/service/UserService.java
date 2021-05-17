package com.atguigu.spring5.service;

import com.atguigu.spring5.dao.UserDao;

/**
 * <p>DESC: TODO</p>
 * <p>DATE: 2021/5/17</p>
 * <p>VERSION:1.0.0</p>
 * <p>@AUTHOR: liaohongwei</p>
 */
public class UserService {

    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void add(){
        System.out.println("userService add......");
        userDao.update();
    }
}
