package com.example.demo.linkedCollection;


/**
 * @Description:
 *      jdk1.8的LinkedList是简单的双向非循环链表
 * @Author HeSuiJin
 * @Date 2021/5/15
 */
public class DoublyLinkedList<E> {

    //初始化 无头节点（头节点为空）
    private NodeDoubly<E> first ;

    //初始化 无尾节点（尾节点为空）
    private NodeDoubly<E> last ;

    //无头结点
    //表头部插入
    public void insertAsfirst(E value) {
        NodeDoubly<E> newNodeDoubly = new NodeDoubly(null,value,null );
        insertTofirst(newNodeDoubly);
    }

//    LinkedList源码阅读
//    首次插入：
//    1：f = null
//    2： 新节点的next 指向 null
//    3：first  等于新节点
//    4：如果 f 为 null ：  last 也等于新节点
//
//
//    之后插入：
//    1：f 不为null
//    2：新节点 的next 指向 f 原头节点
//    3：first 等于新节点  （next 指向 f 原头节点）
//    4：如果 f 不为 null ： f 原头节点 的prev 指向新节点
//
//    private void linkFirst(E e) {
//        final Node<E> f = first;
//        final Node<E> newNode = new Node<>(null, e, f);
//        first = newNode;
//        if (f == null)
//            last = newNode;
//        else
//            f.prev = newNode;
//        size++;
//        modCount++;
//    }

    //表头部插入头节点  同时尾节点也头节点
    //注意 first 与 last 一开始会指向相同的节点
    //假如修改了first 的地址指向    last还是指向原节点
    private void insertTofirst(NodeDoubly newNodeDoubly) {
        //创建一个节点该节点同时为 头节点与尾节点
        if (first == null) {
            first = newNodeDoubly;
            last = newNodeDoubly;
        } else {
            //新节点 next 指向 原first
            newNodeDoubly.next = first;
            //原first pre   指向 新节点
            first.prev = newNodeDoubly;
            //first变量名的 指针指向 变为新节点
            first = newNodeDoubly;
        }
    }


    //在某节点上前 插入新节点
    public void insertBefore(NodeDoubly originalNodeDoubly, E value) {
        NodeDoubly<E> newNodeDoubly = new NodeDoubly(null,value, null);
        insertBefore(originalNodeDoubly, newNodeDoubly);
    }

    private void insertBefore(NodeDoubly originalNodeDoubly, NodeDoubly<E> newNodeDoubly) {
        if (originalNodeDoubly == null) {
            return;
        }

        //判断原有节点是否为头节点
        if (first == originalNodeDoubly) {
            insertTofirst(newNodeDoubly);
            return;
        }

        //以头节点开始 使用next进行遍历 一直到获取到
        // 遍历节点 的下一个节点为需要查找的某节点为止
        NodeDoubly<E> indexNodeDoubly = first;
        while (indexNodeDoubly != null && indexNodeDoubly.next != originalNodeDoubly) {
            indexNodeDoubly = indexNodeDoubly.next;
        }

        if (indexNodeDoubly == null) {
            return;
        }

        //最后顺序  遍历节点   新节点   某节点
        //实现了    新节点插入到原节点之前的功能
        newNodeDoubly.next = originalNodeDoubly;
        originalNodeDoubly.prev = newNodeDoubly;

        indexNodeDoubly.next = newNodeDoubly;
        newNodeDoubly.prev = indexNodeDoubly;

    }

    //顺序插入
    //链表尾部插入
    public void insertAsLast(E value) {
        NodeDoubly<E> newNodeDoubly = new NodeDoubly(null,value,null );

        //创建一个节点该节点同时为 头节点与尾节点
        if (last == null) {
            first = newNodeDoubly;
            last = newNodeDoubly;
        } else {
            //新节点 next 指向 原last
            newNodeDoubly.prev = last;
            //原last next   指向 新节点
            last.next = newNodeDoubly;
            //last变量名的 指针指向 变为新节点
            last = newNodeDoubly;
        }
    }


    public void deleteByNode(NodeDoubly originalNodeDoubly) {
        if (originalNodeDoubly == null || first == null && last == null) {
            return;
        }

        if (originalNodeDoubly == first) {
           if(first == last){
               last = null;
           }
            first = first.next;
            first.prev = null;
            return;
        }

        if (originalNodeDoubly == last) {
            if(first == last){
                first = null;
            }
            last = last.prev;
            last.next = null;
            return;
        }

        NodeDoubly<E> indexNodeDoubly = first;

        //以头节点开始 使用next进行遍历 一直获取到
        // 遍历节点 的下一个节点为原节点为止
        while (indexNodeDoubly != null && indexNodeDoubly.next != originalNodeDoubly) {
            indexNodeDoubly = indexNodeDoubly.next;
        }

        if (indexNodeDoubly == null) {
            return;
        }

        //获取到  遍历节点  某节点
        //最后    遍历节点   直接指向  遍历节点的下个节点（原节点）的下一个节点
        //        遍历节点的下个节点（原节点）的下一个节点  的前节点  指向新节点
        //实现了  被删除的某节点就会被跳过
        indexNodeDoubly.next = indexNodeDoubly.next.next;
        indexNodeDoubly.next.prev = indexNodeDoubly;
    }

    //根据value删除节点
    public void deleteByValue(E value){

        NodeDoubly<E> indexNodeDoubly = first;
        //外部接口调用 第一次为从  头节点进行遍历
        deleteByValueRepetition(value, indexNodeDoubly);
    }

    //通过递归  根据value  删除所有拥有该value的节点
    public void deleteByValueRepetition(E value, NodeDoubly<E> indexNodeDoubly) {
        if (first == null && last == null) {
            return;
        }

        NodeDoubly<E> beforeIndexNodeDoubly = null;
        // 以头节点开始 使用next进行遍历 一直到获取到为止
        // 遍历节点 的 data 为所需要查找的data为止
        // 该遍历节点是需要删除的  因此还需要查找出前一个节点
        while (indexNodeDoubly != null && indexNodeDoubly.data != value) {
            beforeIndexNodeDoubly = indexNodeDoubly;
            indexNodeDoubly = indexNodeDoubly.next;
        }

        if (indexNodeDoubly == null) {
            return;
        }

        //查找到data的节点为 头节点
        if (beforeIndexNodeDoubly == null) {
            if(first == last){
                first = null;
                last = null;

            }else {
                first = first.next;
                first.prev = null;
            }
        } else {
            beforeIndexNodeDoubly.next = beforeIndexNodeDoubly.next.next;
            beforeIndexNodeDoubly.next.prev = beforeIndexNodeDoubly;
        }

        //对于向媒体的value 可以进行递归删除
        deleteByValueRepetition(value, beforeIndexNodeDoubly);
    }

    //查找节点的data
    public NodeDoubly<E> findByValueFirst(E value) {
        NodeDoubly<E> indexNodeDoubly = first;
        while (indexNodeDoubly != null && indexNodeDoubly.data != value) {
            indexNodeDoubly = indexNodeDoubly.next;
        }
        return indexNodeDoubly;
    }

    //查找节点的data
    public NodeDoubly<E> findByValueLast(E value) {
        NodeDoubly<E> indexNodeDoubly = last;
        while (indexNodeDoubly != null && indexNodeDoubly.data != value) {
            indexNodeDoubly = indexNodeDoubly.prev;
        }
        return indexNodeDoubly;
    }

    //打印所有数据
    public void findAll() {
        NodeDoubly<E> p = first;
        while (p != null) {
            System.out.print(p.data + " ");
            p = p.next;
        }
        System.out.println();
    }
}
