package com.solution.baekjoon.binarySearch;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ3151 {
	static int[] nums;
	static boolean[] visited;
	static int n;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		nums = new int[n];
		visited = new boolean[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(nums);

		int answer = 0;
		for (int i=0; i<n-2; i++) {
			for (int j=i+1; j<n-1; j++) {
				int v = nums[i] + nums[j];
				int l = lower(j+1, n-1, v);
				int u = upper(j+1, n-1, v);

				System.out.println(u + " " + l);
				if(u != Integer.MIN_VALUE || l != Integer.MAX_VALUE) {
					answer += (u-l);
				}
			}
		}
		System.out.println(answer);
	}
	public static int lower(int start, int end, int value) {
		int ans = Integer.MAX_VALUE;
		while(start<=end) {
			int mid = (start + end) / 2;
			if(nums[mid] + value < 0) {
				start = mid + 1;
			} else {
				ans = Math.min(ans, mid);
				end = mid - 1;
			}
		}
		return ans;
	}


	public static int upper(int start, int end, int value) {
		int ans = Integer.MIN_VALUE;
		while(start<=end) {
			int mid = (start + end) / 2;
			if(nums[mid] + value < 0) {
				start = mid + 1;
			} else {
				ans = Math.max(ans, mid);
				end = mid - 1;
			}
		}
		return ans;
	}
}
