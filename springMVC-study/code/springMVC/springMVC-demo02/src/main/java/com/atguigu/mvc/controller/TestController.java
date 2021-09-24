package com.atguigu.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description springMVC前端控制器
 * @Author lhw
 * @Date 2021/8/11 15:51
 * @Version 1.0
 **/
@Controller
public class TestController {

    /**
     * index入口方法
     *
     * @return index
     */
    @RequestMapping("/")
    public String index() {
        return "index";
    }
}
