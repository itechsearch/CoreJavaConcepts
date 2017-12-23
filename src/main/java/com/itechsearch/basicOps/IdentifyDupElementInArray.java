package com.itechsearch.basicOps;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class IdentifyDupElementInArray {

    public static void main(String[] args) {
        String[] duplicateElmtArray={"apple","orange","pineapple","apple","mango","grape","orange","apple"};
        bruteForceMethodDuplicateCheck(duplicateElmtArray);
        identifyDuplicateUsingSet(duplicateElmtArray);
        identifyDuplicateUsingHashTypeDS(duplicateElmtArray);
    }

    // Hash type data structure time complexity O(2n) and space complexity O(n)
    private static void identifyDuplicateUsingHashTypeDS(String[] duplicateElmtArray) {
        System.out.println("Duplicate finder using Hash type logic");
        Map<String,Integer> hashMap=new HashMap<>();
        Integer dupCount;
        for(String elmt : duplicateElmtArray){
            if(hashMap.containsKey(elmt)){
               dupCount= hashMap.get(elmt);
               hashMap.put(elmt,++dupCount);
            }else{
                hashMap.put(elmt,1);
            }
        }
        for(String key: hashMap.keySet()){
            if(hashMap.get(key)>1){
                System.out.println("Duplicate found "+key+" count "+ hashMap.get(key));
            }
        }
    }

    //  Set data structure time complexity O(n) and Space complexity O(n)
     private static void identifyDuplicateUsingSet(String[] duplicateElmtArray) {
         System.out.println("Duplicate identifier using set type data structure");
        Set<String>  stringSet=new HashSet<>();
        for(String elmt: duplicateElmtArray){
            if(!stringSet.add(elmt)){
                System.out.println("Duplicate identified "+ elmt);
            }
        }

    }
// Brute force time complexity O(n^2)
    private static void bruteForceMethodDuplicateCheck(String[] duplicateElmtArray) {
        System.out.println("Brute Force Method to check duplicates ");
        for(int counterOne=0;counterOne<duplicateElmtArray.length;counterOne++){
            for(int counterTwo=counterOne+1; counterTwo<duplicateElmtArray.length; counterTwo++){
                if(duplicateElmtArray[counterOne].equals(duplicateElmtArray[counterTwo])){
                    System.out.println("Duplicate elements "+ duplicateElmtArray[counterOne]);
                }
            }
        }
    }

}
