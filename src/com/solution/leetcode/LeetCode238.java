package com.solution.leetcode;

import java.util.Arrays;

// 238. Product of Array Except Self
public class LeetCode238 {
	class Solution {
		public int[] productExceptSelf(int[] nums) {
			int[] res = new int[nums.length];

			res[0] = 1;
			for (int i = 1; i < nums.length; i++) {
				res[i] = res[i - 1] * nums[i - 1];
			}
			System.out.println(Arrays.toString(res));

			int acc = 1;
			for (int i = nums.length - 2; i >= 0; i--) {
				acc *= nums[i + 1];
				res[i] *= acc;
				System.out.println(Arrays.toString(res));
			}
			return res;
		}
	}
}
