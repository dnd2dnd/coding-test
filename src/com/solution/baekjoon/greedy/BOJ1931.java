package com.solution.baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        Node[] nodes = new Node[n];
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            nodes[i] = new Node(x, y);
        }

        Arrays.sort(nodes);

        int cnt = 1;
        int e = nodes[0].end;
        for (int i=1; i<n; i++) {
            Node node = nodes[i];

            if (e < node.start) {
                e = node.end;
                cnt++;
            }
        }
        System.out.println(cnt);

    }
    public static class Node implements Comparable<Node>{
        int start, end;

        public Node(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int compareTo(Node node) {
            if (this.end == node.end) {
                return this.start - node.start;
            }
            return this.end - node.end;
        }
    }
}
