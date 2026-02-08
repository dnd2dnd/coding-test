package com.solution.baekjoon.mst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ1647 {
    public static int[] home;
    public static List<Node> nodes = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        home = new int[n+1];
        for(int i=0; i<=n; i++) {
            home[i] = i;
        }

        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            nodes.add(new Node(a, b, c));
        }
        Collections.sort(nodes, (o1, o2) -> o1.w - o2.w);

        int sum = 0;
        int max = -1;
        for (Node node : nodes) {
            if (find(node.x) != find(node.y)) {
                union(node.x, node.y);
                max = node.w;
                sum += node.w;
            }
        }

        System.out.println(sum-max);
    }
    public static int find(int x) {
        if (home[x] == x) {
            return x;
        }
        return home[x] = find(home[x]);
    }
    public static void union(int x, int y) {
        int a = find(x);
        int b = find(y);

        if (a != b) {
            home[a] = b;
        }
    }
    public static class Node {
        int x, y, w;

        public Node(int x, int y, int w) {
            this.x = x;
            this.y = y;
            this.w = w;
        }
    }
}
