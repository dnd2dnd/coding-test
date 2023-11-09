package com.solution.baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준 2133, 타일 채우기, 골드 4
 */
public class BOJ2133 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int[] nums = new int[31];
		nums[0] = 1;
		nums[1] = 0;

		for(int i=2; i<=n; i++) {
			if(i%2==0) {
				nums[i] = nums[i-2] * 3;
				for(int j=i-4; j>=0; j-=2) {
					nums[i] += nums[j]*2;
				}
			}
		}
		System.out.println(nums[n]);
	}
}
