package com.stu.algorithm.binaryTree;

import com.alibaba.fastjson.JSONObject;

import java.util.HashSet;

/**
 * @Author wangyixing
 * @Description
 */
public class Demo5 {

    private Node head = new Node(0, "");

    private void addNode(Node node) {

    }

    private void addNodeByOrder(Node node) {
        if (head.next == null) {
            head.next = node;
            head = head.next;
            return;
        }


    }

    public static void main(String[] args) {
        char[] array = new char[]{'a', 'c'};
        String s = array.toString();
    }



}


class Node {
    int id;
    String name;
    Node next;
    public Node(int id, String name) {
        this.id = id;
        this.name = name;
    }
    @Override
    public String toString() {
        return "Node{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
