package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author lyy
 * @Description
 * @Date 2021-01-25
 **/
public class Sum4 {
	public static void main(String[] args) {
		List<List<Integer>> lists = fourSum(new int[]{}, 5);
		for (List<Integer> item : lists) {
			for (Integer num : item) {
				System.out.println(num);
			}
		}
	}

	public static List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> result = new ArrayList<>();
		Arrays.sort(nums);
		int i = 0;
		for (i = 0; i < nums.length - 1; i++) {
			if (i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}
			for (int j = i + 1; j < nums.length; j++) {
				if (j > i + 1 && nums[j] == nums[j - 1]) {
					continue;
				}
				int l=j+1,r=nums.length-1;
				while (l<r){
					if (l>j+1&&nums[l]==nums[l-1]){
						l++;
					}else if (nums[i]+nums[j]+nums[l]+nums[r]<target){
						l++;
					}else if (nums[i]+nums[j]+nums[l]+nums[r]>target){
						r--;
					}else {
						result.add(Arrays.asList(nums[i],nums[j],nums[l],nums[r]));
						l++;
						r--;
					}
				}
			}
		}
		return result;
	}
}
