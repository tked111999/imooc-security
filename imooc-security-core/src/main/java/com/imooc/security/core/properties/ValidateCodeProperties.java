package com.imooc.security.core.properties;

import lombok.Data;

/**
 * @Description TODO
 * @Author Administrator
 * @Date 2019/4/6  16:40
 * @Version 1.0
 **/
@Data
public class ValidateCodeProperties {
    private ImageCodeProperties image = new ImageCodeProperties();
}
