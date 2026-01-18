package com.solution.baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ9465 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for(int i=0; i<t; i++) {
            int n = Integer.parseInt(br.readLine());
            int[][] maps = new int[2][n];
            int[][] dp = new int[2][n];
            for (int j=0; j<2; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int k=0; k<n; k++) {
                    maps[j][k] = Integer.parseInt(st.nextToken());
                }
            }
            dp[0][0] = maps[0][0];
            dp[1][0] = maps[1][0];

            if (n>1) {
                dp[0][1] = dp[1][0] + maps[0][1];
                dp[1][1] = maps[0][0] + maps[1][1];

                for (int q=2; q<n; q++) {
                    dp[0][q] = Math.max(dp[1][q-1], dp[1][q-2]) + maps[0][q];
                    dp[1][q] = Math.max(dp[0][q-1], dp[0][q-2]) + maps[1][q];
                }
            }

            System.out.println(Math.max(dp[0][n-1], dp[1][n-1]));
        }
    }
}
