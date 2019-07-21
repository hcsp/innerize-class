package com.github.hcsp.polymorphism;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class User {
    /** 用户ID，数据库主键，全局唯一 */
    private final Integer id;

    /** 用户名 */
    private final String name;

    public User(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    // 这里使用了一个NameCollector类，请尝试将它改写成匿名内部类
    // 使得代码更加集中，更加容易阅读
    public static List<String> collectNames(List<User> users) {
        List<String> names = new ArrayList<>();

        // users.forEach(user -> names.add(user.getName()));
        // return names;

        users.forEach(new Consumer<User>() {
            @Override
            public void accept(User user) {
                names.add(user.getName());
            }
        });
        return names;
    }

    public static void main(String[] args) {
        List<User> users = Arrays.asList(new User(1, "a"), new User(2, "b"));
        System.out.println(collectNames(users));
    }
}
