package club.jiajiajia.captcha;

import club.jiajiajia.captcha.exception.CaptchaError;
import club.jiajiajia.captcha.exception.CaptchaExceptionHandler;
import club.jiajiajia.captcha.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName CaptchaConfig
 * @Description: 初始系统配置
 * @Author Jiajiajia
 * @Version V1.0
 **/
@Configuration
@ComponentScan({"club.jiajiajia.captcha.service"})
public class CaptchaConfig {
    public CaptchaConfig(){
        System.out.println("CaptchaConfig init");
    }

    /**
     * 获取验证码服务
     * @param propertys
     * @return
     * @throws Exception
     */
    @Bean
    @Conditional(value ={EnabledCondition.class})
    public ServletRegistrationBean getServletRegistrationBean(Propertys propertys,CodeObtain codeObtain) throws Exception{
        if(propertys.getSessionKey()==null||"".equals(propertys)){
            throw new Exception("jiajiajia.captcha.session-key can not be null!");
        }
        ServletRegistrationBean bean = new ServletRegistrationBean(new CaptchaServlet(propertys,codeObtain));
        bean.addUrlMappings(propertys.getPath());
        return bean;
    }

    @Autowired(required = false)
    private CaptchaErrReMsg captchaErrReMsg;

    /**
     * 异常拦截器
     * @param propertys
     * @return
     * @throws Exception
     */
    @Bean
    @Conditional(value ={EnabledCondition.class})
    public CaptchaExceptionHandler getCaptchaExceptionHandler(Propertys propertys) throws Exception{
        if(captchaErrReMsg!=null){
            return new CaptchaExceptionHandler(captchaErrReMsg);
        }else{
            if(propertys.getErrMsgClass()!=null){
                return new CaptchaExceptionHandler(new CaptchaError());
            }else{
                return new CaptchaExceptionHandler(Class.forName(propertys.getErrMsgClass()).newInstance());
            }
        }
    }

    /**
     *  验证码存取规则
     * @return
     */
    @Bean
    @Conditional(value ={EnabledCondition.class})
    @ConditionalOnMissingBean(CodeObtain.class)
    public CodeObtain getCodeObtain(){
        return new CodeSessionObtain();
    }
}
