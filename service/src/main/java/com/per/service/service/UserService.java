package com.per.service.service;

/**
 * @author huangbo
 * @Description:
 * @date 2019/5/27 16:49
 */
public interface UserService {
    /**
     * 登录
     * @param accountNumber
     * @param password
     * @return
     */
    boolean login(String accountNumber,String password);
}
