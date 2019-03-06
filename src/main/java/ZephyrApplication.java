import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * @Auther: zephyrLai
 * @Date: 2019/3/5 10:24
 * @Description:
 */
@MapperScan(basePackages="cn.zephyr.module.mapper")
@SpringBootApplication(scanBasePackages = "cn.zephyr")
public class ZephyrApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZephyrApplication.class,args);
    }
}
