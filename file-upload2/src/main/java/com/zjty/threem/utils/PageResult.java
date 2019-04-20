package com.zjty.threem.utils;

import lombok.Data;

import java.util.List;

@Data
public class PageResult<T> {
    private int currentPage;//当前页码
    private int pageSize;//每页显示记录数
    private Long total;//总记录数
    private List<T> rows;//当前页展示的数据集合
}
