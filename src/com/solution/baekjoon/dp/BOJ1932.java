package com.solution.baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1932 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[][] nums = new int[n+1][n+1];
        for (int i=1; i<=n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= i; j++) {
                nums[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] dp = new int[n+1][n+1];
        dp[1][1] = nums[1][1];
        for(int i=2; i<=n; i++) {
            for (int j=1; j<=i; j++) {
                if (j==1) {
                    dp[i][j] = dp[i-1][j] + nums[i][j];
                } else if (j==i) {
                    dp[i][j] = dp[i-1][j-1] + nums[i][j];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j] + nums[i][j], dp[i-1][j-1] + nums[i][j]);
                }
            }
        }

        int max = 0;
        for (int j = 1; j <= n; j++) {
            max = Math.max(max, dp[n][j]);
        }

        System.out.println(max);
    }
}
