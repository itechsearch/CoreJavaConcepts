package com.itechsearch.basicOps;

import java.util.Arrays;
import java.util.Scanner;

public class AnagramTesterUsingTwoCharArray {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter first value ");
        String testValueOne=scanner.next();
        System.out.println("Enter second value ");
        String testValueTwo=scanner.next();
        System.out.print ("Given Strings are ");
        if(testValueOne.length()==testValueTwo.length()){
            anagramUsingArray(testValueOne, testValueTwo);
        }
        else{
            System.out.println("Not Anagram");
        }
    }

    private static void anagramUsingArray(String testValueOne, String testValueTwo) {
        char[] testValueArrayOne=testValueOne.toCharArray();
        char[] testValueArrayTwo=testValueTwo.toCharArray();
        Arrays.sort(testValueArrayOne);
        Arrays.sort(testValueArrayTwo);
        if(Arrays.equals(testValueArrayOne,testValueArrayTwo)){
            System.out.println("Anagram");
        }
        else {
            System.out.println("Not Anagram");
        }
    }
}
