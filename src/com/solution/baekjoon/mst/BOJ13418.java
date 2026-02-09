package com.solution.baekjoon.mst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ13418 {
    public static int[] building;
    public static boolean[] visited;
    public static List<Node> nodes = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        building = new int[n+1];

        for (int i=0; i<=n; i++) {
            building[i] = i;
        }

        for (int i=0; i<m+1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            nodes.add(new Node(a, b, c));
        }

        int up = 0, down = 0;
        Collections.sort(nodes, (o1, o2) -> o1.road - o2.road);
        for (Node node : nodes) {
            if (find(node.start) != find(node.end)) {
                union(node.start, node.end);
                if (node.road == 0) {
                    up++;
                } else {
                    down++;
                }
            }
        }
        double max = Math.pow(up, 2);

        up = 0;
        down = 0;
        for (int i=0; i<=n; i++) {
            building[i] = i;
        }
        Collections.sort(nodes, (o1, o2) -> o2.road - o1.road);
        for (Node node : nodes) {
            if (find(node.start) != find(node.end)) {
                union(node.start, node.end);
                if (node.road == 0) {
                    up++;
                } else {
                    down++;
                }
            }
        }
        System.out.println((int) (max - Math.pow(up, 2)));

    }
    public static int find(int x) {
        if (building[x] == x) {
            return x;
        }
        return building[x] = find(building[x]);
    }
    public static void union(int a, int b) {
        int x = find(a);
        int y = find(b);

        if (x != y) {
            building[x] = y;
        }
    }
    public static class Node {
        int start, end, road;

        public Node(int start, int end, int road) {
            this.start = start;
            this.end = end;
            this.road = road;
        }
    }
}
