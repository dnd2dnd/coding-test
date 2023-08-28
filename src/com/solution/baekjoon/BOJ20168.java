package com.solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 *  백준 20168, 골목 대장 호석, 골드 5
 */
public class BOJ20168 {
    public static ArrayList<Node>[] graph;
    public static boolean[] visited;
    public static int b, c;
    public static int min = Integer.MAX_VALUE;
    public static class Node {
        int v, s;

        public Node(int v, int s) {
            this.v = v;
            this.s = s;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        visited = new boolean[n+1];
        graph = new ArrayList[n+1];
        for(int i=0; i<n+1; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            graph[x].add(new Node(y, z));
            graph[y].add(new Node(x, z));
        }
        visited[a] = true;
        dfs(a, 0 ,0);
        if(min==Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(min);
        }
    }

    public static void dfs(int x, int score, int max) {
        if(score > c) {
            return;
        }
        if(x==b) {
            min = Math.min(min, max);
            return;
        }
        for (Node node : graph[x]) {
            if(!visited[node.v]) {
                visited[node.v] = true;
                dfs(node.v, score + node.s, Math.max(max, node.s));
                visited[node.v] = false;
            }
        }
    }
}
