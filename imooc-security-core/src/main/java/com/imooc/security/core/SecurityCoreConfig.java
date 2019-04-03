package com.imooc.security.core;

import com.imooc.security.core.properties.SecurityProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * 配置类
 */
@Configuration
@EnableConfigurationProperties(SecurityProperties.class)// 加载配置类
public class SecurityCoreConfig {
}
