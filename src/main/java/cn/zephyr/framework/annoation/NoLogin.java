package cn.zephyr.framework.annoation;

import java.lang.annotation.*;

/**
 * @Auther: zephyrLai
 * @Date: 2019/3/6 15:39
 * @Description:
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface NoLogin {
}
