package cn.zephyr.module.controller;

import cn.zephyr.common.CommonData;
import cn.zephyr.dto.UserInfoDTO;
import cn.zephyr.framework.annoation.NoLogin;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

/**
 * @Auther: zephyrLai
 * @Date: 2019/3/5 14:21
 * @Description:
 */
@Controller
public class MvcController {

    @Autowired
    private HttpServletRequest request;

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
    public String mvcJump(@PathVariable String mvcName, Model model){
        UserInfoDTO userInfoDTO = (UserInfoDTO)request.getSession().getAttribute(CommonData.USER_INFO);
        model.addAttribute("userInfo",userInfoDTO.getUsers());
        return "/"+mvcName;
    }
}
