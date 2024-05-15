package com.solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ2252 {
    static StringBuffer sb = new StringBuffer();
    static int[] edge;
    static boolean[] visited;
    static List<List<Integer>> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        edge = new int[n+1];
        visited = new boolean[n+1];
        for(int i=0; i<=n; i++) {
            list.add(new ArrayList<>());
        }

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            edge[b]++;
        }

        for(int i=1; i<=n; i++) {
            if(edge[i] == 0 && !visited[i]) {
                tree(i);
            }
        }
        System.out.println(sb);
    }
    public static void tree(int x) {
        visited[x] = true;
        sb.append(x).append(" ");

        for (Integer i : list.get(x)) {
            edge[i]--;
            if(edge[i] == 0 && !visited[i]) {
                tree(i);
            }
        }
    }
}
