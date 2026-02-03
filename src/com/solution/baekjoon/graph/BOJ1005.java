package com.solution.baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1005 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t=0; t<T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            List<List<Integer>> list = new ArrayList<>();
            list.add(new ArrayList<>());

            int[] buildings = new int[N+1];
            int[] condition = new int[N+1];
            int[] dp = new int[N+1];
            st = new StringTokenizer(br.readLine());
            for (int n=1; n<=N; n++) {
                list.add(new ArrayList<>());
                buildings[n] = Integer.parseInt(st.nextToken());
                dp[n] = buildings[n];
            }

            for (int k=0; k<K; k++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                list.get(x).add(y);
                condition[y]++;
            }

            int W = Integer.parseInt(br.readLine());

            Queue<Integer> queue = new LinkedList<>();
            for (int i = 0; i < condition.length; i++) {
                if (condition[i] == 0) {
                    queue.add(i);
                }
            }

            while (!queue.isEmpty()) {
                int v = queue.poll();
                for (Integer i : list.get(v)) {
                    dp[i] = Math.max(dp[v] + buildings[i], dp[i]);
                    condition[i]--;
                    if (condition[i] == 0) {
                        queue.add(i);
                    }
                }
            }
            System.out.println(dp[W]);
        }
    }
}
