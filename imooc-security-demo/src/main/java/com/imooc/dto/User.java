package com.imooc.dto;

import com.fasterxml.jackson.annotation.JsonView;
import com.imooc.validator.MyConstraint;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

@Data
public class User {

    public interface UserSimpleView {}
    public interface UserDetailView extends UserSimpleView {}

    private String id;

    @MyConstraint(message = "报错啦哈哈哈")
    @JsonView(UserSimpleView.class)
    private String username;

    @NotBlank
    @JsonView(UserDetailView.class)
    private String password;
}
