package cn.zephyr.module.controller;

import cn.zephyr.framework.annoation.NoLogin;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Auther: zephyrLai
 * @Date: 2019/3/5 14:21
 * @Description:
 */
@Controller
public class MvcController {

    @RequestMapping("/login")
    @NoLogin
    public String loginHtml(){
        return "login.html";
    }
    @RequestMapping("/")
    public String indexHtml(){
        return "index.html";
    }

    @RequestMapping("/mvc/{mvcName}")
    public String mvcJump(@PathVariable String mvcName){
        return "/"+mvcName;
    }
}
