package com.solution.baekjoon.backtracking;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 10819, 차이를 최대로, 실버 2
 */
public class BOJ10819 {
	static int n;
	static int[] nums;
	static boolean[] visited;
	static int max;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		nums = new int[n];
		visited = new boolean[n];
		for(int i=0; i<n; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}

		max = Integer.MIN_VALUE;
		dfs(0, new int[n]);
		System.out.println(max);
	}
	public static void dfs(int d, int[] arr) {
		if(d==n) {
			int sum = 0;
			for (int i = 0; i < arr.length-1; i++) {
				sum += Math.abs(arr[i]-arr[i+1]);
			}
			max = Math.max(sum, max);
			return;
		}

		for(int i=0; i<n; i++) {
			if(!visited[i]) {
				visited[i] = true;
				arr[d] = nums[i];
				dfs(d+1, arr);
				visited[i] = false;
			}
		}
	}
}

