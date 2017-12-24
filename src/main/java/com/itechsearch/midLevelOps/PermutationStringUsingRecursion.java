package com.itechsearch.basicOps;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PermutationStringUsingRecursion {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter a string ");
        String testValue=scanner.next();
        List<String> permutationList=processAndGetPermutationStrings(testValue);
        permutationList.forEach(System.out::println);
    }

    private static List<String> processAndGetPermutationStrings(String testValue) {
        List<String> list=new ArrayList<>();
        if(testValue.length()==1){
            list.add(testValue);
        }else {
            int lastIndex=testValue.length()-1;
            String lastLetter=testValue.substring(lastIndex);
            String firstSegment=testValue.substring(0,lastIndex);
            list=combine(processAndGetPermutationStrings(firstSegment),lastLetter);

        }
        return list;
    }

    private  static List<String> combine(List<String> segmentList, String lastLetter){
        List<String> combineList= new ArrayList<>();
        for(String segment: segmentList){
            for(int letterCount=0;letterCount<=segment.length(); letterCount++){
                combineList.add(new StringBuffer(segment).insert(letterCount,lastLetter).toString());

            }
        }
        return combineList;
    }
}
