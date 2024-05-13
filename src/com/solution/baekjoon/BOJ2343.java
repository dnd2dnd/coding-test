package com.solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2343 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[] nums = new int[n];
		int right = 0;
		st = new StringTokenizer(br.readLine());

		int left = 0;
		for(int i=0; i<n; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
			right += nums[i];
			left = Math.max(left, nums[i]);
		}

		int ans = Integer.MAX_VALUE;
		while (left <= right) {
			int mid = (left + right) / 2;

			int video = 1;
			int sum = 0;
			for(int i=0; i<n; i++) {
				if(sum + nums[i] > mid) {
					video++;
					sum = nums[i];
				} else {
					sum += nums[i];
				}
			}

			if(video <= m) {
				ans = Math.min(ans, mid);
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		System.out.println(ans);
	}
}
