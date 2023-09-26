package com.solution.baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2098 {
	static int n, statusFullBit, INF = 987654321;
	static int[][] dp;
	static int[][] score;
	public static void main(String[] args) throws IOException {
		System.out.println((1 & 2)==0);
		System.out.println((1 & 2)==0);
		System.out.println((1 & 4)==0);
		System.out.println((1 & 1)==0);
		System.out.println((2 & 4)==0);

		// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// n = Integer.parseInt(br.readLine());
		// score = new int[n][n];
		// statusFullBit = (1<<n) -1;
		// dp = new int[n][statusFullBit];
		//
		// for(int i=0; i<n; i++) {
		// 	Arrays.fill(dp[i], -1);
		// }
		//
		// StringTokenizer st;
		// for(int i=0; i<n; i++) {
		// 	st = new StringTokenizer(br.readLine());
		// 	for(int j=0; j<n; j++) {
		// 		score[i][j] = Integer.parseInt(st.nextToken());
		// 	}
		// }
		//
		// System.out.println(dfs(0 ,0));

	}

	public static int dfs(int x, int check) {
		if(check == statusFullBit) {
			if(score[x][0] == 0) return INF;
			else return score[x][0];
		}

		if(dp[x][check] != -1) return dp[x][check];
		dp[x][check] = INF;

		for(int i=0; i<n; i++) {
			int next = check | (1<<i);
			System.out.println(next);
			if(score[x][i] == 0 || (check & (1<<i)) != 0) continue;

			dp[x][check] = Math.min(dp[x][check], dfs(i, next) + score[x][i]);
		}
		return dp[x][check];
	}
}
