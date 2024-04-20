package com.solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ22817 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		long[] stone = new long[n+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1; i<=n; i++) {
			stone[i] = Long.parseLong(st.nextToken());
		}

		long[]dp = new long[n+1];

		for(int i=2; i<=n; i++) {
			dp[i] = Integer.MAX_VALUE;
			for(int j=1; j<i; j++) {
				long power = (i-j)*(Math.abs(stone[j]-stone[i])+1);
				power = Math.max(power, dp[j]);
				dp[i] = Math.min(dp[i], power);
			}
		}

		System.out.println(dp[n]);
	}
}
