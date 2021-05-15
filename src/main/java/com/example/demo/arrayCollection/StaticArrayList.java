package com.example.demo.arrayCollection;

/**
 * @Description:
 * 静态ArrayList（确定容量）
 * 1：getLength()        获取空间大小
 * 2：getCount()         获取已有个数
 * 3：find（int index）  根据索引找到数据中的元素并返回
 * 4：findAll()          查询所有元素
 * 5：insert（int value）在数组尾部插入元素
 * 6：insertByIndex(int index, int value)  根据索引插入元素
 * 7:deleteByIndex(int index) 根据索引删除元素
 *
 * @Author HeSuiJin
 * @Date 2021/5/12
 */
public class StaticArrayList {

    //定义整型数据data保存数据
    public int data[];
    //定义数组长度
    private int capacity;
    //定义实际个数
    private int count;

    //构造方法，定义数组大小
    public StaticArrayList(int capacity) {
        this.data = new int[capacity];
        this.capacity = capacity;
        //一开始一个数都没有存所以为0
        this.count = 0;
    }

    //获取空间大小
    public int getLength(){
        return data.length;
    }

    //获取已有个数
    public int getCount(){
        return count;
    }

    //根据索引找到数据中的元素并返回
    public int find(int index) {
        if (index < 0 || index >= count) {
            return -1;
        }
        return data[index];
    }

    //查询所有元素
    public void findAll() {
        for (int i = 0; i < count; ++i) {
            System.out.print(data[i] + " ");
        }
        System.out.println();

    }

    //在数组尾部插入元素
    public boolean insert(int value){
        // 数组空间已满
        if (count == capacity) {
            System.out.println("没有可插入的位置");
            return false;
        }

        data[count] = value;
        ++count;
        return true;
    }

    //根据索引插入元素
    public boolean insertByIndex(int index, int value) {

        // 数组空间已满
        if (count == capacity) {
            System.out.println("没有可插入的位置");
            return false;
        }
        // 如果count还没满，那么就可以插入数据到数组中
        if (index < 0 || index > count) {
            System.out.println("位置不合法");
            return false;
        }
        // 位置合法
        //需要从数组最大的索引位置开始 各向上挪动一位
        //然后替换调需要插入的索引数据
        for (int i = count; i > index; --i) {
            data[i] = data[i - 1];
        }

        data[index] = value;
        ++count;
        return true;
    }

    //根据索引删除元素
    public boolean deleteByIndex(int index) {
        if (index < 0 || index >= count) {
            return false;
        }
        //从删除位置开始，将后面的元素向前移动一位
        for (int i = index + 1; i < count; ++i) {
            data[i - 1] = data[i];
        }

        --count;
        return true;
    }


}