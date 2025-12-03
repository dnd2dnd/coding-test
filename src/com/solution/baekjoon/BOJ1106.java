package com.solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1106 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int c = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        Node[] nodes = new Node[n];
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            nodes[i] = new Node(x, y);
        }

        int[] dp = new int[c+1];
        Arrays.fill(dp, 1_000_000_000);
        dp[0] = 0;
        for (int i=1; i<=c; i++) {
            for (int j=0; j<n; j++) {
                if (i - nodes[j].x >= 0) {
                    dp[i] = Math.min(dp[i-nodes[j].x] + nodes[j].y, dp[i]);
                } else {
                    dp[i] = Math.min(dp[0] + nodes[j].y, dp[i]);
                }
            }
        }
        System.out.println(dp[c]);
    }

    public static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
