package com.itechsearch.basicOps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ArmstrongNumber {
    public static void main(String[] args) throws IOException {
        String proceed="Y";
        while(proceed.equals("Y")) {
            System.out.println("Enter test value: ");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            String testValue = bufferedReader.readLine();
            String[] stringArray = testValue.split("");
            int length = stringArray.length;
            Integer result = 0;
            for (int i = 0; i < length; i++) {
                result = result + getSingleDigitValue(Integer.valueOf(stringArray[i]), length);
            }
            System.out.println("Is Armstrong value ?  " + result.toString().equals(testValue));
            System.out.println("Type Y to proceed else press enter or any alphanum key");
            proceed=bufferedReader.readLine();
        }
    }

    private static int getSingleDigitValue(Integer inputInteger,int root) {
        int multipliedValue=1;
        for(int count=1;count<=root;count++){
            multipliedValue=multipliedValue*inputInteger;
        }
        return multipliedValue;
    }
}
