package com.howard.leetcode;

/**
 * @author howard he
 * @create 2019-05-10 10:32
 */
public class FunctionTest {

    public static void foo() {
        System.out.println("foo");
        bar();
    }

    public static void bar() {
        System.out.println("bar");
        foo();
    }

    public static void main(String[] args) {
        foo();
        System.out.println("end");
    }
}
