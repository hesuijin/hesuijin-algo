package com.example.demo.stack;

/**
 * @Description:
 * @Author HeSuiJin
 * @Date 2021/5/13
 */
public class ArrayStack {

    //栈默认存储空间
    private char[] data = new char[10];

    //实际存储元素个数
    private int count = 0;

    public int getCount(){
        return count;
    }

    public void push(char value) {
        if (data.length == count) {
            capital();
        }
        data[count] = value;
        count++;
    }

    private void capital() {
        char[] dataTemp = new char[data.length * 2];
        for (int i = 1; i < data.length; i++) {
            dataTemp[i] = data[i];
        }
        data = dataTemp;
    }

    public char pop() {
        if(count == 0){
            throw new IllegalArgumentException("右边括号数量多于左边括号");
        }

        count--;
        char str = data[count];
        return str;
    }
}
