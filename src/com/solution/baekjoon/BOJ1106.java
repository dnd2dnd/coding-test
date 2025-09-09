package com.solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1106 {
    public static class Node {
        int person, money;

        public Node (int person, int money) {
            this.person = person;
            this.money = money;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        Node[] nodes = new Node[N+1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            int m = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            nodes[i] = new Node(p, m);

        }
        final int INF = 1_000_000_000;
        int[] dp = new int[C + 1];
        Arrays.fill(dp, INF);
        dp[0] = 0;
        for (int i=1; i<=C; i++) {
            for (int j=1; j<=N; j++) {
                if (i-nodes[j].person >= 0) {
                    dp[i] = Math.min(dp[i-nodes[j].person] + nodes[j].money, dp[i]);
                } else {
                    dp[i] = Math.min(dp[0] + nodes[j].money, dp[i]);
                }

            }
        }
        System.out.println(dp[C]);
    }
}
