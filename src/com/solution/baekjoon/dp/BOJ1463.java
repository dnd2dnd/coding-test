package com.solution.baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 1463번 1로 만들기, 실버 3
 */
public class BOJ1463 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int[] dp = new int[x+1];

		dp[0] = dp[1] = 0;

		for(int i=2; i<=x; i++) {
			dp[i] = dp[i-1] + 1;
			if(i%2==0) dp[i] = Math.min(dp[i], dp[i/2] +1);
			if(i%3==0) dp[i] = Math.min(dp[i], dp[i/3] +1);
		}
		System.out.println(dp[x]);
	}
}
