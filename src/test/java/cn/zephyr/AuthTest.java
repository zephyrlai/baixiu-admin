package cn.zephyr;

import org.junit.Test;
import org.springframework.util.DigestUtils;

/**
 * @Auther: zephyrLai
 * @Date: 2019/3/7 10:21
 * @Description:
 */
public class AuthTest {
    @Test
    public void myMd5Test(){
        System.err.println(DigestUtils.md5DigestAsHex("123456".getBytes()));
    }
}
