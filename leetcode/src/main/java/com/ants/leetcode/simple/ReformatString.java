package com.ants.leetcode.simple;

import java.util.ArrayList;
import java.util.List;

public class ReformatString {
    public static void main(String[] args) {
        ReformatString test = new ReformatString();
        String a0b1c2 = test.reformat("abcd123");
        System.out.println(a0b1c2);

    }

    public String reformat(String s) {
        int sumDigit = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                sumDigit++;
            }
        }
        int sumAlpha = s.length() - sumDigit;
        if (Math.abs(sumDigit - sumAlpha) > 1) {
            return "";
        }
        boolean flag = sumDigit > sumAlpha;
        char[] arr = s.toCharArray();
        for (int i = 0, j = 1; i < s.length(); i += 2) {
            if (Character.isDigit(arr[i]) != flag) {
                while (Character.isDigit(arr[j]) != flag) {
                    j += 2;
                }
                swap(arr, i, j);
            }
        }
        return new String(arr);
    }

    public void swap(char[] arr, int i, int j) {
        char c = arr[i];
        arr[i] = arr[j];
        arr[j] = c;
    }


    public String reformat1(String s) {
        if (s == null || s.length() <= 0) {
            return "";
        }
        List<Character> c = new ArrayList<>();
        List<Character> n = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                n.add(s.charAt(i));
            } else {
                c.add(s.charAt(i));
            }
        }
        StringBuilder sb = new StringBuilder();
        if (Math.abs(c.size() - n.size()) <= 1) {
            //拼接
            int min = Math.min(c.size(), n.size());
            for (int i = min-1; i >=0; i--) {
                if (c.size()>n.size()){
                    sb.append(c.get(i) );
                    sb.append(n.get(i) );
                }
                else {
                    sb.append(n.get(i) );
                    sb.append(c.get(i) );
                }
                c.remove(i);
                n.remove(i);
            }
            if (Math.abs(c.size() - n.size())==1){
                sb.append(n.size() > 0 ? n.get(0) : c.get(0));
            }

            return sb.toString();
        } else {
            return "";
        }

    }
}
