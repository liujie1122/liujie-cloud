package com.liujie.repository;

import com.liujie.pojo.Item;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface ItemRepository extends ElasticsearchRepository<Item,Long> {
    List<Item> findAllByPriceBetween(double v, double v1);
}
