package cn.zephyr.module.mapper;

import cn.zephyr.module.entity.BuPosts;

public interface BuPostsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BuPosts record);

    int insertSelective(BuPosts record);

    BuPosts selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BuPosts record);

    int updateByPrimaryKeyWithBLOBs(BuPosts record);

    int updateByPrimaryKey(BuPosts record);
}