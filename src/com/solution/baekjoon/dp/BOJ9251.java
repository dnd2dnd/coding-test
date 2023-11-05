package com.solution.baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준 9251, LCS, 골드 5
 */
public class BOJ9251 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String x = br.readLine();
		String y = br.readLine();
		int[][] dp = new int[x.length()+1][y.length()+1];

		for(int i=1; i<=x.length(); i++) {
			for(int j=1; j<=y.length(); j++) {
				if(x.charAt(i-1) == y.charAt(j-1)) {
					dp[i][j] = dp[i-1][j-1]+1;
				} else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		System.out.println(dp[x.length()][y.length()]);
	}
}
