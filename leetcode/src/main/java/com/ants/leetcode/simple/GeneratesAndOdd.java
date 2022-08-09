package com.ants.leetcode.simple;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author ants_
 */
public class GeneratesAndOdd {
    public static void main(String[] args) {
        GeneratesAndOdd test =new GeneratesAndOdd();
        String s = test.generateTheString(5);
        System.out.println(s);
    }

    public String generateTheString(int n) {

        List<String> a = Collections.nCopies(4, "a");

        StringBuffer sb=new StringBuffer();
        if ((n&1)==1){
            return Collections.nCopies(n,"a").stream().collect(Collectors.joining());
        }
        return Collections.nCopies(n-1,"a").stream().collect(Collectors.joining())+"b";

    }
}
