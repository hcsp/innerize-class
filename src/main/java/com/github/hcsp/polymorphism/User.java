package com.github.hcsp.polymorphism;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    // 将 NameCollector 改写为匿名内部类
    public static List<String> collectNames(List<User> users) {
        List<String> names = new ArrayList<>();
        users.forEach(new java.util.function.Consumer<User>() {
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
