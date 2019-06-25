package com.per.service.dao.po;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author huangbo
 * @Description: 用户
 * @date 2019/5/27 16:34
 */
@Data
@Table(name = "user")
@Entity
public class User {
    /**
     * id
     */
    private Integer id;
    /**
     * 账号
     */
    private String accountNumber;
    /**
     * 密码
     */
    private String password;
    /**
     * 用户名称
     */
    private String name;
}
