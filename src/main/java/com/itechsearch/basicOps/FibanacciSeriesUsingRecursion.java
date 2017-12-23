package com.itechsearch.basicOps;

import java.util.Scanner;

public class FibanacciSeriesUsingRecursion {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter the number");
        int number=scanner.nextInt();
        System.out.println("Nth Fibanacci number is "+ fibannaciSeries(number));
    }


    private static int fibannaciSeries(int number) {
        if(number==0|number==1){
            return 1;
        }
        else{
            return fibannaciSeries(number-1)+  fibannaciSeries(number-2);
        }
    }
}
