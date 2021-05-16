package com.example.demo.algoBasics;

import java.util.Scanner;

/**
 * @Description:
 * 字符串作为特殊的引用类型
 * 很多时候需要算法题中对其进行操作 因此需要熟悉常用API
 *
 * String类的常用方法 :
 *
 * 	public boolean equals(Object anObject)  比较字符串的内容，严格区分大小写
 *
 * 	public boolean equalsIgnoreCase(String anotherString)  比较字符串的内容，忽略大小写
 *
 * 	public int length()  返回此字符串的长度
 *
 * 	public char charAt(int index)  返回指定索引处的 char 值
 *
 * 	public char[] toCharArray()  将字符串拆分为字符数组后返回
 *
 *  public String replace(CharSequence target, CharSequence replacement)  使用新值，将字符串中的旧值替换，得到新的字符串
 *
 * 	public String substring(int beginIndex, int endIndex)  根据开始和结束索引进行截取，得到新的字符串（包含头，不包含尾）
 *
 * 	public String substring(int beginIndex)  从传入的索引处截取，截取到末尾，得到新的字符串
 *
 * 	public String[] split(String regex)  根据传入的规则切割字符串，得到字符串数组
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
