package com.ants.leetcode.simple;

import java.util.Arrays;

public class RearrangeArray {

    public static void main(String[] args) {
        RearrangeArray test = new RearrangeArray();
        int[] shuffle = test.shuffle(new int[]{2, 5, 1, 3, 4,7}, 3);
        Arrays.stream(shuffle).forEach(x -> System.out.println(x));

    }

    public int[] shuffle(int[] nums, int n) {
        if (nums == null || nums.length <= 0) {
            return nums;
        }
        int[] result = new int[nums.length];
        int j = 0;
        for (int i = 0; i < nums.length / 2; i++) {
            result[j] = nums[i];
            result[j + 1] = nums[i + n ];
            j += 2;
        }
        return result;
    }
}
