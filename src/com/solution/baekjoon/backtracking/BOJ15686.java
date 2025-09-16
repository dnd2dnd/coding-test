package com.solution.baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ15686 {
    public static class Node {
        int x, y;

        public Node (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static int N, M;
    public static boolean[] visited;
    public static List<Node> home = new ArrayList<>();
    public static List<Node> chicken = new ArrayList<>();
    public static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<N; j++) {
                int value = Integer.parseInt(st.nextToken());
                if (value == 1) {
                    home.add(new Node(i, j));
                } else if (value == 2) {
                    chicken.add(new Node(i, j));
                }
            }
        }

        visited = new boolean[chicken.size()];

        comb(0, 0);
        System.out.println(min);
    }
    public static void comb(int d, int x) {
        if (d == M) {
            calculateCityChickenDistance();
        }

        for (int i = x; i < chicken.size(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                comb(d+1, i+1);
                visited[i] = false;
            }
        }

    }

    public static void calculateCityChickenDistance() {
        int totalDistance = 0;

        for (Node house : home) {
            int minDistanceForHouse = Integer.MAX_VALUE;

            for (int i = 0; i < chicken.size(); i++) {
                if (visited[i]) {
                    // 선택된 치킨집에 대해 거리 계산
                    Node cNode = chicken.get(i);
                    int distance = Math.abs(house.x - cNode.x) + Math.abs(house.y - cNode.y);
                    minDistanceForHouse = Math.min(minDistanceForHouse, distance);
                }
            }
            totalDistance += minDistanceForHouse;
        }

        min = Math.min(min, totalDistance);
    }
}
