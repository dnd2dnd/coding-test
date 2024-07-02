package com.solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ1949 {
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    static int[][] dp;
    static int[] village;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        village = new int[N+1];
        dp = new int[N+1][2];
        StringTokenizer st = new StringTokenizer(br.readLine());
        list.add(new ArrayList<>());
        for(int i=1; i<=N; i++) {
            list.add(new ArrayList<>());
            village[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list.get(a).add(b);
            list.get(b).add(a);
        }

        checkGoodVillage(1, 0);
        System.out.println(Math.max(dp[1][0], dp[1][1]));
    }
    public static void checkGoodVillage(int n, int parent) {
        for (Integer i : list.get(n)) {
            if(i != parent) {
                checkGoodVillage(i, n);
                dp[n][0] += Math.max(dp[i][0], dp[i][1]);
                dp[n][1] += dp[i][0];
            }
        }
        dp[n][1] += village[n];
    }
}
