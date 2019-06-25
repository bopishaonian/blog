package com.per.service.dao.repository;

import com.per.service.dao.po.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @author huangbo
 * @Description:
 * @date 2019/5/27 16:41
 */
@Repository
public interface UserRepository extends JpaRepository<User,Integer>,JpaSpecificationExecutor<User> {
    User findByAccountNumber(String accountNumber);
}
