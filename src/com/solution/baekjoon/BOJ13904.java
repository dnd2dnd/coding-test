package com.solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ13904 {
    public static class Node implements Comparable<Node>{
        int d, w;

        public Node(int d, int w) {
            this.d = d;
            this.w = w;
        }

        @Override
        public int compareTo(Node o) {
            if (this.w == o.w) {
                return o.d - this.d;
            }
            return o.w - this.w;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        int day = Integer.MIN_VALUE;
        Node[] nodes = new Node[n];
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            nodes[i] = new Node(x, y);
            day = Math.max(day, x);
        }
        Arrays.sort(nodes);

        int sum = 0;
        boolean[] visited = new boolean[day+1];
        for (Node node : nodes) {
//            System.out.println(node.d + " " + node.w);
            for (int i = node.d; i>=1; i--) {
                if (!visited[i]) {
                    visited[i] = true;
                    sum += node.w;
                    break;
                }
            }
        }
        System.out.println(sum);
    }
}
