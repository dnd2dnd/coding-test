package com.solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ11265 {
    public static class Node implements Comparable<Node>{
        int y, z;

        public Node(int y, int z) {
            this.y = y;
            this.z = z;
        }

        @Override
        public int compareTo(Node node) {
            return this.z - node.z;
        }
    }
    static List<List<Node>> list = new ArrayList<>();
    static int[][] party;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for(int i=0; i<=n; i++) {
            list.add(new ArrayList<>());
        }

        for(int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=n; j++) {
                int x = Integer.parseInt(st.nextToken());
                if(i!=j) {
                    list.get(i).add(new Node(j, x));
                }
            }
        }

        party = new int[n+1][n+1];
        for(int i=1; i<=n; i++) {
            goParty(i);
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if(party[a][b] <= c) {
                sb.append("Enjoy other party").append("\n");
            } else {
                sb.append("Stay here").append("\n");
            }
        }
        System.out.println(sb);
    }
    public static void goParty(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        Arrays.fill(party[start], 1_000_000_000);
        while(!pq.isEmpty()) {
            Node nd = pq.poll();

            for (Node node : list.get(nd.y)) {
                if(party[start][node.y] > nd.z + node.z) {
                    party[start][node.y] = nd.z + node.z;
                    pq.add(new Node(node.y, nd.z + node.z));
                }
            }
        }
    }
}
