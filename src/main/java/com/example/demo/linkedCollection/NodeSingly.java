package com.example.demo.linkedCollection;

/**
 * @Description:
 * @Author HeSuiJin
 * @Date 2021/5/13
 */
//Node数据类型  里面  有一个Node数据类型的数据(下一个节点)
public class NodeSingly {
    public int data;
    public NodeSingly next = null;

    public NodeSingly(int data, NodeSingly next) {
        this.data = data;
        this.next = next;
    }

    public int getData() {
        return data;
    }
}