package com.imooc.web.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.imooc.dto.User;
import com.imooc.dto.UserQueryCondition;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @GetMapping()
    @JsonView(User.UserSimpleView.class)
    public List<User> query(UserQueryCondition user) {
        System.out.println(user.toString());
        ArrayList<User> users = new ArrayList<>();
        users.add(new User());
        users.add(new User());
        users.add(new User());
        return users;
    }

    @GetMapping("/{id:\\d+}")
    @JsonView(User.UserDetailView.class)
    public User getUser(@PathVariable String id) {
        System.out.println("id: " + id);
        User user = new User();
        user.setUsername("test");
        return user;
    }

    @PostMapping
    public User createUser(@Valid @RequestBody User user, BindingResult errors) {

        if(errors.hasErrors()) {
            errors.getAllErrors().forEach(error -> System.out.println(error.getDefaultMessage()));
        }

        // 假装有创建操作并返回带有id的用户
        user.setId("1");
        return user;
    }

    @PutMapping("/{id:\\d+}")
    public User updateUser(@Valid @RequestBody User user, BindingResult errors) {

        if(errors.hasErrors()) {
            errors.getAllErrors().forEach(error -> System.out.println(error.getDefaultMessage()));
        }

        // 假装有创建操作并返回带有id的用户
        user.setId("1");
        return user;
    }
}
