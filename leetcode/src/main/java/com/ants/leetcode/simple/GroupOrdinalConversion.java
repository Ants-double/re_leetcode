package com.ants.leetcode.simple;

import javax.sql.rowset.FilteredRowSet;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * @author ants_
 */
public class GroupOrdinalConversion {

    public static void main(String[] args) {
        GroupOrdinalConversion test = new GroupOrdinalConversion();
        int[] ints = test.arrayRankTransform(new int[]{37, 12, 28, 9, 100, 56, 80, 5, 12});
        Arrays.stream(ints).forEach(x -> System.out.println(x));
    }


    public int[] arrayRankTransform(int[] arr) {

        int[] ints = Arrays.copyOf(arr, arr.length);
        Arrays.sort(ints);
        int[] re = new int[arr.length];

        Map<Integer,Integer> rank=new HashMap<>();
        for (int a:ints){
            if (!rank.containsKey(a)){
                rank.put(a,rank.size()+1);
            }
        }
        for (int i=0;i<arr.length;i++){
            re[i]=rank.get(arr[i]);
        }


        return re;

    }


    public int[] ifRepeat3(int[] arr) {
        //实例化一个set集合
        Set<Integer> set = new HashSet();
        //遍历数组并存入集合,如果元素已存在则不会重复存入
        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }
        //返回Set集合的数组形式
        int[] re = new int[set.size()];
        AtomicInteger index = new AtomicInteger(0);
        set.stream().forEach(x -> re[index.getAndIncrement()] = x);
        return re;
    }

    private int getIndex(int[] ints, int i) {
        for (int j = 0; j < ints.length; j++) {
            if (ints[j] == i) {
                return j;
            }
        }
        return 0;
    }

}
