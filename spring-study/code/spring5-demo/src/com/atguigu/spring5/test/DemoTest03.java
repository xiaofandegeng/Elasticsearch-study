package com.atguigu.spring5.test;

import com.atguigu.spring5.bean.Emp;
import com.atguigu.spring5.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * <p>DESC: TODO</p>
 * <p>DATE: 2021/5/14</p>
 * <p>VERSION:1.0.0</p>
 * <p>@AUTHOR: liaohongwei</p>
 */
public class DemoTest03 {

    @Test
    public void testAdd() {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("bean3.xml");
        Emp emp = context.getBean("emp", Emp.class);
        emp.add();
    }

}
