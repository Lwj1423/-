package com.example.demo.entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Test {

    public static void main(String[] args) {

        User testA1 = new User("老张", 3);
        User testA2 = new User("老李", 1);
        User testA3 = new User("老王", 2);
        List<User> list  = new ArrayList<>();
        list.add(testA1);
        list.add(testA2);
        list.add(testA3);
        System.out.println("排序前--:"+list.toString());
        Collections.sort(list, new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                //升序
                return o1.getRegisterTime().compareTo(o2.getRegisterTime());
            }
        });
        System.out.println("升序排序后--:"+list.toString());

        Collections.sort(list, new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                //升序
                return o2.getRegisterTime().compareTo(o1.getRegisterTime());
            }
        });
        System.out.println("降序排序后--:"+list.toString());

    }

}
