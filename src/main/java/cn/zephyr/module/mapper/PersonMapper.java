package cn.zephyr.module.mapper;

import cn.zephyr.module.entity.Person;

import java.util.List;

/**
 * @Auther: zephyrLai
 * @Date: 2019/3/5 10:53
 * @Description:
 */
public interface PersonMapper {
    List<Person> queryList();
}
