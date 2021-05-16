package com.example.demo.arrayCollection;

/**
 * @Description:
 * 动态ArrayList（自动扩容）
 * 1:getLength()         获取空间大小
 * 2:getCount()          获取已有个数
 * 3:get(int index)      获取对应 index 位置的元素
 * 4:set(int index, T e) 修改 index 位置的元素
 * 5: find(T e)          获取对应元素的下标, 未找到，返回 -1
 * 6:contains(T e)       查看数组是否包含元素e
 * 7:addFirst(T e)       向数组头插入元素
 * 8:addLast(T e)        向数组尾插入元素
 * 9:removeElement(T e)  删除 index 位置的元素，并返回
 * 10:removeFirst()      删除第一个元素
 * 11:removeLast()       删除末尾元素
 * 12:removeElement(T e) 从数组中删除指定元素
 *
 * @Author HeSuiJin
 * @Date 2021/5/12
 */
public class DynamicArrayList<T> {

    //存储数据
    private T[] data;
    //定义实际个数
    private int count;

    private int capacity;

    // 根据传入容量，构造Array
    public DynamicArrayList(int capacity) {
        data = (T[]) new Object[capacity];
        count = 0;
    }

    // 无参构造方法，默认数组容量为5
    public DynamicArrayList() {
        this(0);
    }

    // 获取空间大小
    public int getLength() {
        return data.length;
    }

    // 获取已有个数
    public int getCount() {
        return count;
    }


    // 获取对应 index 位置的元素
    public T get(int index) {
        checkIndex(index);
        return data[index];
    }

    // 修改 index 位置的元素
    public void set(int index, T e) {
        checkIndex(index);
        data[index] = e;
    }

    // 获取对应元素的下标, 未找到，返回 -1
    public int find(T e) {
        for ( int i = 0; i < count; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    // 查看数组是否包含元素e
    public boolean contains(T e) {
        for (int i = 0; i < count; i++) {
            if (data[i].equals(e)) {
                return true;
            }
        }
        return false;
    }


    // 在 index 位置，插入元素e
    public void add(int index, T e) {
        checkIndexForAdd(index);
        if(0 == index){
            this.capacity =5;
            data = (T[]) new Object[capacity];
        }

        // 如果当前元素个数等于数组容量，则将数组扩容为原来的2倍
        if (count == data.length) {
            resize(2 * data.length);
        }

        for (int i = count - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        count++;
    }

    // 向数组头插入元素
    public void addFirst(T e) {
        add(0, e);
    }

    // 向数组尾插入元素
    public void addLast(T e) {
        add(count, e);
    }


    // 删除 index 位置的元素，并返回
    public T remove(int index) {
        checkIndex(index);

        T ret = data[index];
        for (int i = index + 1; i < count; i++) {
            data[i - 1] = data[i];
        }
        count --;
        data[count] = null;

        // 缩容 如果此时实际的大小等于四分之一 则缩容
        if (count == data.length / 4 && data.length / 2 != 0) {
            resize(data.length / 2);
        }

        return ret;
    }

    // 删除第一个元素
    public T removeFirst() {
        return remove(0);
    }

    // 删除末尾元素
    public T removeLast() {
        return remove(count - 1);
    }

    // 从数组中删除指定元素
    public void removeElement(T e) {
        int index = find(e);
        if (index != -1) {
            remove(index);
        }
    }

    // 修改容量算法，时间复杂度 O(n)
    private void resize(int capacity) {
        T[] newData = (T[]) new Object[capacity];

        for (int i = 0; i < count; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }


    private void checkIndex(int index) {
        if (index < 0 || index >= count) {
            throw new IllegalArgumentException("校验index失败 index >=0 and index < count");
        }
    }

    private void checkIndexForAdd(int index) {
        if(index < 0 || index > count) {
            throw new IllegalArgumentException("新增失败 ! Require index >=0 and index <= count.");
        }
    }
}
