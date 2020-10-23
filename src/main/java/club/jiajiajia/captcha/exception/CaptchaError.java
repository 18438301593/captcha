package club.jiajiajia.captcha.exception;

import club.jiajiajia.captcha.service.CaptchaErrReMsg;

/**
 * @ClassName CaptchaError
 * @Description: 默认验证码错误返回数据
 * @Author Jiajiajia
 * @Version V1.0
 **/
public class CaptchaError implements CaptchaErrReMsg {
    private int code=-1;
    private String message="验证码错误";

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
