package cn.zephyr.framework.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @Auther: zephyrLai
 * @Date: 2019/3/5 15:24
 * @Description:
 */
@Configuration
public class MyConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        if(!registry.hasMappingForPattern("/**")){
            registry.addResourceHandler("/**").addResourceLocations("classpath:/static/").addResourceLocations("classpath:../static/");
        }
        super.addResourceHandlers(registry);
    }
}