package com.example.demo.arrayCollection;


/**
 * @Description:
 * @Author HeSuiJin
 * @Date 2021/5/12
 */
public class ArrayDemoTest {

    public static void main(String[] args) {

        //静态数组测试
        staticArrayListTest();
        System.out.println("==============================================");

        //动态数组测试
        dynamicArrayListTest();
        System.out.println("==============================================");
    }

    private static void staticArrayListTest() {
        StaticArrayList staticArrayList = new StaticArrayList(10);

        System.out.println("空间大小 ：" + staticArrayList.getLength());

        //在末尾新增一个元素
        staticArrayList.insert(1);
        staticArrayList.insert(5);
        staticArrayList.insert(10);

        System.out.println("实际个数 ：" + staticArrayList.getCount());

        System.out.println("测试查询功能 存在则返回对应值 不存在则返回 -1 ：" + staticArrayList.find(3));

        //随机插入的元素必须在 等于或小于已有的实际个数 如此时就是[1,5,10]  即3
        staticArrayList.insertByIndex(3, 666);
        staticArrayList.findAll();

        //测试按下标插入 数据挪位功能
        staticArrayList.insertByIndex(1, 999);
        staticArrayList.findAll();

        //测试按下标删除 数据挪位功能
        staticArrayList.deleteByIndex(1);
        staticArrayList.findAll();

    }

    private static void dynamicArrayListTest() {
        DynamicArrayList<String> dynamicArrayList = new DynamicArrayList();
        dynamicArrayList.addLast("sui");
        dynamicArrayList.addLast("jin");
        dynamicArrayList.addFirst("he");
        System.out.println("空间大小 ：:"+dynamicArrayList.getLength());

        System.out.println("==============================================");
        for (int i = 0; i < dynamicArrayList.getCount(); i++) {
            System.out.println(dynamicArrayList.get(i));
        }
        System.out.println("==============================================");

        dynamicArrayList.add(1,"第一次插入到下标1");
        dynamicArrayList.add(1,"第二次插入到下标1");
        System.out.println("空间大小 ：:"+dynamicArrayList.getLength());

        dynamicArrayList.add(1,"第三次插入到下标1");
        System.out.println("空间大小 ：:"+dynamicArrayList.getLength());

        System.out.println("==============================================");
        for (int i = 0; i < dynamicArrayList.getCount(); i++) {
            System.out.println(dynamicArrayList.get(i));
        }
        System.out.println("==============================================");

        dynamicArrayList.set(1,"下标1 已经做了修改");
        System.out.println("是否存在:"+dynamicArrayList.contains("下标1 已经做了修改"));
        System.out.println("对应下标"+dynamicArrayList.find("下标1 已经做了修改"));
        System.out.println("打印下标1 ：:"+dynamicArrayList.get(1));

        System.out.println("==============================================");
        for (int i = 0; i < dynamicArrayList.getCount(); i++) {
            System.out.println(dynamicArrayList.get(i));
        }
        System.out.println("==============================================");

        dynamicArrayList.removeFirst();
        dynamicArrayList.removeLast();
        dynamicArrayList.removeElement("下标1 已经做了修改");
        dynamicArrayList.remove(2);

        System.out.println("==============================================");
        for (int i = 0; i < dynamicArrayList.getCount(); i++) {
            System.out.println(dynamicArrayList.get(i));
        }
        System.out.println("==============================================");
    }
}
