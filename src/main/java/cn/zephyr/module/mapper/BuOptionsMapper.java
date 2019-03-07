package cn.zephyr.module.mapper;

import cn.zephyr.module.entity.BuOptions;

public interface BuOptionsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BuOptions record);

    int insertSelective(BuOptions record);

    BuOptions selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BuOptions record);

    int updateByPrimaryKeyWithBLOBs(BuOptions record);

    int updateByPrimaryKey(BuOptions record);
}