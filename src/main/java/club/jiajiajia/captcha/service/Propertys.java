package club.jiajiajia.captcha.service;

import club.jiajiajia.captcha.captcha.AbstractDraw;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @ClassName Propertys
 * @Description: 系统配置属性
 * @Author Jiajiajia
 * @Version V1.0
 **/
@Component
@ConfigurationProperties("jiajiajia.captcha")
public class Propertys {
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getSessionKey() {
        return sessionKey;
    }

    public void setSessionKey(String sessionKey) {
        this.sessionKey = sessionKey;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
    //servlet请求路径
    private String path;
    //图片宽度
    private int width=130;
    //图片高度
    private int height=48;
    //图片字符长度
    private int length=5;
    //session key
    private String sessionKey="code";
    //字体大小
    private int size=32;
    //验证码字符类型
    private int type= AbstractDraw.TYPE_DEFAULT;
    //校验错误的提示信息
    private String errMsgClass="club.jiajiajia.captcha.exception.CaptchaError";

    public String getErrMsgClass() {
        return errMsgClass;
    }

    public void setErrMsgClass(String errMsgClass) {
        this.errMsgClass = errMsgClass;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Propertys{" +
                "path='" + path + '\'' +
                ", width=" + width +
                ", height=" + height +
                '}';
    }
}
