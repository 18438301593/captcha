package club.jiajiajia.captcha.service;
import club.jiajiajia.captcha.captcha.SpecCaptcha;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;
/**
 * @ClassName CaptchaService
 * @Description: 验证码请求服务
 * @Author Jiajiajia
 * @Version V1.0
 **/
public class CaptchaServlet extends HttpServlet {
    public CaptchaServlet(Propertys propertys){
        this.propertys=propertys;
        font=new Font("Verdana", Font.PLAIN, propertys.getSize());
    }
    private Font font;
    private Propertys propertys;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SpecCaptcha specCaptcha=new SpecCaptcha(propertys.getWidth(),propertys.getHeight(),propertys.getLength());
        specCaptcha.setFont(font);
        specCaptcha.setCharType(propertys.getType());
        req.getSession().setAttribute(propertys.getSessionKey(),specCaptcha.text());
        setHeader(resp);
        specCaptcha.out(resp.getOutputStream());
    }

    public void setHeader(HttpServletResponse response) {
        response.setContentType("image/gif");
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
    }
}
