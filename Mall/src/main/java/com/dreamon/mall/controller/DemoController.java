package com.dreamon.mall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;

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

//    BufferedInputStream

}
