package club.jiajiajia.captcha.service;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @ClassName EnabledCondition
 * @Description: 默认服务是否加载  就看有没有配置servlet请求路径
 * @Author Jiajiajia
 * @Version V1.0
 **/
public class EnabledCondition implements Condition {
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        String b = context.getEnvironment().getProperty("jiajiajia.captcha.path",String.class);
        if(b!=null){
            return true;
        }
        return false;
    }
}
