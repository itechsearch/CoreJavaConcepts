    package com.itechsearch.basicOps;

    public class SwapTwoNumberWithOutTemp {
        public static void main(String[] args) {
            int a=1;
            int b=2;
            a+=b;
        b=a-b;
        a=a-b;
        System.out.println("a is " + a);
        System.out.println("b is "+ b );

    }
}
