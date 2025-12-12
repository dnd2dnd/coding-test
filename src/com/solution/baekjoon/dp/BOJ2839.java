package com.solution.baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ2839 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        if (n>=3) {
            dp[3] = 1;
        }
        if (n>=5) {
            dp[5] = 1;
        }
        for (int i=6; i<=n; i++) {
            if (dp[i-3] != Integer.MAX_VALUE && dp[i-5] != Integer.MAX_VALUE) {
                dp[i] = Math.min(dp[i-3], dp[i-5]) + 1;
            } else if(dp[i-3] != Integer.MAX_VALUE) {
                dp[i] = dp[i-3] + 1;
            } else if(dp[i-5] != Integer.MAX_VALUE) {
                dp[i] = dp[i-5] + 1;
            }
        }
        if(dp[n] == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(dp[n]);
        }
    }
}
