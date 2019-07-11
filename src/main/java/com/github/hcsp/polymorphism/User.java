package com.github.hcsp.polymorphism;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

//实现用匿名内部类为对象传递参数
  public class User{
       private  int age;
       private String name;

      public User(int age,String name) {
          this.age=age;
          this.name = name;
      }

    public String getName() {
          return name;
      }

    public static List<String> collectNames(List<User> users) {
          List<String> userNames = new ArrayList<>();
          Consumer consumer = new Consumer<User>() {
              @Override
              public void accept(User user) {
                  userNames.add(user.getName());
              }
              public List<String> getNames() {
                  return userNames;
              }
          };
          users.forEach(consumer);//forEach() 方法用于调用数组的每个元素，并将元素传递给回调函数。
          return userNames;
          }
      }

