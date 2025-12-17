package com.solution.baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2096 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[][] minDp = new int[2][3];
        int[][] maxDp = new int[2][3];
        for(int i=1; i<=n; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            minDp[0][0] = minDp[1][0];
            minDp[0][1] = minDp[1][1];
            minDp[0][2] = minDp[1][2];

            minDp[1][0] = Math.min(minDp[0][0], minDp[0][1]) + a;
            minDp[1][1] = Math.min(minDp[0][0], Math.min(minDp[0][1], minDp[0][2])) + b;
            minDp[1][2] = Math.min(minDp[0][1], minDp[0][2]) + c;

            maxDp[0][0] = maxDp[1][0];
            maxDp[0][1] = maxDp[1][1];
            maxDp[0][2] = maxDp[1][2];

            maxDp[1][0] = Math.max(maxDp[0][0], maxDp[0][1]) + a;
            maxDp[1][1] = Math.max(maxDp[0][0], Math.max(maxDp[0][1], maxDp[0][2])) + b;
            maxDp[1][2] = Math.max(maxDp[0][1], maxDp[0][2]) + c;
        }
        System.out.println(Math.max(maxDp[1][0], Math.max(maxDp[1][1], maxDp[1][2])) + " " +
                Math.min(minDp[1][0], Math.min(minDp[1][1], minDp[1][2])));
    }
}
