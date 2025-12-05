package com.solution.baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11660 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] nums = new int[n+1][n+1];
        int[][] dp = new int[n+1][n+1];
        for (int i=1; i<=n; i++) {
            String[] strs = br.readLine().split(" ");
            for (int j=0; j<n; j++) {
                nums[i][j+1] = Integer.parseInt(strs[j]);
            }
        }
        for(int i=1; i<=n; i++) {
            for (int j=1; j<=n; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1] + nums[i][j];
            }
        }

        for (int i=0; i<m; i++) {
            String[] strs = br.readLine().split(" ");
            int x1 = Integer.parseInt(strs[0]);
            int y1 = Integer.parseInt(strs[1]);
            int x2 = Integer.parseInt(strs[2]);
            int y2 = Integer.parseInt(strs[3]);

            System.out.println(dp[x2][y2] - dp[x1-1][y2] - dp[x2][y1-1] + dp[x1-1][y1-1]);
        }
    }
}
