package cn.zephyr.module.mapper;

import cn.zephyr.module.entity.BuComments;

public interface BuCommentsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BuComments record);

    int insertSelective(BuComments record);

    BuComments selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BuComments record);

    int updateByPrimaryKey(BuComments record);
}