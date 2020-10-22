package club.jiajiajia.captcha.exception;

/**
 * @ClassName CaptchaException
 * @Description: 自定义验证码校验异常
 * @Author Jiajiajia
 * @Version V1.0
 **/
public class CaptchaException extends RuntimeException{
    private Integer code=-1;
    private String message="error";

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public CaptchaException(){
        super();
    }
    public CaptchaException(String message){
        super(message);
        this.message=message;
    }
}
