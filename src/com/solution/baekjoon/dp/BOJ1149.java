package com.solution.baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1149 {
	static int n;
	static int[][] home;
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		home = new int[n][4];
		StringTokenizer st;
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=3; j++) {
				home[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int[][] dp = new int[n][4];
		dp[0][1] = home[0][1];
		dp[0][2] = home[0][2];
		dp[0][3] = home[0][3];
		for(int i=1; i<n; i++) {
			dp[i][1] = Math.min(dp[i-1][2] + home[i][1], dp[i-1][3] + home[i][1]);
			dp[i][2] = Math.min(dp[i-1][1] + home[i][2], dp[i-1][3] + home[i][2]);
			dp[i][3] = Math.min(dp[i-1][1] + home[i][3], dp[i-1][2] + home[i][3]);
		}
		System.out.println(Math.min(Math.min(dp[n-1][1], dp[n-1][2]), dp[n-1][3]));
		// dfs(0, 0, 0);
		// System.out.println(min);
	}
	// public static void dfs(int d, int x, int cost) {
	// 	if(x==0) {
	// 		for(int i=1; i<=3; i++) {
	// 			dfs(d+1, i, cost+home[d][i]);
	// 		}
	// 	}
	// 	if(d==n) {
	// 		min = Math.min(min, cost);
	// 		return;
	// 	}
	//
	// 	for(int i=1; i<=3; i++) {
	// 		if(x!=i) {
	// 			dfs(d+1, i, cost+home[d][i]);
	// 		}
	// 	}
	// }
}
