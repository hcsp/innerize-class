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

    interface NameCollector extends Consumer<User> {
        List<String> names = new ArrayList<>();
        List<String> getNames();
    }

    public static List<String> collectNames(List<User> users) {
        NameCollector collector = new NameCollector() {
            List<String> names = new ArrayList<>();
            @Override
            public void accept(User user) {
                names.add(user.getName());
            }
            public List<String> getNames() {
                return names;
            }
        };
        users.forEach(collector);
        return collector.getNames();
    }

    public static void main(String[] args) {
        List<User> users = Arrays.asList(new User(1, "a"), new User(2, "b"));
        System.out.println(collectNames(users));
    }
}
