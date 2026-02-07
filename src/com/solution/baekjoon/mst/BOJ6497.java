package com.solution.baekjoon.mst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ6497 {
    public static int[] roads;
    public static List<Node> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()); // 집 개수
            int m = Integer.parseInt(st.nextToken()); // 도로 수

            if (n == 0 && m == 0) break;

            roads = new int[n];
            list = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                roads[i] = i;
            }

            int total = 0;

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());

                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());

                list.add(new Node(a, b, c));
                total += c;
            }

            Collections.sort(list);

            int sum = 0;
            for (Node node : list) {
                if (find(node.x) != find(node.y)) {
                    union(node.x, node.y);
                    sum += node.w;
                }
            }

            System.out.println(total - sum);
        }

    }

    public static int find(int x) {
        if (roads[x] == x) return x;
        return roads[x] = find(roads[x]);
    }

    public static void union(int a, int b) {
        int x = find(a);
        int y = find(b);

        if (x == y) {
            return;
        }
        roads[x] = y;
    }

    public static class Node implements Comparable<Node>{
        int x, y, w;

        public Node(int x, int y, int w) {
            this.x = x;
            this.y = y;
            this.w = w;
        }

        public int compareTo(Node node) {
            return this.w - node.w;
        }
    }
}
