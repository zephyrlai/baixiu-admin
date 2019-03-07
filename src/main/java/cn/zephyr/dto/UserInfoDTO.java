package cn.zephyr.dto;

import cn.zephyr.module.entity.BuUsers;
import lombok.Data;

/**
 * @Auther: zephyrLai
 * @Date: 2019/3/6 15:20
 * @Description:
 */
@Data
public class UserInfoDTO {
    private BuUsers users;
    private Long loginTime;

    public UserInfoDTO(BuUsers users, Long loginTime) {
        this.users = users;
        this.loginTime = loginTime;
    }
}
