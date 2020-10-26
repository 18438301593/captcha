package club.jiajiajia.captcha.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName CodeSessionObtain
 * @Description: 默认从session中存储和获取验证码
 * @Author Jiajiajia
 * @Version V1.0
 **/
public class CodeSessionObtain implements CodeObtain{

    public void setCode(String code, String sessionKey, HttpServletRequest request, HttpServletResponse response) {
        request.getSession().setAttribute(sessionKey,code);
    }

    public String getCode(String sessionKey,HttpServletRequest request, HttpServletResponse response) {
        return (String)request.getSession().getAttribute(sessionKey);
    }

    public void removeCode(String sessionKey, HttpServletRequest request, HttpServletResponse response) {
        request.getSession().removeAttribute(sessionKey);
    }
}
