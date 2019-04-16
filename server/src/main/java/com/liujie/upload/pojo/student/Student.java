package com.liujie.upload.pojo.student;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
//@Entity
//@Table(name="student")
public class Student {

//    @Id  // javax.persistence.Id
//    @Column(name="ID")
//    @GeneratedValue(strategy= GenerationType.AUTO)
//    private Integer id;

    @Column(name="name")
    @Field(type = FieldType.Text,analyzer = "ik_smart")
    private String name; //姓名

}
