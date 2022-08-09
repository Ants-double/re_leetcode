package com.ants.leetcode.simple;

public class StepwisePositiveNumber {
    public static void main(String[] args) {
        StepwisePositiveNumber test = new StepwisePositiveNumber();
        int i = test.minStartValue(new int[]{-3, 2, -3, 4, 2});
        System.out.println(i);
    }

    public int minStartValue(int[] nums) {
        int startValue = 0;
        int temp = 0;
        boolean index = true;
        while (index) {
            startValue++;
            temp = startValue;
            int i = 0;
            for (; i < nums.length; i++) {
                temp=temp+nums[i];
                if (temp <= 0) {
                    break;
                }
            }
            if (i==nums.length){
                index = false;
            }
        }
        return startValue;

    }
}
