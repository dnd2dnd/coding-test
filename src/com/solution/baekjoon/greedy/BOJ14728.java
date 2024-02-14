package com.solution.baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14728 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());

		int[] time = new int[n+1];
		int[] score = new int[n+1];
		for(int i=1; i<=n; i++) {
			st = new StringTokenizer(br.readLine());
			time[i] = Integer.parseInt(st.nextToken());
			score[i] = Integer.parseInt(st.nextToken());
		}

		int[][] dp = new int[n+1][t+1];
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=t; j++) {
				if(time[i] > j) {
					dp[i][j] = dp[i-1][j];
				} else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-time[i]] + score[i]);
				}
			}
		}
		System.out.println(dp[n][t]);
	}
}
