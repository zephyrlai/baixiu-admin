package cn.zephyr.controller;

import cn.zephyr.entity.Person;
import cn.zephyr.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Auther: zephyrLai
 * @Date: 2019/3/5 10:23
 * @Description:
 */
@RestController()
public class PersonController {

    @Autowired
    private PersonService personService;

    @RequestMapping("/test")
    public List<Person> indexTest(){
        return personService.queryList();
    }
}
