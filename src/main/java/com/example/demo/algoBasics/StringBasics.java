package com.example.demo.algoBasics;

import java.util.Scanner;

/**
 * @Description:
 * @Author HeSuiJin
 * @Date 2021/5/12
 */
public class StringBasics {

    public static void main(String[] args) {

        //输入String
        stringScannerTest();

        //测试char 转换成String
        charToString();

        //对String进行遍历
        stringForTest();

        //对String进行替换
        stringReplaceTest();

        //测试substring截取功能
        stringSubstringTest();

        //测试Split分割功能
        stringSplit();
    }


    /**
     * 输入String
     */
    private static void stringScannerTest() {
        //  1. 键盘录入一个字符串，用 Scanner 实现
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入:");
        String string = sc.nextLine();
        System.out.println("输出String:" + string);
        System.out.println("==============================================");
    }


    /**
     * 测试String 转换成 char
     */
    private static void charToString(){
        String string = "string";
        String[] strings = new String[10];
        char[] chars = new char[10];

        for (int i = 0;i < string.length() ; i++){
            chars[i] = string.charAt(i);
            strings[i] = String.valueOf(string.charAt(i));
        }

        System.out.println("打印chars"+chars);
        System.out.println("打印string"+strings);

    }

    /**
     * 对String进行遍历
     */
    private static void stringForTest() {
        String string1 = "hesuijin";
        for (int i = 0; i < string1.length(); i++) {
            //charAt(int index)  返回指定索引处的 char 值
            char c = string1.charAt(i);
            System.out.println(c);
        }
        System.out.println("==============================================");
        String string2 = "HSJ";
        //  将字符串拆分为字符数组
        char[] chars = string2.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            System.out.println(chars[i]);
        }
    }

    /**
     * 对Sting 使用replace进行截取
     */
    private static void stringReplaceTest() {

        String string = "你好啊 hesuijin，血是红色的";
        // 2. 替换敏感词
        String result = string.replace("红","*");
        // 3. 输出结果
        System.out.println(result);
    }

    /**
     * 对Sting 使用substring进行截取
     */
    private static void stringSubstringTest() {
        String stringSubstring = "12345678901";

        // 1. 截取字符串前三位
        String start = stringSubstring.substring(0, 3);
        // 2. 截取字符串后四位
        String end = stringSubstring.substring(7);
        // 3. 将截取后的两个字符串，中间加上****进行拼接，输出结果
        System.out.println(start + "****" + end);

    }

    /**
     * 对Sting 使用split进行切割
     */
    private static void stringSplit() {

        String person = "HSJ,18";
        //  根据逗号切割字符串，得到HSJ  18
        String[] strings = person.split(",");

        for (int i = 0; i < strings.length; i++) {
            System.out.println(strings[i]);
        }

        String personSplit = "abcHSJabchesuijinabc";
        String[] stringsSplit = personSplit.split("abc");
        for (int i = 0; i < stringsSplit.length; i++) {
            System.out.println(stringsSplit[i]);
        }
    }
}
