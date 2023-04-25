package com.practice.test;

public class Test01 {
    /**
     *  实现一个双向链表
     * */
    public static void main(String[] args) {
        Node node1 = new Node("节点1");
        Node node2 = new Node("节点2");
        Node node3 = new Node("节点3");
        Node node4 = new Node("节点4");
        Node node5 = new Node("节点5");
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;
        node5.prev=node4;
        node4.prev=node3;
        node3.prev=node2;
        node2.prev=node1;

        Node first = node1;

        while (true){
            System.out.println(first);
            first=first.next;
            if (first.next==null) {
                System.out.println(first);
                break;
            }
        }

    }

}
class Node{
    public Node prev;
    public Node next;
    public String name;

    public Node(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
