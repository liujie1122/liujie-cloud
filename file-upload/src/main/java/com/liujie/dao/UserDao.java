package com.liujie.dao;

import com.liujie.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface UserDao extends JpaRepository<User,Integer>,JpaSpecificationExecutor {
    List<User> findAllByAge(Integer age);
}
