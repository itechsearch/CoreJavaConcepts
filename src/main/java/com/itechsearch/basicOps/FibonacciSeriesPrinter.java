package com.itechsearch.basicOps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FibonacciSeriesPrinter {
    public static void main(String[] args) throws IOException {
        System.out.println("Enter number ");
        BufferedReader bufferedReader =new BufferedReader(new InputStreamReader(System.in));
        //int testValue=Integer.parseInt(bufferedReader.readLine());// or
        int testValue=Integer.valueOf(bufferedReader.readLine());
        fibonacciPrinter(testValue);
    }

    private static void fibonacciPrinter(int testValue) {
        int first=1;
        int second=1;
        int current;
        System.out.println("Fib Series ");
        for(int i=1;i<=testValue;i++){
            if(i==1 || i==2){
                System.out.print(" " + 1 +" ");
            }
            else {
                current = first + second;
                System.out.print(" "+current+" ");
                first = second;
                second = current;
            }
        }
    }
}
