package com.practice.jihe.map;

import java.util.*;

public class HashMapEx {
    /**
     * 已知一个 HashMap<Integer，User>集合， User 有 name（String）和 age（int）属性。请写一个方法实现对
     * HashMap 的排序功能，该方法接收 HashMap<Integer，User>为形参，返回类型为 HashMap<Integer，User>，
     * 要求对 HashMap 中的 User 的 age 倒序进行排序。排序时 key=value 键值对不得拆散。
     * 注意：要做出这道题必须对集合的体系结构非常的熟悉。HashMap 本身就是不可排序的，但是该道题偏偏让给
     * HashMap 排序，那我们就得想在 API 中有没有这样的 Map 结构是有序的，LinkedHashMap，对的，就是他，他是
     * Map 结构，也是链表结构，有序的，更可喜的是他是 HashMap 的子类，我们返回 LinkedHashMap<Integer,User>
     * 即可，还符合面向接口（父类编程的思想）。
     */
    public static void main(String[] args) {
        HashMap hashMap = new HashMap();
        hashMap.put(18, new User("张三", 18));
        hashMap.put(20, new User("李四", 20));
        hashMap.put(16, new User("王五", 16));
        System.out.println(hashMap);

        HashMap hashMap1 = hashMapSort(hashMap);
        System.out.println(hashMap1);
    }

    static HashMap hashMapSort(HashMap hashMap) {
        Set entrySet = hashMap.entrySet();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        List list = new ArrayList(entrySet);
        Collections.sort(list, new Comparator<Map.Entry>() {
            @Override
            public int compare(Map.Entry o1, Map.Entry o2) {
                return ((User) o2.getValue()).getAge() - ((User) o1.getValue()).getAge();
            }
        });
        for (Object entry : list) {
            System.out.println(((User) ((Map.Entry) entry).getValue()).toString());
        }
        return null;
    }

}

class User {
    private String name;
    private Integer age;

    public User() {
    }

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
