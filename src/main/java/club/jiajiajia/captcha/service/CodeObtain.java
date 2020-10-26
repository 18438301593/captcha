package club.jiajiajia.captcha.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *  验证码存储与获取规则
 */
public interface CodeObtain {
    /**
     *  存储验证码
     * @param code
     * @param request
     * @param response
     */
    void setCode(String code,String sessionKey, HttpServletRequest request, HttpServletResponse response);

    /**
     *  获取验证码
     * @param request
     * @param response
     * @return
     */
    String getCode(String sessionKey,HttpServletRequest request, HttpServletResponse response);

    /**
     *  移除验证码
     * @param sessionKey
     * @param request
     * @param response
     */
    void removeCode(String sessionKey,HttpServletRequest request, HttpServletResponse response);
}
