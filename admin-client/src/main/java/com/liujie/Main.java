package com.liujie;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ArrayList<User> list = new ArrayList<>();
        list.add(new User().setId(1).setTime(new Date()));
        Thread.sleep(5000);
        list.add(new User().setId(5).setTime(new Date()));
        Thread.sleep(5000);
        list.add(new User().setId(6).setTime(new Date()));
        Thread.sleep(5000);
        list.add(new User().setId(3).setTime(new Date()));
        Thread.sleep(5000);

//        Stream<User> sorted = list.stream().sorted(Comparator.comparing(User::getId).reversed());
        list.stream().sorted(Comparator.comparing(User::getTime).reversed())
                .forEach(user -> System.out.println(user.getTime().getTime()));

    }
}


class User{
    private Integer id;
    private Date time;

    public Integer getId(){
        return this.id;
    }
    public User setId(Integer id){
        this.id = id;
        return this;
    }

    public Date getTime(){
        return this.time;
    }
    public User setTime(Date time){
        this.time = time;
        return this;
    }
}
