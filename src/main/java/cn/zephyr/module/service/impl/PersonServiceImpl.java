package cn.zephyr.module.service.impl;

import cn.zephyr.module.entity.Person;
import cn.zephyr.module.mapper.PersonMapper;
import cn.zephyr.module.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Auther: zephyrLai
 * @Date: 2019/3/5 10:55
 * @Description:
 */
@Service
@Transactional
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonMapper personMapper;

    @Override
    public List<Person> queryList() {
        return personMapper.queryList();
    }
}
