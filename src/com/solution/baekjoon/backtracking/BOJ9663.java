package com.solution.baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준 9663, N-Queen, 골드 4
 */
public class BOJ9663 {
	static int n, cnt;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		cnt=0;
		dfs(0);
		System.out.println(cnt);
	}
	public static void dfs(int d) {
		if(d == n) {
			cnt++;
			return;
		}

		for(int i=0; i<n; i++) {
			arr[d] = i;
			if(chess(d)) {
				dfs(d+1);
			}
		}
	}

	public static boolean chess(int d) {
		for(int i=0; i<d; i++) {
			if(arr[i] == arr[d]) {
				return false;
			} else if (Math.abs(d-i) == Math.abs(arr[d] - arr[i])) {
				return false;
			}
		}
		return true;
	}
}
