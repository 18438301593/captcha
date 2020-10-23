### 1.captcha
图片验证码校验框架 使用介绍。<br>
只需简单配置即可实现图片验证码获取，以及实现请求接口验证码自动验证。<br>
只需要两步简单配置：<br>
* 1.配置验证码请求路径：    jiajiajia.captcha.path
* 2.在接口上加 @Captcha 注解即可，在请求接口的时候加code参数，该参数是验证码

### 2.依赖
        <dependency>
            <groupId>club.jiajiajia.captcha</groupId>
            <artifactId>captcha</artifactId>
        <version>1.0-SNAPSHOT</version>
</dependency>

### 3.配置文件
    jiajiajia:
      captcha:
        path: /captcha #图片验证码请求路径
        session-key: code # session key 验证码存放在sessionz中，该参数默认值为code
        width: 130  #图片验证码宽度
        height: 48 #图片验证码高度
        length: 5 #验证码长度
        type: 1 #验证码类型 （1-6）
            #1 字母数字混合 #2 纯数字 #3 纯字母 #4 纯大写字母 #5 纯小写字母 #6 数字大写字母
        size: 30 #字体大小
        err-msg-class: club.jiajiajia.captcha.exception.CaptchaError #验证码错误时返回json数据

如果使用默认值的话只需要配置如下

    jiajiajia:
      captcha:
        path: /captcha #图片验证码请求路径

### 4.参数说明以及配置：
#### path
当path参数存在时，服务才会启用。path参数也是验证码请求的路径，通过请求该路径获取图片验证码.
#### session-key
session-key参数， 该框架默认把生成的验证码参数存放session中，而存放在session中的key就是session-key参数的值。

    HttpSession.setAttribute(session-key,text);
另外session-key参数也是请求需要验证码的业务接口的参数。例如配置的session-key是code,业务接口为：

    @GetMapping
    @Captcha
    public String test(){
        System.out.println("业务接口");
        return "业务接口";
    }
那么在请求该接口的时候参数就必须加上 code 参数，参数值就是图片验证码的值。否则默认返回验证码错误信息。<br>
注意：业务接口如果需要图片验证 需要加上 @Captcha 注解。
#### width 图片验证码宽度
#### height 图片验证码高度
#### length 验证码长度
#### type 验证码类型 
验证码类型 取值（1-6）
* 1 字母数字混合 
* 2 纯数字 
* 3 纯字母 
* 4 纯大写字母 
* 5 纯小写字母 
* 6 数字大写字母
* size 字体大小
#### 5.验证码错误时返回json数据。
实现该效果有三种配置方案
##### 1.使用系统默认方案 返回数据：
        {
            "code": 1,
            "message": "错误"
        }
##### 2.自己配置返回数据（1）
您需要创建一个类，该类的属性有默认值。

    public class Re{
        public String message="验证码错误";
        public int code=0;
        public boolean success=false;
    }
然后在err-msg-class参数配置该类的全路径，例如：

    err-msg-class: club.jiajiajia.captcha.exception.CaptchaError
##### 3.自己配置返回数据（2）
您需要创建一个类。该类需要实现CaptchaErrReMsg接口，属性可以没有默认值

        public class Re implements CaptchaErrReMsg {
            public String message;
            public int code;
            public boolean success;
        }
然后您需要向ioc容器中注入一个该类型的对象，例如：

        @Bean
        public Re getRe(){
            Re re=new Re();
            re.code=1;
            re.message="验证码错误";
            re.success=false;
            return re;
        }
    
        
        