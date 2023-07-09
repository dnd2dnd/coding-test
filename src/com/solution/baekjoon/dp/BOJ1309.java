package com.solution.baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 백준 1309번 동물원, 실버 1
 */
public class BOJ1309 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int[][] dp=new int[n+1][3];
		Arrays.fill(dp[1],1);

		for(int i=2;i<=n;i++){
			dp[i][0]=dp[i-1][0]+dp[i-1][1]+dp[i-1][2];
			dp[i][1]=dp[i-1][2]+dp[i-1][0];
			dp[i][2]=dp[i-1][1]+dp[i-1][0];
			dp[i][0] %= 9901;
			dp[i][1] %= 9901;
			dp[i][2] %= 9901;
		}

		int res=0;

		for(int i =0; i<3; i++){
			res+=dp[n][i];
		}

		System.out.println(res%9901);
		// long[][] com = new long[n+1][n+1];
		// com[1][0] = 1;
		// com[1][1] = 1;
		// int sum = 0;
		// for(int i=2; i<=n; i++) {
		// 	com[i][0]=1;
		// 	for(int j=1; j<=n; j++) {
		// 		com[i][j] = com[i-1][j-1] + com[i-1][j];
		// 		sum += com[i][j];
		// 	}
		// 	sum += com[i][0];
		// }
		// for(int i=0; i<=n; i++) {
		// 	for(int j=0; j<=n; j++) {
		// 		System.out.print(com[i][j] + " ");
		// 	}
		// 	System.out.println();
		// }
		// System.out.println(sum%9901);
	}
}
