package cn.zephyr.module.controller;

import cn.zephyr.common.CommonData;
import cn.zephyr.dto.ResultDTO;
import cn.zephyr.dto.UserInfoDTO;
import cn.zephyr.framework.annoation.NoLogin;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: zephyrLai
 * @Date: 2019/3/6 14:00
 * @Description:
 */
@RestController
@RequestMapping("auth")
public class AuthController {

    @Autowired
    private HttpServletRequest request;
    @Autowired
    private HttpServletResponse response;

    @RequestMapping(value = "login", method = RequestMethod.POST)
    @NoLogin
    public ResultDTO authLogin(String eMail, String password){
        Map<String,String> dataMap = new HashMap<>();
        if(eMail.trim().equals("111111") && password.trim().equals("111111")){
            request.getSession().setAttribute(CommonData.USER_INFO,new UserInfoDTO("111111",new Date().getTime()));
            return ResultDTO.operateSucc("/mvc/index.html");

        }else{
            return ResultDTO.unAuth();
        }
    }

    @NoLogin
    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public String authLogout(){
        request.getSession().removeAttribute(CommonData.USER_INFO);
        return "redirect:/login";
    }
}
