package com.liujie.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

//索引库  类型  分片 备份
@Document(indexName = "item",type = "item",shards = 1,replicas = 1)
@Data
@AllArgsConstructor
@NoArgsConstructor
//@Entity
public class Item {

    @Id
    @Field(type = FieldType.Long)
    private Long id;

//    @javax.persistence.Id
//    private Integer idKey;

    @Field(type = FieldType.Text,analyzer = "ik_smart")
    private String title; //标题

    @Field(type = FieldType.Keyword)
    private String category;// 分类
    @Field(type = FieldType.Keyword)
    private String brand; // 品牌
    @Field(type = FieldType.Double)
    private Double price; // 价格
    @Field(type = FieldType.Keyword)
    private String images; // 图片地址

}
