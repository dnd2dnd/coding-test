package com.solution.baekjoon.prefixSum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 *   * 백준 2559, 수열 실버 3
 */
public class BOJ2559 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[] num = new int[n+1];
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=n; i++) {
			num[i] = num[i-1] + Integer.parseInt(st.nextToken());
		}

		int max = Integer.MIN_VALUE;
		for(int i=k; i<=n; i++) {
			max = Math.max(max, num[i]-num[i-k]);
		}

		System.out.println(max);
	}
}
