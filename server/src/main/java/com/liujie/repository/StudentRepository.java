package com.liujie.repository;

import com.liujie.pojo.student.StudentEl;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface StudentRepository extends ElasticsearchRepository<StudentEl,Integer> {
}
