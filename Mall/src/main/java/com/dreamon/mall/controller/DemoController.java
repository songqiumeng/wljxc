package com.dreamon.mall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by qiumengsong on 2017/7/20.
 */
@Controller
@RequestMapping(value = "/demo")
public class DemoController {

    @RequestMapping(value = "/demo")
    @ResponseBody
    public String demo(){
        return "hello world";
    }

}
