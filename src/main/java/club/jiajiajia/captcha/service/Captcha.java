package club.jiajiajia.captcha.service;

import java.lang.annotation.*;

/**
 *  验证码校验标记
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Captcha {
}
