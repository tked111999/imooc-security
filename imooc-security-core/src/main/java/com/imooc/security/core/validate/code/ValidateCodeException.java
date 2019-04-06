package com.imooc.security.core.validate.code;

import org.springframework.security.core.AuthenticationException;

/**
 * @Description TODO
 * @Author Administrator
 * @Date 2019/4/6  15:40
 * @Version 1.0
 **/
public class ValidateCodeException extends AuthenticationException {

    public ValidateCodeException(String msg) {
        super(msg);
    }

}
