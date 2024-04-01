package com.solution.baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1965 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] box = new int[n];
        int[] dp = new int[n];
        int ans = Integer.MIN_VALUE;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            box[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=1; i<n; i++) {
            for(int j=i; j>=0; j--) {
                if(box[j] < box[i]) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
        }

        for(int i=0; i<n; i++) {
            ans = Math.max(ans, dp[i]);
        }

        System.out.println(ans+1);
    }
}
