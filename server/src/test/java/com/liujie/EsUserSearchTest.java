package com.liujie;

import com.liujie.upload.pojo.user.User;
import com.liujie.upload.pojo.user.UserSearch;
import com.liujie.repository.UserSearchRepository;
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
public class EsUserSearchTest {

    @Autowired
    private ElasticsearchTemplate template;
    @Autowired
    private UserSearchRepository userRepository;

    @Test
    public void testCreate(){
        //创建索引库
        template.createIndex(UserSearch.class);
        //添加映射
        template.putMapping(UserSearch.class);
    }

    @Test
    public void testDeleteIndex(){
        //删除索引
        template.deleteIndex(UserSearch.class);
    }

    @Test
    public void testSaveAll(){
        long l = System.currentTimeMillis();
        //添加数据
        List<UserSearch> list = new ArrayList<>();
        int id = 1;
        int index =100;
        for (int i = 0; i < index; i++) {
            list.add(new UserSearch(id++,"壮年", Math.random()>0.5?1:0, "黄晓明",(int)(Math.random()*100),  "18467163823@163.com"));
            list.add(new UserSearch(id++,"少妇", Math.random()>0.5?1:0, "杨幂",(int)(Math.random()*100),  "18467163823@163.com"));
            list.add(new UserSearch(id++,"中年", Math.random()>0.5?1:0, "葛优",(int)(Math.random()*100), "18467163823@163.com"));
            list.add(new UserSearch(id++,"青年", Math.random()>0.5?1:0, "杨颖",(int)(Math.random()*100),  "18467163823@163.com"));
            list.add(new UserSearch(id++,"青年", Math.random()>0.5?1:0, "关晓彤",(int)(Math.random()*100), "18467163823@163.com"));
            list.add(new UserSearch(id++,"青年", Math.random()>0.5?1:0, "关晓彤",(int)(Math.random()*100),   "18467163823@163.com"));
            list.add(new UserSearch(id++,"少妇", Math.random()>0.5?1:0, "韩红",(int)(Math.random()*100), "18467163823@163.com"));
            list.add(new UserSearch(id++,"壮年", Math.random()>0.5?1:0, "吴京",(int)(Math.random()*100), "18467163823@163.com"));
            list.add(new UserSearch(id++,"中年", Math.random()>0.5?1:0, "刘妍妍",(int)(Math.random()*100), "18467163823@163.com"));
        }
        long lll = System.currentTimeMillis();
        System.out.println("====================="+(lll-l));
        userRepository.saveAll(list);
        long ll = System.currentTimeMillis();
        System.out.println("====================="+(ll-l));

    }

    @Test
    public void testFind() {
        //测试查询
        Iterable<UserSearch> all = userRepository.findAll();
        for (UserSearch user: all) {
            System.out.println(user);
        }
        System.out.println("=================");
    }

    @Test
    public void testFindByCondation() {
        //测试查询
//        List<UserSearch> all= userRepository.findAllByAgeBetween(18, 25);
        List<UserSearch> all= userRepository.findAllByAgeBetweenAndSex(18, 25,0);
        for (UserSearch user : all) {
            System.out.println(user);
        }
    }

    @Test
    public void testDelete() {
        //测试查询和删除
        //黄晓明  杨幂 葛优  杨颖  关晓彤 韩红 吴京  刘妍妍
//        Iterable<UserSearch> all = userRepository.findAllByNameIsLike("%杨幂%");
//        List<UserSearch> all = userRepository.findAllByNameIsLike("%杨幂%");
//        List<UserSearch> all = userRepository.findAllByName(" 杨幂");
        Iterable<UserSearch> all = userRepository.findAll();
        userRepository.deleteAll(all);
        System.out.println("=================");
    }

    @Test
    public void testQuery1() {
        //测试原生复杂查询
//        new NativeSearchQuery()
//       itemRepository.search(SearchQuery)
//        MatchQueryBuilder matchQuery = QueryBuilders.matchQuery("title", "小米手机");
        MatchQueryBuilder matchQuery = QueryBuilders.matchQuery("name", "吴京");
        Iterable<UserSearch> search = userRepository.search(matchQuery);
        search.forEach(userSearch -> {
            System.out.println(userSearch);
            userRepository.delete(userSearch);
        });
        System.out.println(search);
    }

    @Test
    public void testQuery2() {
        NativeSearchQueryBuilder builder = new NativeSearchQueryBuilder();
        //添加结果过滤条件
        builder.withFields("type","sex","name","age");
        //添加查询条件
        builder.withQuery(QueryBuilders.matchQuery("type", "少妇"));
        //添加排序条件
        builder.withSort(SortBuilders.fieldSort("age").order(SortOrder.DESC));
        //分页
//        PageRequest pageRequest =;
        builder.withPageable( PageRequest.of(0, 1000));
        Page<UserSearch> itemPage = userRepository.search(builder.build());
        //获取总数量
        long totalElements = itemPage.getTotalElements();
        System.out.println("totalElements"+totalElements);
        //获取总页数
        int totalPages = itemPage.getTotalPages();
        System.out.println("totalPages"+totalPages);
        //获取当前页集合
        List<UserSearch> content = itemPage.getContent();
        content.stream().forEach(System.out::println);
//        //获取分页排序方式
//        Sort sort = itemPage.getSort();
//        System.out.println("sort"+sort);

    }

    @Test
    public void testAggs() {
        NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder();
        queryBuilder.addAggregation(AggregationBuilders.terms("brand").field("brand"));
        AggregatedPage<User> queryForPage = template.queryForPage(queryBuilder.build(), User.class);
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