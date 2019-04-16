package com.liujie.upload.pojo.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

//索引库  类型  分片 备份
@Document(indexName = "user",type = "user",shards = 1,replicas = 1)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserSearch {
    @Id
    @Field(type = FieldType.Integer)//字段类型
    private Integer id;
    @Field(type = FieldType.Keyword)
    private String type;
    @Field(type = FieldType.Keyword)
    private Integer sex; // 1：男性 0：女性
    @Field(type = FieldType.Keyword)
    private String name;
    @Field(type = FieldType.Integer)//字段类型
    private Integer age;
    @Field(type = FieldType.Keyword)
    private String email;


}
