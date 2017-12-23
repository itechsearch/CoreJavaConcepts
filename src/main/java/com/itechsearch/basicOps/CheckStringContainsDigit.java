package com.itechsearch.basicOps;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckStringContainsDigit {
    public static void main(String[] args) {
        String testWithDigit ="itech5search";
        String testWithoutDigit="itechsearch";
        Integer digit=12345;
        System.out.println("String with Digit "+ Pattern.matches("(.)*(\\d)(.)*",testWithDigit));
        System.out.println("String with without digit "+ Pattern.matches("(.)*(\\d)(.)*",testWithoutDigit));
        System.out.println("Integer "+ Pattern.matches("([0-9]+)", digit.toString()));


        Pattern onlyDigitPattern = Pattern.compile("([0-9])");
        Matcher onlyDigitMatcher = onlyDigitPattern.matcher(digit.toString());

        if(onlyDigitMatcher.find()){
            System.out.println("StringContainOnly Digit "+onlyDigitMatcher.find());
        }
    }
}
