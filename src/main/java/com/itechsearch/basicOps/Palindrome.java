
package com.itechsearch.basicOps;

import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter Integer to check palindrome :");
        int userInput=scanner.nextInt();
        checkPalindromeUsingSB(userInput);
    }

    private static void checkPalindromeUsingSB(Integer originalString) {
         String reverseString=(new StringBuffer(originalString.toString())).reverse().toString();
         if(originalString.toString().equals(reverseString)){
             System.out.println("It is palindrome");
         }
    }
}
