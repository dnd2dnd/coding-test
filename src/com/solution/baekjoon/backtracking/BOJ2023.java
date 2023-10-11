package com.solution.baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준 2023, 신기한 소수, 골드 5
 */
public class BOJ2023 {
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		dfs(0, 0);

	}
	public static void dfs(int x, int d) {
		if(d==N) {
			System.out.println(x);
		}
		for(int i=1; i<10; i++) {
			int t = 10*x + i;
			if(d<N && checkPrime(t)) {
				dfs(t, d+1);
			}
		}
	}
	public static boolean checkPrime(int x) {
		if(x<=1) {
			return false;
		}

		for (int i = 2; i<=(int)Math.sqrt(x); i++) {
			if (x % i == 0) {
				return false;
			}
		}
		return true;
	}
}
