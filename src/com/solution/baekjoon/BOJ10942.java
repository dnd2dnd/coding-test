package com.solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ10942 {
	static int[][] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] nums = new int[n+1];
		dp = new int[n+1][n+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1; i<=n; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
			for(int j=1; j<=i; j++) {
				if(i==j) {
					dp[i][j] = 1;
				} else if(i==j+1 && nums[j] == nums[i]) {
					dp[i][j] = 1;
				} else {
					if(nums[i] == nums[j] && dp[j+1][i-1]==1) {
						dp[j][i] = 1;
					}
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		int m = Integer.parseInt(br.readLine());
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			sb.append(dp[s][e]).append("\n");
		}
		System.out.println(sb);
	}
}
