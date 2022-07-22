package com.ants.leetcode.hard;

import java.util.*;
import java.util.stream.IntStream;

/**
 * @author ants_
 */
public class Intersection757 {
    public static void main(String[] args) {
        Intersection757 test = new Intersection757();
        int i = test.intersectionSizeTwo(new int[][]{{1, 3}, {1, 4}, {2, 5}, {3, 5}});
        System.out.println(i);
    }

    public int intersectionSizeTwo(int[][] intervals) {
        int n = intervals.length;
        int res = 0;
        int m = 2;
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1];
            }
            return a[0] - b[0];
        });
        List<Integer>[] temp = new List[n];
        for (int i = 0; i < n; i++) {
            temp[i] = new ArrayList<Integer>();
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = intervals[i][0], k = temp[i].size(); k < m; j++, k++) {
                res++;
                help(intervals, temp, i - 1, j);
            }
        }
        return res;
    }

    public void help(int[][] intervals, List<Integer>[] temp, int pos, int num) {
        for (int i = pos; i >= 0; i--) {
            if (intervals[i][1] < num) {
                break;
            }
            temp[i].add(num);
        }
    }


    public int intersectionSizeTwo1(int[][] intervals) {
        int re = 0;
// 第一个为标准
        // 0 1
        int l = intervals[0][0];
        int r = intervals[0][1];
        Map<Integer,List<int[]> > temp=new HashMap<>();
        //temp=new ArrayList<>();
        for (int j = l; j <= r; j++) {
            List<int[]> list=temp.getOrDefault(j,new ArrayList<>());
            for (int i = 0; i < intervals.length; i++) {
                int finalJ = j;
                List<Integer> integers=new ArrayList<>();
                for (int a=intervals[i][0];a<=intervals[i][intervals[i].length-1];a++){
                    integers.add(a);
                }
                int [] ints=   new int[]{0,0};
                ints[0]=i;
                boolean match = integers.stream().anyMatch(x -> x == finalJ);
                if (match){
                    ints[1]=ints[1]+1;
                }
                list.add(ints);
            }
            temp.put(j,list);
        }
        return re;
    }

    public int intersectionSizeTwo3(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->a[1]-b[1]);
        int pre1=intervals[0][1]-1,pre2=intervals[0][1],ans=2;
        for(int i=1;i<intervals.length;i++){
            //始终保持pre1<pre2
            if(pre1>=intervals[i][0]&&pre2<=intervals[i][1]){continue;}//两个数都在范围内
            else if(pre2<intervals[i][0]){
                //两个数都不在范围内
                ans+=2;
                pre1=intervals[i][1]-1;
                pre2=intervals[i][1];
            }
            else if(pre1<intervals[i][0]){
                ans++;
                if(pre2==intervals[i][1]){pre1=pre2-1;}
                else{
                    pre1=pre2;
                    pre2=intervals[i][1];
                }
            }
        }
        return ans;
    }
}
