package com.imooc.security.core.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 配置类
 */
@Data
@ConfigurationProperties(prefix = "imooc.security")
public class SecurityProperties {

    // 小配置类
    private BrowserProperties browser = new BrowserProperties();

}
