package com.liujie;


//import com.liujie.repository.UserRepository;
import com.liujie.dao.UserDao;
import com.liujie.pojo.user.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ServerApplication.class)
public class SqlUserTest {

    @Autowired
    private UserDao userDao;

    @Test
    public void testSaveAll(){
        long l = System.currentTimeMillis();
        //添加数据
        List<User> list = new ArrayList<>();
        int id = 1;
        int index = 100;
        for (int i = 0; i < index; i++) {
            list.add(new User(id++,"壮年", Math.random()>0.5?1:0, "黄晓明",(int)(Math.random()*100),  "18467163823@163.com"));
            list.add(new User(id++,"少妇", Math.random()>0.5?1:0, "杨幂",(int)(Math.random()*100),  "18467163823@163.com"));
            list.add(new User(id++,"中年", Math.random()>0.5?1:0, "葛优",(int)(Math.random()*100), "18467163823@163.com"));
            list.add(new User(id++,"青年", Math.random()>0.5?1:0, "杨颖",(int)(Math.random()*100),  "18467163823@163.com"));
            list.add(new User(id++,"青年", Math.random()>0.5?1:0, "关晓彤",(int)(Math.random()*100), "18467163823@163.com"));
            list.add(new User(id++,"青年", Math.random()>0.5?1:0, "关晓彤",(int)(Math.random()*100),   "18467163823@163.com"));
            list.add(new User(id++,"少妇", Math.random()>0.5?1:0, "韩红",(int)(Math.random()*100), "18467163823@163.com"));
            list.add(new User(id++,"壮年", Math.random()>0.5?1:0, "吴京",(int)(Math.random()*100), "18467163823@163.com"));
            list.add(new User(id++,"中年", Math.random()>0.5?1:0, "刘妍妍",(int)(Math.random()*100), "18467163823@163.com"));
        }
        long lll = System.currentTimeMillis();
        System.out.println("====================="+(lll-l));
        userDao.saveAll(list);
        long ll = System.currentTimeMillis();
        System.out.println("====================="+(ll-l));

    }

    @Test
    public void testFind() {
        //测试查询
        Iterable<User> all = userDao.findAll();
        for (User user: all) {
            System.out.println(user);
        }
        System.out.println("=================");
//        List<User> all1 = userDao.findAllByPriceBetween(3000.0, 7000.0);
//        for (User user : all1) {
//            System.out.println(user);
//        }
    }

    @Test
    public void testQuery1() {
        //测试原生复杂查询
        List<User> list = userDao.findAllByName("刘妍妍");
        System.out.println(list);
    }

    @Test
    public void testQuery2() {
        //获取分页

    }

    @Test
    public void testAggs() {

    }


}