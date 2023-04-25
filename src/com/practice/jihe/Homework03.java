package com.practice.jihe;

import org.junit.jupiter.api.Test;

import java.util.*;

public class Homework03 {
    /**
     * 定义个泛型类DAO<T>,在其中定义一个Map成员变量，Map的键为String类型，值为T类型。
     * 分别创建以下方法:
     * (1) public void save(String id,T entity):保存T类型的对象到Map成员变量中
     * (2) public T get(String id):从map中获取id对应的对象
     * (3) public void update(String id,T entity):替换map中key为id的内容，改为entity对象
     * (4) public List<T> list():返回map中存放的所有T对象
     * (5) public void delete(String id):删除指定id对象
     * 定义一个User类:
     * 该类包含: private成员变量(int类型) id, age; (String 类型) name
     * 创建DAO类的对象，分别调用其save、get、 update、 list、 delete 方法来操作User对象，
     * 使用Junit单元测试类进行测试。
     */

    @Test
    public void testJunit() {
        Dao<User> dao = new Dao<>();
        dao.save("1", new User(1, 16, "张三"));
        dao.save("2", new User(2, 25, "李四"));
        dao.showMap();
        System.out.println(dao.get("1"));
        dao.update("1",new User(1, 16, "张三2"));
        System.out.println(dao.list());
        dao.delete("1");
        dao.showMap();
    }

}

class Dao<T> {
    Map<String, T> map=new HashMap();

    public void showMap() {
        System.out.println(map);
    }

    public void save(String id, T entity) {//保存T类型的对象到Map成员变量中
        map.put(id, entity);
    }

    public T get(String id) {//从map中获取id对应的对象
        T t = map.get(id);
        return t;
    }

    public void update(String id, T entity) {//替换map中key为id的内容，改为entity对象
        map.put(id, entity);
    }

    public List<T> list() {//返回map中存放的所有T对象
        Set<String> keySet = map.keySet();
        List<T> list = new ArrayList<>();
        for (String key : keySet) {
            T t = map.get(key);
            list.add(t);
        }
        return list;
    }

    public void delete(String id) {//删除指定id对象
        map.remove(id);
    }
}

class User {
    private int id;
    private int age;
    private String name;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User() {
    }

    public User(int id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }
}