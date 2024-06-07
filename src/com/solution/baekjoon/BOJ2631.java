package com.solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ2631 {
	public static int cnt=0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int[] children = new int[n];
		for(int i=0; i<n; i++) {
			children[i] = Integer.parseInt(br.readLine());
		}

		int max = 0;
		int[] dp = new int[n];
		for(int i=0; i<n; i++) {
			dp[i] = 1;
			for(int j=i-1; j>=0; j--) {
				if(children[j] < children[i]) {
					dp[i] = Math.max(dp[i], dp[j]+1);
				}
			}
			max = Math.max(max, dp[i]);
		}
		System.out.println(Arrays.toString(dp));
		System.out.println(n-max);
	}

}