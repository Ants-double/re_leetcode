package com.ants.leetcode.middle;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ants_
 */
public class MyCalendarTwo {

    public static void main(String[] args) {
        MyCalendarTwo test = new MyCalendarTwo();
        boolean book = test.book(5, 15);
        System.out.println(book);
    }

    List<int[]> booked;
    List<int[]> overlaps;


    public MyCalendarTwo() {

        booked = new ArrayList<int[]>();
        overlaps = new ArrayList<int[]>();
    }

    public boolean book(int start, int end) {
        for (int[] arr : overlaps) {
            int l = arr[0], r = arr[1];
            if (l < end && start < r) {
                return false;
            }
        }
        for (int[] arr : booked) {
            int l = arr[0], r = arr[1];
            if (l < end && start < r) {
                overlaps.add(new int[]{Math.max(l, start), Math.min(r, end)});
            }
        }
        booked.add(new int[]{start, end});
        return true;


    }
}
