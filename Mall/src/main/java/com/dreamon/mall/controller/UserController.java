package com.dreamon.mall.controller;

import com.dreamon.mall.base.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 用户相关的控制器
 * Created by qiumengsong on 2017/7/27.
 */
@Controller
@RequestMapping(value = "/user")
public class UserController extends BaseController {

    @RequestMapping(value = "/login")
    @ResponseBody
    public String login(String tel,String pwd){
        return "";
    }

}
