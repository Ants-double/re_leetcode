package com.ants.leetcode.middle;

import java.util.Arrays;

public class ValidSquares {
    public static void main(String[] args) {
        ValidSquares test=new ValidSquares();
        boolean b = test.validSquare(new int[]{0, 0}, new int[]{1,1}, new int[]{1, 0}, new int[]{0, 1});
        System.out.println(b);
    }

    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {

        if (p1[0]==p2[0]&&p1[1]==p2[1])return false;
        long[] l=new long[6];
        l[0]=len(p1,p2);
        l[1]=len(p1,p3);
        l[2]=len(p1,p4);
        l[3]=len(p2,p3);
        l[4]=len(p2,p4);
        l[5]=len(p3,p4);
        Arrays.sort(l);

        return l[0]==l[1]&&l[0]==l[2]&&l[0]==l[3]&&l[4]==l[5];
    }
    public long len(int [] p1,int []p2){
        return (p1[0]-p2[0])*(p1[0]-p2[0])+(p1[1]-p2[1])*(p1[1]-p2[1]);
    }
}
