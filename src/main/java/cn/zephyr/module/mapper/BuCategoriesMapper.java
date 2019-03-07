package cn.zephyr.module.mapper;

import cn.zephyr.module.entity.BuCategories;

public interface BuCategoriesMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BuCategories record);

    int insertSelective(BuCategories record);

    BuCategories selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BuCategories record);

    int updateByPrimaryKey(BuCategories record);
}