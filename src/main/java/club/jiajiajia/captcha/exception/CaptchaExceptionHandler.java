package club.jiajiajia.captcha.exception;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
/**
 * @ClassName BingExceptionHandler
 * @Description: 验证码异常拦截器
 * @Author Jiajiajia
 * @Version V1.0
 **/
@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CaptchaExceptionHandler {
    public CaptchaExceptionHandler(Object error){
        this.error=error;
    }
    private Object error;

    @ExceptionHandler(CaptchaException.class)
    @ResponseBody
    public Object handlerBingException(CaptchaException e) {
        return error;
    }
}
