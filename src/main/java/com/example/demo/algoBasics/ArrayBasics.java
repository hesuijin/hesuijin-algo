package com.example.demo.algoBasics;


/**
 * @Description:
 * 数组就是存储数据长度固定的容器，存储多个数据的数据类型要一致。
 * 为什么先看最基础的数组呢，这是因为最基础的数组 实际上是 整个数组集合的基础
 *
 * @Author HeSuiJin
 * @Date 2021/5/12
 */
public class ArrayBasics {

    /**
     * 仅以 int类型的数组为例
     *
     * @param args
     */
    public static void main(String[] args) {

        //动态初始化
        dynamicCreateArrIntTest();
        //静态初始化
        staticCreateArrIntTest();

//        动态初始化
//        int[] arrInt = new int[3];
//        静态初始化
//        int[] arrInt = new int[]{1,2,3};
//        int[] arrInt = {1,2,3};


//      数据类型 数组名[]  不建议使用(因为比较难记忆）
//      int arrIntOther [];
//      int arrIntOther[] = new int[3];
//      int arrIntOther[] = new int[]{1,2,3};
//      int arrIntOther[] = {1,2,3};
    }


    /**
     * 动态初始化：在初始化的时候, 必须需要手动指定数组的长度, 系统会为数组容器分配初始值.
     */
    private static void dynamicCreateArrIntTest() {
        System.out.println("==============================================");
        System.out.println(" int[] arrInt = new int[3];方式  动态初始");

        int[] arrInt = new int[3];

        System.out.println("数组长度数组空间:   " + arrInt.length);

        arrInt[0] = 1;
        arrInt[1] = 2;
        arrInt[2] = 3;

        //注意数组的开始索引下标为 0  数组长度就等于数组空间 容量为3  即是 【0,1,2】
        for (int i = 0; i < arrInt.length; i++) {
            System.out.println(arrInt[i]);
        }

        //不建议使用
        for (int i = 1; i <= arrInt.length; i++) {
            System.out.println(arrInt[i - 1]);
        }

        //Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: 3
        try {
            arrInt[3] = 4;
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 静态初始化 : 初始化时指定每个数组元素的初始值，由系统决定数组长度
     */
    private static void staticCreateArrIntTest() {

        // 数据类型[] 数组名 = new 数据类型[]{数据1,数据2,数据3...};
        int[] arrInt = new int[]{1,2,3};
        System.out.println("==============================================");
        System.out.println("int[] arrInt = new int[]{1,2,3};方式  静态初始");
        System.out.println(arrInt[0]);
        System.out.println(arrInt[1]);
        System.out.println(arrInt[2]);

        // 数据类型[] 数组名 = {数据1,数据2,数据3...};
        int[] arrIntOther ={1,2,3};
        System.out.println("==============================================");
        System.out.println(" int[] arrIntOther ={1,2,3};方式  静态初始");
        System.out.println(arrIntOther[0]);
        System.out.println(arrIntOther[1]);
        System.out.println(arrIntOther[2]);

    }

}

