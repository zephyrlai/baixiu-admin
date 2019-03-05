package cn.zephyr.controller;

import cn.zephyr.page.PageView;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Auther: zephyrLai
 * @Date: 2019/3/5 14:21
 * @Description:
 */
@Controller
public class MvnController {

    @RequestMapping("/")
    public String index(){
        return PageView.INDEX;
    }

    @RequestMapping("/mvc/{mvcName}")
    public String mvc(@PathVariable String mvcName){
        return mvcName;
    }
}
