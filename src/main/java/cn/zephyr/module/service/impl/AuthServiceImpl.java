package cn.zephyr.module.service.impl;

import cn.zephyr.module.entity.BuUsers;
import cn.zephyr.module.mapper.BuUsersMapper;
import cn.zephyr.module.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Auther: zephyrLai
 * @Date: 2019/3/7 10:08
 * @Description:
 */
@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private BuUsersMapper buUsersMapper;

    @Override
    public BuUsers queryByEmail(String email) {
        return buUsersMapper.queryByEmail(email);
    }
}
