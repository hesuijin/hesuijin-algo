package com.example.demo.stack;

/**
 * @Description:
 * @Author HeSuiJin
 * @Date 2021/5/13
 */
public class StackDemoTest {

    public static void main(String[] args) {
//        String string = "{{{{{{{{{{(HSJ{}HSJ[])(HSJ{}HSJ[])(HSJ{}HSJ[])(HSJ{}HSJ[])(HSJ{}HSJ[])}}}}}}}}}";
        String string = "{1}}";
        String stringReturn =  StringTest(string);
        System.out.println(stringReturn);
    }

    private static String StringTest(String string) {
        ArrayStack stackTest = new ArrayStack();
        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            if (left(c)) {
                stackTest.push(c);
            }

            if (right(c)) {
                char temp = stackTest.pop();
                if( !flag(c,temp)){
                    return "输入规则错误";

                }
            }
        }

        if (stackTest.getCount() !=0 ){
            return "左边括号数量多于右边括号";
        }

        return "输入规则正确";
    }

    private static boolean left(char c) {
        return c == '{' || c == '(' || c == '[';
    }

    private static boolean right(char c) {
        return c == '}' || c == ')' || c == ']';
    }

    private static boolean flag(char temp,char c) {
        boolean isOne = c == '{' && temp == '}';
        boolean isTwo = c=='(' && temp==')';
        boolean isThree = c=='[' && temp==']';
        return   isOne||isTwo||isThree;
    }
}
