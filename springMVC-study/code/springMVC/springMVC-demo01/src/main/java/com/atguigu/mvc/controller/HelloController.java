package com.atguigu.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description 前端控制器
 * @Author lhw
 * @Date 2021/8/11 11:19
 * @Version 1.0
 **/
@Controller
public class HelloController {

    /**
     * 试图解析方法
     *
     * @return 试图名称
     */
    @RequestMapping(value = "/")
    public String index() {
        // 返回视图名称
        return "index";
    }

    /**
     * 跳转到target页面
     *
     * @return 跳转页面
     */
    @RequestMapping("/target")
    public String toTarget() {
        return "target";
    }
}
