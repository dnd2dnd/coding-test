package com.solution.baekjoon.dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ2458 {
    public static int cnt = 0;
    public static boolean[] visited;
    public static List<List<Integer>> list = new ArrayList<>();
    public static List<List<Integer>> reverselist = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int i=0; i<=N; i++) {
            list.add(new ArrayList<>());
            reverselist.add(new ArrayList<>());
        }

        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            list.get(x).add(y);
            reverselist.get(y).add(x);
        }

        int sum = 0;
        for (int i=1; i<=N; i++) {
            cnt = 0;
            visited = new boolean[N+1];
            dfs(i, list);

            visited = new boolean[N+1];
            dfs(i, reverselist);

            if (cnt == N-1) {
                sum++;
            }
        }

        System.out.println(sum);
    }
    public static void dfs(int x, List<List<Integer>> list) {
        visited[x] = true;

        for (Integer i : list.get(x)) {
            if(!visited[i]) {
                cnt++;
                dfs(i, list);
            }
        }
    }
}
