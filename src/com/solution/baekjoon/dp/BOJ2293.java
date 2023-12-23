package com.solution.baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 2293, 동전 1, 골드 5
 * https://www.acmicpc.net/problem/2293
 */
public class BOJ2293 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[] coin = new int[n+1];
		for(int i=0; i<n; i++) {
			coin[i] = Integer.parseInt(br.readLine());
		}

		int[] dp = new int[k+1];

		dp[0] = 1;
		for(int i=0; i<n; i++) {
			for(int j=1; j<=k; j++) {
				if(j>=coin[i]) {
					dp[j] += dp[j-coin[i]];
				}
			}
		}
		System.out.println(dp[k]);
	}
}
