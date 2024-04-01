package com.solution.baekjoon.bitmasking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1562 {
	static final int MOD = 1000000000;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		long[][][] dp = new long[N+1][10][1 << 10];
		for (int i = 1; i <= 9; i++)
			dp[1][i][1 << i] = 1;

		for (int n = 2; n <= N; n++) {
			for (int k = 0; k <= 9; k++) {
				for (int v = 0; v < (1 << 10); v++) {

					int visit = v | (1 << k);

					if (k == 0)
						dp[n][k][visit] += dp[n - 1][k + 1][v] % MOD;
					else if (k == 9)
						dp[n][k][visit] += dp[n - 1][k - 1][v] % MOD;
					else
						dp[n][k][visit] += dp[n - 1][k + 1][v] % MOD + dp[n - 1][k - 1][v] % MOD;

					dp[n][k][visit] %= MOD;
				}
			}
		}

		long sum = 0;
		for (int i = 0; i <= 9; i++) {
			sum += dp[N][i][(1 << 10) - 1] % MOD;
			sum %= MOD;
		}
		System.out.println(sum);
	}
}
