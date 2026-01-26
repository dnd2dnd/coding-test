package com.solution.baekjoon.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ14938 {
    public static int n, m, r, sum = 0;
    public static int[] place;
    public static List<List<Node>> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        place = new int[n+1];
        st = new StringTokenizer(br.readLine());

        list.add(new ArrayList<>());
        for (int i=0; i<n; i++) {
            place[i+1] = Integer.parseInt(st.nextToken());
            list.add(new ArrayList<>());
        }

        for (int i=0; i<r; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list.get(a).add(new Node(b, c));
            list.get(b).add(new Node(a, c));
        }

        for(int i=1; i<=n; i++) {
            bfs(i);
        }
        System.out.println(sum);
    }

    public static void bfs(int x) {
        PriorityQueue<Node> queue = new PriorityQueue<>((a, b) -> a.w-b.w);
        queue.add(new Node(x, 0));
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[x] = 0;

        while(!queue.isEmpty()) {
            Node cur = queue.poll();
            if (cur.w > dist[cur.end]) {
                continue;
            }

            for (Node node : list.get(cur.end)) {
                int cost = node.w + cur.w;

                if (cost < dist[node.end]) {
                    dist[node.end] = cost;
                    queue.add(new Node(node.end, cost));
                }
            }
        }

        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] <= m) {
                cnt += place[i];
            }
        }

        sum = Math.max(cnt, sum);
    }

    public static class Node {
        int end, w;

        public Node(int end, int w) {
            this.end = end;
            this.w = w;
        }
    }
}
