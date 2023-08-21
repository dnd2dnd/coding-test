package com.solution.baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 백준 1495번, 기타리스트, 실버 1
 *  어렵네
 */
public class BOJ1495 {
    static int[] volumes;
    static int[][] dp;

    static int n, s, m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        volumes = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            volumes[i] = Integer.parseInt(st.nextToken());
        }

        dp = new int[m+1][n];

        for (int[] arr : dp) {
            Arrays.fill(arr, -2);
        }

        System.out.println(recur(s, 0));
    }
    public static int recur(int x, int v) {
        if(x>m || x<0)
            return -1;

        if (v==n) {
            return x;
        }

        if(dp[x][v] != -2) {
            return dp[x][v];
        }
        return dp[x][v] = Math.max(dp[x][v],
                Math.max(recur(x+volumes[v], v+1), recur(x-volumes[v], v+1)));
    }
}
