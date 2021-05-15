//package com.example.demo.linkedCollection;
//
//
//import java.util.LinkedList;
//
///**
// * @Description:
// *      jdk1.8的LinkedList是简单的双向非循环链表
// * @Author HeSuiJin
// * @Date 2021/5/15
// */
//public class DoublyLinkedList {
//
//    //初始化 无头节点（头节点为空）
//    private NodeDoubly first ;
//
//    //初始化 无尾节点（尾节点为空）
//    private NodeDoubly last ;
//
//    //无头结点
//    //表头部插入
//    public void insertAsfirst(int value) {
//
//        NodeDoubly newNodeDoubly = new NodeDoubly(null,value,null );
//        insertTofirst(newNodeDoubly);
//    }
//
//    //表头部插入头节点  同时尾节点也头节点
//    private void insertTofirst(NodeDoubly newNodeDoubly) {
//
//        //同时创建一个头节点 一个尾节点
//        if (first == null) {
//            first = newNodeDoubly;
//            last =  new NodeDoubly(first,newNodeDoubly.data,null );
//            first.next = last;
//
//        } else {
//            //新节点 next 指向 原first
//            newNodeDoubly.next = first;
//            //原first pre   指向 新节点
//            first.prev = newNodeDoubly;
//            //新节点 替换 原节点
//            first = newNodeDoubly;
//        }
//    }
//
//    //在某节点上前 插入新节点
//    public void insertBefore(NodeDoubly originalNodeDoubly, int value) {
//        NodeDoubly newNodeDoubly = new NodeDoubly(null,value, null);
//        insertBefore(originalNodeDoubly, newNodeDoubly);
//    }
//
//    private void insertBefore(NodeDoubly originalNodeDoubly, NodeDoubly newNodeDoubly) {
//        if (originalNodeDoubly == null) {
//            return;
//        }
//
//        //判断原有节点是否为头节点
//        if (first == originalNodeDoubly) {
//            insertTofirst(newNodeDoubly);
//            return;
//        }
//
//        //以头节点开始 使用next进行遍历 一直获取到
//        // 遍历节点 的下一个节点为原节点为止
//        NodeDoubly indexNodeDoubly = first;
//        while (indexNodeDoubly != null && indexNodeDoubly.next != originalNodeDoubly) {
//            indexNodeDoubly = indexNodeDoubly.next;
//        }
//
//        if (indexNodeDoubly == null) {
//            return;
//        }
//        //最后顺序  遍历节点   新节点   某节点
//        //实现了    新节点插入到原节点之前的功能
//        newNodeDoubly.next = originalNodeDoubly;
//        originalNodeDoubly.prev = newNodeDoubly;
//
//        indexNodeDoubly.next = newNodeDoubly;
//        newNodeDoubly.prev = indexNodeDoubly;
//
//    }
//
//
//    //顺序插入
//    //链表尾部插入
//    public void insertTail(int value) {
//
//        NodeDoubly newNodeDoubly = new NodeDoubly(null,value, null);
//        //空链表，可以插入新节点作为first，也可以不操作
//        if (first == null) {
//            first = newNodeDoubly;
//            first.next = last;
//            last.prev = first;
//        } else {
//            NodeDoubly indexNodeDoubly = first;
//            while (indexNodeDoubly.next != null) {
//                indexNodeDoubly = indexNodeDoubly.next;
//            }
//            //获取到indexNode为最后一个节点
//            //遍历节点  新节点(尾节点)   空
//            indexNodeDoubly.next = newNodeDoubly;
//            newNodeDoubly.prev = indexNodeDoubly;
//
//            newNodeDoubly.prev;
//        }
//    }
//
//    public void deleteByNode(NodeDoubly originalNodeDoubly) {
//        if (originalNodeDoubly == null || first == null) {
//            return;
//        }
//
//        if (originalNodeDoubly == first) {
//            first = null;
//            return;
//        }
//
//        NodeDoubly indexNodeDoubly = first;
//
//        //以头节点开始 使用next进行遍历 一直获取到
//        // 遍历节点 的下一个节点为原节点为止
//        while (indexNodeDoubly != null && indexNodeDoubly.next != originalNodeDoubly) {
//            indexNodeDoubly = indexNodeDoubly.next;
//        }
//
//        if (indexNodeDoubly == null) {
//            return;
//        }
//
//        //获取到  遍历节点  某节点
//        //最后    遍历节点   直接指向  遍历节点的下个节点（原节点）的下一个节点
//        //        遍历节点的下个节点（原节点）的下一个节点  的前节点  指向新节点
//        //实现了  被删除的某节点就会被跳过
//        indexNodeDoubly.next = indexNodeDoubly.next.next;
//        indexNodeDoubly.next.prev = indexNodeDoubly;
//    }
//
//    //根据value删除节点
//    public void deleteByValue(int value){
//
//        NodeDoubly indexNodeDoubly = first;
//        //外部接口调用 第一次为从  头节点进行遍历
//        deleteByValueRepetition(value, indexNodeDoubly);
//    }
//
//    //通过递归  根据value  删除所有拥有该value的节点
//    public void deleteByValueRepetition(int value, NodeDoubly indexNodeDoubly) {
//        if (first == null) {
//            return;
//        }
//
//        NodeDoubly beforeIndexNodeDoubly = null;
//        // 以头节点开始 使用next进行遍历 一直到获取到为止
//        // 遍历节点 的 data 为所需要查找的data为止
//        // 该遍历节点是需要删除的  因此还需要查找出前一个节点
//        while (indexNodeDoubly != null && indexNodeDoubly.data != value) {
//            beforeIndexNodeDoubly = indexNodeDoubly;
//            indexNodeDoubly = indexNodeDoubly.next;
//        }
//
//        if (indexNodeDoubly == null) {
//            return;
//        }
//
//        //查找到data的节点为 头节点
//        if (beforeIndexNodeDoubly == null) {
//            first = null;
//        } else {
//            beforeIndexNodeDoubly.next = beforeIndexNodeDoubly.next.next;
//            beforeIndexNodeDoubly.next.prev = beforeIndexNodeDoubly;
//        }
//
//        //对于向媒体的value 可以进行递归删除
//        deleteByValueRepetition(value, beforeIndexNodeDoubly);
//    }
//
//    //查找节点的data
//    public NodeDoubly findByValueFirst(int value) {
//        NodeDoubly indexNodeDoubly = first;
//        while (indexNodeDoubly != null && indexNodeDoubly.data != value) {
//            indexNodeDoubly = indexNodeDoubly.next;
//        }
//        return indexNodeDoubly;
//    }
//
//    //查找节点的data
//    public NodeDoubly findByValueLast(int value) {
//        NodeDoubly indexNodeDoubly = first;
//        while (indexNodeDoubly != null && indexNodeDoubly.data != value) {
//            indexNodeDoubly = indexNodeDoubly.next;
//        }
//        return indexNodeDoubly;
//    }
//
//    //打印所有数据
//    public void findAll() {
//        NodeDoubly p = first;
//        while (p != null) {
//            System.out.print(p.data + " ");
//            p = p.next;
//        }
//        System.out.println();
//    }
//}
