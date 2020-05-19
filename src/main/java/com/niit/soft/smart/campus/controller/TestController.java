package com.niit.soft.smart.campus.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.*;

/**
 * @Description TODO
 * @Author wf
 * @Date 2020/5/19
 * @Version 1.0
 */
@RestController
public class TestController {

    @RequiresPermissions("setting")
    @GetMapping("/setting")
    public String showUser() {
        return "设置管理";
    }

    @RequiresPermissions("other")
    @GetMapping("/other")
    public String test() {
        return "其他管理";
    }
}
