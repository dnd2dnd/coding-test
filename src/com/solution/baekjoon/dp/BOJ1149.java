package com.solution.baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1149 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        int[][] colors = new int[n][3];
        int[][] dp = new int[n][3];
        for (int i=0; i<n; i++) {
            String[] strs = br.readLine().split(" ");
            for(int j=0; j<3; j++) {
                colors[i][j] = Integer.parseInt(strs[j]);
                dp[i][j] = Integer.MAX_VALUE;
            }
        }

        dp[0][0] = colors[0][0];
        dp[0][1] = colors[0][1];
        dp[0][2] = colors[0][2];
        for (int i=1; i<n; i++) {
            dp[i][0] = colors[i][0] + Math.min(dp[i-1][1], dp[i-1][2]);
            dp[i][1] = colors[i][1] + Math.min(dp[i-1][0], dp[i-1][2]);
            dp[i][2] = colors[i][2] + Math.min(dp[i-1][0], dp[i-1][1]);
        }

        System.out.println(Math.min(dp[n-1][2], Math.min(dp[n-1][0], dp[n-1][1])));
    }
}
