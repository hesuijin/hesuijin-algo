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
        System.out.println("===================单向链表===================");
        SinglyLinkedListTest();
        //双向链表
        System.out.println("===================双向链表===================");
        DoublyLinkedListTest();
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

        NodeSingly nodeSinglyTemp9 = singlyLinkedList.findByValue(9);
        singlyLinkedList.deleteByNode(nodeSinglyTemp9);
        NodeSingly nodeSinglyTemp7 = singlyLinkedList.findByValue(7);
        singlyLinkedList.deleteByNode(nodeSinglyTemp7);
        singlyLinkedList.findAll();
        System.out.println("==============================================");
    }

    private static void DoublyLinkedListTest() {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        doublyLinkedList.insertAsfirst(5);
        doublyLinkedList.insertAsfirst(7);
        doublyLinkedList.insertAsfirst(9);
        //不同于单向链表从头部开始遍历 然后插入  双向链表可以直接从尾部进行插入
        doublyLinkedList.insertAsLast(10);
        doublyLinkedList.findAll();
        System.out.println("==============================================");

        //双向链表从头部开始遍历查找
//        NodeDoubly nodeDoublyTemp = doublyLinkedList.findByValueFirst(5);
        //双向链表从尾部开始遍历查找
        NodeDoubly nodeDoublyTemp = doublyLinkedList.findByValueLast(5);
        doublyLinkedList.insertBefore(nodeDoublyTemp,2);
        doublyLinkedList.insertBefore(nodeDoublyTemp,3);
        doublyLinkedList.insertBefore(nodeDoublyTemp,4);
        doublyLinkedList.insertBefore(nodeDoublyTemp,4);
        doublyLinkedList.insertBefore(nodeDoublyTemp,4);
        doublyLinkedList.insertBefore(nodeDoublyTemp,4);
        doublyLinkedList.findAll();
        System.out.println("==============================================");

        doublyLinkedList.deleteByNode(nodeDoublyTemp);
        doublyLinkedList.findAll();
        System.out.println("==============================================");

        doublyLinkedList.deleteByValue(4);
        doublyLinkedList.findAll();
        System.out.println("==============================================");

        NodeDoubly nodeDoublyTemp9 = doublyLinkedList.findByValueLast(9);
        doublyLinkedList.deleteByNode(nodeDoublyTemp9);
        NodeDoubly nodeDoublyTemp7 = doublyLinkedList.findByValueFirst(7);
        doublyLinkedList.deleteByNode(nodeDoublyTemp7);
        doublyLinkedList.findAll();
        System.out.println("==============================================");

    }
}
