package club.jiajiajia.captcha.service;

import club.jiajiajia.captcha.exception.CaptchaException;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @ClassName LogAopAdapter
 * @Description: 验证码校验器
 * @Author Jiajiajia
 * @Version V1.0
 **/
@Aspect
@Component
public class CaptchaAdapter {

    @Resource
    private Propertys propertys;

    @Pointcut("@annotation(club.jiajiajia.captcha.service.Captcha)")
    public void captcha(){}

    /**
     *  前置通知
     * @throws Throwable
     */
    @Before("captcha()")
    public void doBefore() {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request=attributes.getRequest();
        HttpSession session=request.getSession();
        String s_code=(String)session.getAttribute(propertys.getSessionKey());
        String code=request.getParameter(propertys.getSessionKey());
        /**
         * 验证码校验
         */
        if(s_code==null||!s_code.equals(code)){
            session.removeAttribute(propertys.getSessionKey());
            throw new CaptchaException();
        }
        session.removeAttribute(propertys.getSessionKey());
    }
}