package com.solution.baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            pq.add(new Node(x, y));
        }

        int cnt = 0;
        int end = 0;
        while (!pq.isEmpty()) {
            Node node = pq.poll();

            if (node.s >= end) {
                cnt++;
                end = node.e;
            }
        }
        System.out.println(cnt);
}
    public static class Node implements Comparable<Node>{
        int s, e;

        public Node(int s, int e) {
            this.s = s;
            this.e = e;
        }

        public int compareTo(Node node) {
            if (this.e == node.e) {
                return this.s - node.s;
            }
            return this.e - node.e;
        }
    }
}
