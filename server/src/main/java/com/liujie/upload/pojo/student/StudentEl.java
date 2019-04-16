package com.liujie.upload.pojo.student;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

//索引库  类型  分片 备份
@Document(indexName = "studentel",type = "studentel",shards = 1,replicas = 1)
public class StudentEl extends Student {
    @Id
    @Field(type = FieldType.Integer)
    private Integer idEl;
}
