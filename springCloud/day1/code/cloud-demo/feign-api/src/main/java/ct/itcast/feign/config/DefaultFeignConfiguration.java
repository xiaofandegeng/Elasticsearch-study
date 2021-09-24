package ct.itcast.feign.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;

/**
 * @Description feign配置文件
 * @Author lhw
 * @Date 2021/9/24 18:43
 * @Version 1.0
 **/
public class DefaultFeignConfiguration {
    @Bean
    public Logger.Level feignLogLevel(){
        return Logger.Level.BASIC; // 日志级别为BASIC
    }
}
