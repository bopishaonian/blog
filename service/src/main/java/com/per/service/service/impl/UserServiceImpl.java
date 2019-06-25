package com.per.service.service.impl;

import com.per.service.dao.po.User;
import com.per.service.dao.repository.UserRepository;
import com.per.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author huangbo
 * @Description:
 * @date 2019/5/27 16:50
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean login(String accountNumber, String password) {
        User user = userRepository.findByAccountNumber(accountNumber);
        if(user!=null && user.getPassword().equals(password)){
            return true;
        }else {
            return false;
        }
    }
}
