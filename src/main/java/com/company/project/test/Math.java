package com.company.project.test;

public class Math {

    public int computer(){
        int a = 1;
        int b = 2;
        int c = (a+b) * 10;
        return c;
    }
    public static void main(String[] args) {
        Math math = new Math();
        math.computer();
        System.out.println("test");
    }
}
