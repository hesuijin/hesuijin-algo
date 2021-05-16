package com.example.demo.linkedCollection;

/**
 * @Description:单链表 新节点初始化时 其next的指向都是不确定的  需要其他节点赋予
 * 插入时 新节点指向原位置的节点
 * @Author HeSuiJin
 * @Date 2021/5/14
 */
public class SinglyLinkedList {

    //初始化 无头节点（头节点为空）
    private NodeSingly head = null;

    //表头部插入
    public void insertAsHead(int value) {
        NodeSingly newNodeSingly = new NodeSingly(value, null);
        insertToHead(newNodeSingly);
    }

    //表头部插入头节点
    private void insertToHead(NodeSingly newNodeSingly) {
        if (head == null) {
            head = newNodeSingly;
        } else {
            newNodeSingly.next = head;
            head = newNodeSingly;
        }
    }


    //在某节点上前 插入新节点
    public void insertBefore(NodeSingly originalNodeSingly, int value) {
        NodeSingly newNodeSingly = new NodeSingly(value, null);
        insertBefore(originalNodeSingly, newNodeSingly);
    }

    private void insertBefore(NodeSingly originalNodeSingly, NodeSingly newNodeSingly) {
        if (originalNodeSingly == null) {
            return;
        }

        //判断原有节点是否为头节点
        if (head == originalNodeSingly) {
            insertToHead(newNodeSingly);
            return;
        }

        //以头节点开始 使用next进行遍历 一直到获取到
        // 遍历节点 的下一个节点为需要查找的某节点为止
        NodeSingly indexNodeSingly = head;
        while (indexNodeSingly != null && indexNodeSingly.next != originalNodeSingly) {
            indexNodeSingly = indexNodeSingly.next;
        }

        if (indexNodeSingly == null) {
            return;
        }
        //最后顺序  遍历节点   新节点   某节点
        //实现了    新节点插入到原节点之前的功能
        newNodeSingly.next = originalNodeSingly;
        indexNodeSingly.next = newNodeSingly;

    }


    //顺序插入
    //链表尾部插入
    public void insertTail(int value) {

        NodeSingly newNodeSingly = new NodeSingly(value, null);
        //空链表，可以插入新节点作为head，也可以不操作
        if (head == null) {
            head = newNodeSingly;

        } else {
            NodeSingly indexNodeSingly = head;
            while (indexNodeSingly.next != null) {
                indexNodeSingly = indexNodeSingly.next;
            }
            //获取到indexNode为最后一个节点
            //遍历节点  新节点(尾节点)   空
            indexNodeSingly.next = newNodeSingly;
        }
    }


    public void deleteByNode(NodeSingly originalNodeSingly) {
        if (originalNodeSingly == null || head == null) {
            return;
        }

        if (originalNodeSingly == head) {
            head = head.next;
            return;
        }

        NodeSingly indexNodeSingly = head;

        //以头节点开始 使用next进行遍历 一直获取到
        // 遍历节点 的下一个节点为原节点为止
        while (indexNodeSingly != null && indexNodeSingly.next != originalNodeSingly) {
            indexNodeSingly = indexNodeSingly.next;
        }

        if (indexNodeSingly == null) {
            return;
        }

        //获取到  遍历节点  某节点
        //最后    遍历节点   直接指向  遍历节点的下个节点（原节点）的下一个节点
        //实现了  被删除的某节点就会被跳过
        indexNodeSingly.next = indexNodeSingly.next.next;
    }

    //根据value删除节点
    public void deleteByValue(int value){

        NodeSingly indexNodeSingly = head;
        //外部接口调用 第一次为从  头节点进行遍历
        deleteByValueRepetition(value, indexNodeSingly);
    }

    //通过递归  根据value  删除所有拥有该value的节点
    public void deleteByValueRepetition(int value, NodeSingly indexNodeSingly) {
        if (head == null) {
            return;
        }

        NodeSingly beforeIndexNodeSingly = null;
        // 以头节点开始 使用next进行遍历 一直到获取到为止
        // 遍历节点 的 data 为所需要查找的data为止
        // 该遍历节点是需要删除的  因此还需要查找出前一个节点
        while (indexNodeSingly != null && indexNodeSingly.data != value) {
            beforeIndexNodeSingly = indexNodeSingly;
            indexNodeSingly = indexNodeSingly.next;
        }

        if (indexNodeSingly == null) {
            return;
        }

        //查找到data的节点为 头节点
        if (beforeIndexNodeSingly == null) {
            head = head.next;
        } else {
            beforeIndexNodeSingly.next = beforeIndexNodeSingly.next.next;
        }

        //对于向媒体的value 可以进行递归删除
        deleteByValueRepetition(value, beforeIndexNodeSingly);
    }

    //查找节点的data
    public NodeSingly findByValue(int value) {
        NodeSingly indexNodeSingly = head;
        while (indexNodeSingly != null && indexNodeSingly.data != value) {
            indexNodeSingly = indexNodeSingly.next;
        }
        return indexNodeSingly;
    }

    //打印所有数据
    public void findAll() {
        NodeSingly p = head;
        while (p != null) {
            System.out.print(p.data + " ");
            p = p.next;
        }
        System.out.println();
    }
}
