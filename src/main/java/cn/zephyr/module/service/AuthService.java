package cn.zephyr.module.service;

import cn.zephyr.module.entity.BuUsers;

/**
 * @Auther: zephyrLai
 * @Date: 2019/3/7 09:44
 * @Description:
 */
public interface AuthService {
    BuUsers queryByEmail(String email);
}
