package com.solution.baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *  백준 9663, N-Queen, 골드 4
 */
public class BOJ9663 {
	static int n;
	static int[] chess;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		chess = new int[n];

		System.out.println(dfs(0));
	}
	public static int dfs(int x) {
		if(x==n) {
			return 1;
		}

		int cnt=0;
		for(int i=0; i<n; i++) {
			chess[x] = i;
			if(check(x)) {
				cnt += dfs(x+1);
			}
		}
		return cnt;
	}
	public static boolean check(int x) {
		for(int i=0; i<x; i++) {
			if(chess[x] == chess[i])
				return false;
			if(Math.abs(x-i) == Math.abs(chess[x] - chess[i]))
				return false;
		}
		return true;
	}
}

