package com.liujie.dao;


import com.liujie.upload.pojo.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

//@Repository
//,ElasticsearchRepository<User,Integer>
public interface UserDao extends JpaRepository<User,Integer>,JpaSpecificationExecutor {

    List<User> findAllByName(String name);
//    Optional<User> findById(Integer id);
}
