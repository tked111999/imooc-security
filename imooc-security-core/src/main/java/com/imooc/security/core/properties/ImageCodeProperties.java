package com.imooc.security.core.properties;

import lombok.Data;

/**
 * @Description TODO
 * @Author Administrator
 * @Date 2019/4/6  16:39
 * @Version 1.0
 **/
@Data
public class ImageCodeProperties {

    private int width = 67;
    private int height = 23;
    private int length = 4;
    private int expireIn = 60;

}
