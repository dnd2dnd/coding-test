package com.solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *  백준 2096, 내려가기, 골드 5
 */
public class BOJ2096 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] dp = new int[6];
		StringTokenizer st;

		int a, b, c;
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());

			if(i==0) {
				dp[0] = dp[3] = a;
				dp[1] = dp[4] = b;
				dp[2] = dp[5] = c;
			} else {
				int temp0 = dp[0];
				int temp2 = dp[2];

				dp[0] = Math.max(dp[0], dp[1]) + a;
				dp[2] = Math.max(dp[1], dp[2]) + c;
				dp[1] = Math.max(temp0, Math.max(dp[1], temp2)) + b;

				int temp3 = dp[3];
				int temp5 = dp[5];
				dp[3] = Math.min(dp[3], dp[4]) + a;
				dp[5] = Math.min(dp[4], dp[5]) + c;
				dp[4] = Math.min(temp3, Math.min(dp[4], temp5)) + b;
			}
		}
		System.out.println(Math.max(dp[0], Math.max(dp[1], dp[2])) + " "
			+ Math.min(dp[3], Math.min(dp[4], dp[5])));
	}
}
