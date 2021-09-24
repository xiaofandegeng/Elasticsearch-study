package cn.itcast.user.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Description 配置文件
 * @Author lhw
 * @Date 2021/9/24 15:41
 * @Version 1.0
 **/
@Component
@Data
@ConfigurationProperties(prefix = "pattern")
public class PatternProperties {
    public String dateFormat;

    public String envSharedValue;

    public String name;
}
