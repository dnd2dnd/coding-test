package com.solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ9663 {
	static int n, ans = 0;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n];

		dfs(0);
		System.out.println(ans);
	}
	public static void dfs(int x) {
		if(x == n) {
			ans++;
			return;
		}

		for(int i=0; i<n; i++) {
			arr[x] = i;
			if(check(x)) {
				dfs(x+1);
			}
		}

	}
	public static boolean check(int x) {
		for(int i=0; i<x; i++) {
			if(arr[x] == arr[i]) {
				return false;
			}
			if(Math.abs(x-i) == Math.abs(arr[x]-arr[i])) {
				return false;
			}
		}
		return true;
	}
}