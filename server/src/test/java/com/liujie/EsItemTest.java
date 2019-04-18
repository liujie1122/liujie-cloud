package com.liujie;



import com.liujie.pojo.Item;
import com.liujie.repository.ItemRepository;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.Aggregations;
import org.elasticsearch.search.aggregations.bucket.terms.StringTerms;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.aggregation.AggregatedPage;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = ServerApplication.class)
public class EsItemTest {

    @Autowired
    private ElasticsearchTemplate template;
    @Autowired
    private ItemRepository itemRepository;

    @Test
    public void testCreate(){
        //创建索引库
        template.createIndex(Item.class);
        //添加映射
        template.putMapping(Item.class);
    }

    @Test
    public void testDeleteIndex(){
        //删除索引
        template.deleteIndex(Item.class);
    }

    @Test
    public void testCreate1(){
        //创建索引库
        template.createIndex(Item.class);
        //添加映射
        template.putMapping(Item.class);
    }

    @Test
    public void testSaveAll(){
        //添加数据
        List<Item> list = new ArrayList<>();
        list.add(new Item(1L, "小米手机7", " 手机", "小米", 3499.00, "http://image.leyou.com/13123.jpg"));
        list.add(new Item(2L, "小米手机8", " 手机", "小米", 3599.00, "http://image.leyou.com/13123.jpg"));
        list.add(new Item(3L, "iphone8", " 手机", "苹果", 6999.00, "http://image.leyou.com/13123.jpg"));
        list.add(new Item(4L, "iphoneX", " 手机", "苹果", 8999.00, "http://image.leyou.com/13123.jpg"));
        itemRepository.saveAll(list);

    }

    @Test
    public void testFind() {
        //测试查询
        Iterable<Item> all = itemRepository.findAll();
        for (Item item : all) {
            System.out.println(item);
        }
        System.out.println("=================");
        List<Item> all1 = itemRepository.findAllByPriceBetween(3000.0, 7000.0);
        for (Item item : all1) {
            System.out.println(item);
        }
    }

    @Test
    public void testQuery1() {
        //测试原生复杂查询
//        new NativeSearchQuery()
//       itemRepository.search(SearchQuery)
        MatchQueryBuilder matchQuery = QueryBuilders.matchQuery("title", "小米手机");

        Iterable<Item> search = itemRepository.search(matchQuery);
        System.out.println(search);
    }

    @Test
    public void testQuery2() {
        NativeSearchQueryBuilder builder = new NativeSearchQueryBuilder();
        //添加结果过滤条件
        builder.withFields("title","price");
        //添加查询条件
        builder.withQuery(QueryBuilders.matchQuery("title", "小米手机"));
        //添加排序条件
        builder.withSort(SortBuilders.fieldSort("price").order(SortOrder.DESC));
        //分页
//        PageRequest pageRequest =;
        builder.withPageable( PageRequest.of(0, 2));
        Page<Item> itemPage = itemRepository.search(builder.build());
        //获取总数量
        long totalElements = itemPage.getTotalElements();
        System.out.println("totalElements"+totalElements);
        //获取总页数
        int totalPages = itemPage.getTotalPages();
        System.out.println("totalPages"+totalPages);
        //获取当前页集合
        List<Item> content = itemPage.getContent();
        content.stream().forEach(System.out::println);
//        //获取分页排序方式
//        Sort sort = itemPage.getSort();
//        System.out.println("sort"+sort);

    }

    @Test
    public void testAggs() {
        NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder();
        queryBuilder.addAggregation(AggregationBuilders.terms("brand").field("brand"));
        AggregatedPage<Item> queryForPage = template.queryForPage(queryBuilder.build(), Item.class);
        Aggregations aggregations = queryForPage.getAggregations();
        System.out.println(aggregations);
        StringTerms brand = (StringTerms) queryForPage.getAggregation("brand");
        System.out.println(brand);
        System.out.println("==================");
        List<StringTerms.Bucket> buckets = brand.getBuckets();
        buckets.stream().forEach(System.out::println);
        for (StringTerms.Bucket bucket: buckets) {
            System.out.println("bucket.getKey()"+bucket.getKey());
            System.out.println("bucket.getDocCount()"+bucket.getDocCount());
        }

//        Map<String, Object> map = brand.getMetaData();
//        System.out.println(map);
//        StringTerms terms = aggregations.get("brand");
//        List<StringTerms.Bucket> buckets = terms.getBuckets();
//        buckets.stream().forEach(System.out::println);
//        for (StringTerms.Bucket bucket: buckets) {
//            System.out.println("bucket.getKey()"+bucket.getKey());
//            System.out.println("bucket.getDocCount()"+bucket.getDocCount());
//        }


    }


}

