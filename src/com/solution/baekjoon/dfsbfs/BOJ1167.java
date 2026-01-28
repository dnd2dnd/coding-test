package com.solution.baekjoon.dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1167 {
    public static int v, index, cnt = Integer.MIN_VALUE;
    public static List<List<Node>> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());

        list.add(new ArrayList<>());
        for (int i=0; i<v; i++) {
            list.add(new ArrayList<>());
        }
        for (int i=1; i<=v; i++) {
            st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken());
            while (true) {
                int x = Integer.parseInt(st.nextToken());
                if (x==-1) {
                    break;
                }
                int y = Integer.parseInt(st.nextToken());

                list.get(idx).add(new Node(x, y));
            }
        }

        bfs(1);
        bfs(index);
        System.out.println(cnt);
    }

    public static void bfs(int x) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(x, 0));
        boolean[] visited = new boolean[v+1];
        visited[x] = true;
        while(!queue.isEmpty()) {
            Node cur = queue.poll();
            if (cnt < cur.w) {
                cnt = cur.w;
                index = cur.end;
            }

            for (Node node : list.get(cur.end)) {
                if (!visited[node.end]) {
                    visited[node.end] = true;
                    queue.add(new Node(node.end, cur.w + node.w));
                }
            }
        }
    }

    public static class Node {
        int end, w;

        public Node(int end, int w) {
            this.end = end;
            this.w = w;
        }
    }

}
