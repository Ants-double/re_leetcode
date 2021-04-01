package leetcode.dp;

import java.util.Arrays;

/**
 * @author lyy
 * @Deprecated
 * @date 2021/3/31
 */
public class MaximumSubarray {
    public static void main(String[] args) {

        System.out.println(maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println(maxnumber);
    }

    public static int    maxnumber=Integer.MIN_VALUE;

    public static int maxSubArray(int[] nums) {
        if (nums==null||nums.length<=0){
            return 0;
        }
        if  (nums.length==1){
            return  nums[0];
        }

        int[] ints = Arrays.copyOf(nums, nums.length - 1);
       int temp= maxSubArray(ints);
       int pre= Math.max(nums[nums.length-1],
               temp+nums[nums.length-1]);
         maxnumber= Math.max(pre
                ,maxnumber);

        return pre;
    }
    public static int maxSubArray2(int[] nums) {
        int pre = 0, maxAns = nums[0];
        for (int x : nums) {
            pre = Math.max(pre + x, x);
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }
}
