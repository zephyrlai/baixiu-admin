package cn.zephyr.dto;

import lombok.Data;

/**
 * @Auther: zephyrLai
 * @Date: 2019/3/6 15:20
 * @Description:
 */
@Data
public class UserInfoDTO {
    private String email;
    private Long loginTime;

    public UserInfoDTO(String email, Long loginTime) {
        this.email = email;
        this.loginTime = loginTime;
    }
}
