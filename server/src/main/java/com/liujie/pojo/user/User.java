package com.liujie.pojo.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="USER")
public class User {
    /**
     * @Id：标明这是主键（用于get方法或者属性）
     * @Column：该属性在数据库表中对应的字段名，如果两者名字相同，可以不写（用于get方法或者属性）
     * @GeneratedValue(strategy=GenerationType.AUTO)表示主键自增长（用于get方法或者属性）
     */
    @Id  // javax.persistence.Id
    @Column(name="ID")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    @Column(name="TYPE")
    private String type;
    @Column(name="SEX")
    private Integer sex; // 1：男性 0：女性
    @Column(name="NAME")
    private String name;
    @Column(name="AGE")
    private Integer age;
    @Column(name="EMAIL")
    private String email;


}
