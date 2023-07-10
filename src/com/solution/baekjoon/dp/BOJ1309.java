package com.solution.baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 백준 1309번 동물원, 실버 1
 */
public class BOJ1309 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());

		long[][] dp = new long[N+1][3];

		dp[1][0] = dp[1][1] = dp[1][2] = 1;

		for(int i=2; i<=N; i++) {
			dp[i][0] = (dp[i-1][0]+dp[i-1][1]+dp[i-1][2]) % 9901;
			dp[i][1] = (dp[i-1][0]+dp[i-1][2]) % 9901;
			dp[i][2] = (dp[i-1][0]+dp[i-1][1]) % 9901;
		}
		System.out.println((dp[N][0] + dp[N][1] + dp[N][2]) % 9901);
	}
}
