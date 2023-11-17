package com.solution.baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 9465, 스티커, 실버 1
 */
public class BOJ9465 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for(int t=0; t<T; t++) {
			int n = Integer.parseInt(br.readLine());
			int[][] nums = new int[2][n+2];
			StringTokenizer st;
			for(int i=0; i<2; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=2; j<n+2; j++) {
					nums[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int[][] dp = new int[2][n+2];
			for(int j=2; j<n+2; j++) {
				for(int i=0; i<2; i++) {
					if(i==0) {
						dp[i][j] = Math.max(dp[i][j], Math.max(dp[1][j-1], dp[1][j-2])) + nums[i][j];
					} else {
						dp[i][j] = Math.max(dp[i][j], Math.max(dp[0][j-1], dp[0][j-2])) + nums[i][j];
					}
				}
			}

			System.out.println(Math.max(dp[0][n+1], dp[1][n+1]));
		}
	}
}
