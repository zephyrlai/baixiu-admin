package cn.zephyr.module.mapper;

import cn.zephyr.module.entity.BuUsers;

public interface BuUsersMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BuUsers record);

    int insertSelective(BuUsers record);

    BuUsers selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BuUsers record);

    int updateByPrimaryKey(BuUsers record);

    BuUsers queryByEmail(String email);
}