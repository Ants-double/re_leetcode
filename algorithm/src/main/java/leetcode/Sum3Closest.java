package leetcode;

import java.util.Arrays;

/**
 * @Author lyy
 * @Description
 * @Date 2021-01-23
 **/
public class Sum3Closest {

	public static void main(String[] args) {
		int i = threeSumClosest(new int[]{-1, 2, 1, -4}, 1);
		System.out.println(i);
	}
	public static int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);
		int result=nums[0]+nums[1]+nums[2];
		for (int i=0;i<nums.length-2;i++){
			int l=i+1,r=nums.length-1;
			while (l<r){
				int threeSum=nums[l]+nums[r]+nums[i];
				if (Math.abs(threeSum-target)<Math.abs(result-target)){
					result=threeSum;
				}
				if (threeSum>target){
					r--;
				}
				else if (threeSum<target){
					l++;
				}else {
					return target;
				}
			}
		}
		return result;
	}
}
