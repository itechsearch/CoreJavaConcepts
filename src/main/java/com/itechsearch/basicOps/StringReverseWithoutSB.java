package com.itechsearch.basicOps;

import java.util.Scanner;

public class StringReverseWithoutSB {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter a String :");
        String testString=scanner.next();
        char[] inputCharArrry = testString.toCharArray();
        char[] reverseCharArray = new char[testString.length()];
        int position = 0;
        for (int i = inputCharArrry.length - 1; i >= 0; i--) {
            reverseCharArray[position++] = inputCharArrry[i];
        }
        System.out.println("Reversed string " + new String(reverseCharArray));
    }
}
