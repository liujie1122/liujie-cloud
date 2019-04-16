package com.liujie.repository;

import com.liujie.upload.pojo.user.UserSearch;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface UserSearchRepository  extends ElasticsearchRepository<UserSearch,Integer> {
    List<UserSearch> findAllByName(String name);
    List<UserSearch> findAllByNameIsLike(String name);

    List<UserSearch> findAllByAgeBetween(Integer age1,Integer age2);
    List<UserSearch> findAllByAgeBetweenAndSex(Integer age1,Integer age2,Integer sex);
}
