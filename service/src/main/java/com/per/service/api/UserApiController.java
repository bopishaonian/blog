package com.per.service.api;

import com.per.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author huangbo
 * @Description:
 * @date 2019/5/27 17:13
 */
@RestController
@RequestMapping("user")
public class UserApiController {
    @Autowired
    private UserService userService;

    @GetMapping("login")
    public boolean login(String accountNumber,String password){
        return userService.login(accountNumber,password);
    }
}
