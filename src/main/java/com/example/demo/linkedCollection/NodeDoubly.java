package com.example.demo.linkedCollection;


/**
 * @Description:
 * @Author HeSuiJin
 * @Date 2021/5/15
 */
//Node数据类型  里面  有两个Node数据类型的数据  (分别为 上一个节点 下一个节点)
public class NodeDoubly<E> {

    E data;
    NodeDoubly<E> next;
    NodeDoubly<E> prev;

    public NodeDoubly(NodeDoubly<E> prev, E data, NodeDoubly<E> next) {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }

}
