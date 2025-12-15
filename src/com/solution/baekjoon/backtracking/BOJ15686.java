package com.solution.baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ15686 {
    public static int n, m;
    public static int cnt = Integer.MAX_VALUE;
    public static List<Integer> nums = new ArrayList<>();
    public static List<Node> chickens = new ArrayList<>();
    public static List<Node> homes = new ArrayList<>();
    public static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i=0; i<n; i++) {
            String[] strs = br.readLine().split(" ");
            for(int j=0; j< strs.length; j++) {
                int x = Integer.parseInt(strs[j]);
                if (x== 1) {
                    homes.add(new Node(i, j));
                }
                if (x== 2) {
                    chickens.add(new Node(i, j));
                }
            }
        }

        visited = new boolean[chickens.size()];
        comb(0, 0);
        System.out.println(cnt);
    }

    public static void comb(int d, int x) {
        if(d == m) {
            int totalMin = 0;
            for (Node home : homes) {
                int min = Integer.MAX_VALUE;
                for (int i = 0; i < chickens.size(); i++) {
                    if(visited[i]) {
                        int value = Math.abs(chickens.get(i).x - home.x) + Math.abs(chickens.get(i).y - home.y);
                        min = Math.min(value, min);
                    }
                }
                totalMin += min;
            }
            cnt = Math.min(totalMin, cnt);
        }

        for (int i = x; i < chickens.size(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                comb(d+1, i+1);
                visited[i] = false;
            }
        }
    }

    public static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
