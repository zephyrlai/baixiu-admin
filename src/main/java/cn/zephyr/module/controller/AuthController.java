package cn.zephyr.module.controller;

import cn.zephyr.common.CommonData;
import cn.zephyr.dto.ResultDTO;
import cn.zephyr.dto.UserInfoDTO;
import cn.zephyr.framework.annoation.NoLogin;
import cn.zephyr.module.entity.BuUsers;
import cn.zephyr.module.service.AuthService;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import sun.text.normalizer.UBiDiProps;

import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: zephyrLai
 * @Date: 2019/3/6 14:00
 * @Description:
 */
@Controller
@RequestMapping("auth")
public class AuthController {

    @Autowired
    private HttpServletRequest request;
    @Autowired
    private HttpServletResponse response;

    @Autowired
    private AuthService authService;

    @RequestMapping(value = "getLoginImg", method = RequestMethod.GET)
    @ResponseBody
    @NoLogin
    public ResultDTO<String> getLoginImg(String email){
        BuUsers buUsers = authService.queryByEmail(email);
        if(null != buUsers)
            return ResultDTO.operateSucc(buUsers.getAvatar());
        else
            return ResultDTO.operateSucc("../static/img/default.png");
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    @ResponseBody
    @NoLogin
    public ResultDTO authLogin(String eMail, String password){
        Map<String,String> dataMap = new HashMap<>();
        if(!StringUtils.isEmpty(eMail) && !StringUtils.isEmpty(password)){
            BuUsers buUsers = authService.queryByEmail(eMail);
            if(null != buUsers && DigestUtils.md5DigestAsHex(password.getBytes()).equals(buUsers.getPassword())){
                request.getSession().setAttribute(CommonData.USER_INFO,new UserInfoDTO(buUsers,new Date().getTime()));
                return ResultDTO.operateSucc("/mvc/index.html");
            }
        }
        return ResultDTO.unAuth();
    }

    @NoLogin
    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public String authLogout(){
        request.getSession().removeAttribute(CommonData.USER_INFO);
        return "redirect:/login";
    }
}
