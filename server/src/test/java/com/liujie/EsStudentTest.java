package com.liujie;

import com.liujie.pojo.student.StudentEl;
import com.liujie.repository.StudentRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ServerApplication.class)
public class EsStudentTest {

    @Autowired
    private ElasticsearchTemplate template;
    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void testCreate(){
        //创建索引库
        template.createIndex(StudentEl.class);
        //添加映射
        template.putMapping(StudentEl.class);
    }

    @Test
    public void testDeleteIndex(){
        //删除索引
        template.deleteIndex(StudentEl.class);
    }

    @Test
    public void test1(){
//        StudentRepository
    }



}

