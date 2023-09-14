package com.solution.baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * 백준 15654, N과 M(5), 실버 3
 */
public class BOJ15654 {
	static int n, m;
	static int[] nums;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		nums = new int[n];
		visited = new boolean[n+1];

		st = new StringTokenizer(br.readLine());
		for (int i=0; i<n; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(nums);

		dfs(0, "");
	}
	public static void dfs(int d, String sb) {
		if(d==m) {
			sb = sb.replaceFirst(" ", "");
			System.out.println(sb);
			return;
		}

		for(int i=0; i<n; i++) {
			if(!visited[i]) {
				visited[i] = true;
				dfs(d+1, sb + (" "+nums[i]));
				visited[i] = false;
			}
		}
	}
}
