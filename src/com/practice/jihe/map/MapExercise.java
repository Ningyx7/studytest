package com.practice.jihe.map;

import java.util.*;

public class MapExercise {
    public static void main(String[] args) {
        /**使用HashMap添加3个员工对象，要求：
         *  键：员工id
         *  值：员工对象
         *
         * 并遍历显示工资>18000的员工（遍历方式最少两种）
         * 员工类：姓名、工资、员工id
         * */

        Map map = new HashMap();
        map.put(1, new Employee(1, "张三", 7000));
        map.put(2, new Employee(2, "李四", 19000));
        map.put(3, new Employee(3, "王五", 20000));

        System.out.println("========keySet遍历输出sal>18000========");
        Set set = map.keySet();
        for (Object key : set) {
            if (((Employee) map.get(key)).getSalary() > 18000) {
                System.out.println(key + "-" + map.get(key));
            }
        }
        System.out.println("---------------");
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Object key = iterator.next();
            if (((Employee) map.get(key)).getSalary() > 18000) {
                System.out.println(map.get(key));
            }
        }

        System.out.println("========values遍历输出sal>18000========");
        Collection values = map.values();
        for (Object value : values) {
            if (((Employee) value).getSalary() > 18000) {
                System.out.println(value);
            }
        }
        System.out.println("----------------");
        Iterator iterator1 = values.iterator();
        while (iterator1.hasNext()) {
            Employee emp = (Employee) iterator1.next();
            if (emp.getSalary() > 18000) {
                System.out.println(emp);
            }
        }

        System.out.println("========entrySet遍历输出sal>18000========");
        Set entrySet = map.entrySet();
        for (Object o : entrySet) {
            Map.Entry entry = (Map.Entry) o;
            if (((Employee) entry.getValue()).getSalary() > 18000) {
                System.out.println(entry.getKey() + "-" + entry.getValue());
            }
        }
        System.out.println("-------------");
        Iterator iterator2 = entrySet.iterator();
        while (iterator2.hasNext()) {
            Map.Entry entry =  (Map.Entry) iterator2.next();
            if (((Employee)entry.getValue()).getSalary()>18000) {
                System.out.println(entry.getKey()+"-"+entry.getValue());
            }
        }

    }
}

class Employee {
    private Integer id;
    private String name;
    private double salary;

    public Employee() {
    }

    public Employee(Integer id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}
