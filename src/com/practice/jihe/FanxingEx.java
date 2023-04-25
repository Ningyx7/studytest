package com.practice.jihe;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class FanxingEx {
    /**
     * 定义Employee类
     * 1)该类包含: private成员变量name,sal,birthday, 其中birthday为MyDate类的对
     * 象:
     * 2)为每一个属性定义getter, setter 方法:
     * 3)重写toString方法输出name, sal, birthday
     * 4) MyDate类包含: private成员变量month,day,year;并为每一个属性定义getter,
     * setter方法;
     * 5)创建该类的3个对象，并把这些对象放入ArrayList集合中(ArrayList 需使用泛
     * 型来定义)， 对集合中的元索进行排序，并遍历输出:
     * 排序方式:调用ArrayList 的sort方法，传入Comparator对象[使用泛型]，先按照
     * name排序，如果name相同，则按生日日期的先后排席，即: 定制排序 )
     */
    public static void main(String[] args) {
        List<Employee> list = new ArrayList<>();
        list.add(new Employee("c", 5500, new MyDate(2001, 5, 7)));
        list.add(new Employee("b", 6700, new MyDate(2003, 12, 15)));
        list.add(new Employee("a", 4200, new MyDate(1997, 7, 3)));
        list.add(new Employee("a", 4200, new MyDate(1998, 7, 3)));
        System.out.println(list);
        list.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                if (o1.getName().compareTo(o2.getName()) == 0) {
                    return o1.getMyDate().getYear() - o2.getMyDate().getYear();
                }
                return o1.getName().compareTo(o2.getName());
            }
        });
        System.out.println(list);

    }

}

class Employee {
    private String name;
    private double sal;
    private MyDate myDate;

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", sal=" + sal +
                ", myDate=" + myDate +
                '}';
    }

    public Employee() {
    }

    public Employee(String name, double sal, MyDate myDate) {
        this.name = name;
        this.sal = sal;
        this.myDate = myDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSal() {
        return sal;
    }

    public void setSal(double sal) {
        this.sal = sal;
    }

    public MyDate getMyDate() {
        return myDate;
    }

    public void setMyDate(MyDate myDate) {
        this.myDate = myDate;
    }
}

class MyDate {
    private int year;
    private int month;
    private int day;

    @Override
    public String toString() {
        return year + "-" + month + "-" + day;
    }

    public MyDate() {
    }

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }
}