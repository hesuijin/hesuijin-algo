package com.example.demo.linkedCollection;

import java.util.LinkedList;

/**
 * @Description:
 * @Author HeSuiJin
 * @Date 2021/5/15
 */
public class LinkedListDemo {
    public static void main(String[] args) {

        //单向链表
        SinglyLinkedListTest();

//        LinkedList
    }

    private static void SinglyLinkedListTest() {

        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.insertAsHead(1);
        singlyLinkedList.insertAsHead(5);
        singlyLinkedList.insertAsHead(7);
        singlyLinkedList.insertAsHead(9);
        singlyLinkedList.insertTail(10);
        singlyLinkedList.findAll();
        System.out.println("==============================================");

        NodeSingly nodeSinglyTemp = singlyLinkedList.findByValue(5);
        singlyLinkedList.insertBefore(nodeSinglyTemp,2);
        singlyLinkedList.insertBefore(nodeSinglyTemp,3);
        singlyLinkedList.insertBefore(nodeSinglyTemp,4);
        singlyLinkedList.insertBefore(nodeSinglyTemp,4);
        singlyLinkedList.insertBefore(nodeSinglyTemp,4);
        singlyLinkedList.insertBefore(nodeSinglyTemp,4);

        singlyLinkedList.findAll();
        System.out.println("==============================================");

        singlyLinkedList.deleteByNode(nodeSinglyTemp);
        singlyLinkedList.findAll();
        System.out.println("==============================================");

        singlyLinkedList.deleteByValue(4);
        singlyLinkedList.findAll();
        System.out.println("==============================================");
    }
}
