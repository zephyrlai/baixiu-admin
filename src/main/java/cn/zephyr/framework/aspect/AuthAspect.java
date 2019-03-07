package cn.zephyr.framework.aspect;

import cn.zephyr.common.CommonData;
import cn.zephyr.dto.UserInfoDTO;
import cn.zephyr.framework.annoation.NoLogin;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * @Auther: zephyrLai
 * @Date: 2019/3/6 15:10
 * @Description:
 */
@Aspect     //标记为切面
@Component  //切面的本质是Spring的一个Bean
public class AuthAspect {
    private Logger logger = LoggerFactory.getLogger(AuthAspect.class);

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private HttpServletResponse response;
    /**
     * 定义切点（拦截规则：拦截cn.zephyr包下面的所有类中，有@RequestMapping注解的方法。）
     */
    @Pointcut("execution(* cn.zephyr..*(..)) " +
            "&& @annotation(org.springframework.web.bind.annotation.RequestMapping)")
    public void globalPointcut(){}

    /**
     * 拦截器具体实现(环绕增强)
     * @param joinPoint
     * @return ResultBean（被拦截方法的执行结果，或需要登录的错误提示。）
     */
    @Around("globalPointcut()") //指定拦截器规则
    public Object Interceptor(ProceedingJoinPoint joinPoint){
        Object result = null;
        UserInfoDTO userInfoDTO = (UserInfoDTO)request.getSession().getAttribute(CommonData.USER_INFO);
        try {
            Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();
//            logger.info("------登录状态校验,method:{}-----",method.getDeclaringClass()+"."+method.getName());
            if(method.getAnnotation(NoLogin.class) == null){
                if(null == userInfoDTO){
                    return "redirect:/login";
                }
            }
            //继续执行被拦截的方法
            result = joinPoint.proceed();
        } catch (Throwable e) {
            logger.info("发生异常：",e.getMessage());
            e.printStackTrace();
        }
        return result;
    }
}
