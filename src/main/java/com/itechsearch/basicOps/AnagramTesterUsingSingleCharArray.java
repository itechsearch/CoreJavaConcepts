package com.itechsearch.basicOps;

import java.util.Scanner;

public class AnagramTesterUsingSingleCharArray {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter first value ");
        String testValueOne=scanner.next();
        System.out.println("Enter second value ");
        String testValueTwo=scanner.next();
        System.out.print ("Given Strings are ");
        if(testValueOne.length()==testValueTwo.length() && anagramUsingSingleCharArray(testValueOne, testValueTwo)){
            System.out.println("Anagram");
        }
        else{
            System.out.println("Not Anagram");
        }
    }

    private static boolean anagramUsingSingleCharArray(String testValueOne, String testValueTwo) {
        char[] testValueArrayOne=testValueOne.toCharArray();
        int index;
        for(int i=0;i<testValueArrayOne.length;i++){
            index=  testValueTwo.indexOf(testValueArrayOne[i]);
            if(index!=-1) {
                testValueTwo = testValueTwo.substring(0, index) + testValueTwo.substring(index + 1, testValueTwo.length());
            }
            else {
                return false;
            }

        }
        if(testValueTwo.length()==0){
            return true;
        }
        return false;

    }
}
