package com.solution.baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 백준 15655, N과 M(6), 실버 3
 */
public class BOJ15655 {
	static int n, m;
	static int[] nums;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		nums = new int[n];
		visited = new boolean[n];
		String[] strs  = br.readLine().split(" ");
		for(int i=0; i<n; i++) {
			nums[i] = Integer.parseInt(strs[i]);
		}
		Arrays.sort(nums);
		dfs(0, 0, new int[m]);
	}

	public static void dfs(int x, int d, int[] ans) {
		if(d == m) {
			for (int an : ans) {
				System.out.print(an+" ");
			}
			System.out.println();
			return;
		}

		for(int i=x; i<n; i++) {
			if(!visited[i]) {
				visited[i] = true;
				ans[d] = nums[i];
				dfs(i, d+1, ans);
				visited[i] = false;
			}
		}
	}
}
