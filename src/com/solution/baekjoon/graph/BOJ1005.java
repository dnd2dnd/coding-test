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
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            String[] strs = br.readLine().split(" ");

            List<List<Integer>> list = new ArrayList<>();
            list.add(new ArrayList<>());
            int[] point = new int[n+1];
            int[] dp = new int[n+1];
            for (int i=1; i<=n; i++) {
                list.add(new ArrayList<>());
                point[i] = Integer.parseInt(strs[i-1]);
                dp[i] = point[i];
            }

            int[] condition = new int[n+1];
            for (int i=0; i<k; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                list.get(x).add(y);
                condition[y]++;
            }
            int w = Integer.parseInt(br.readLine());
            
            Queue<Integer> queue = new LinkedList<>();
            for (int i=0; i<=n; i++) {
                if (condition[i] == 0) {
                    queue.add(i);
                }
            }
            
            while(!queue.isEmpty()) {
                int x = queue.poll();
                for (Integer next : list.get(x)) {
                    dp[next] = Math.max(dp[next], dp[x] + point[next]);
                    condition[next]--;
                    if (condition[next] == 0) {
                        queue.add(next);
                    }
                }
            }
            System.out.println(dp[w]);
        }
    }
}
