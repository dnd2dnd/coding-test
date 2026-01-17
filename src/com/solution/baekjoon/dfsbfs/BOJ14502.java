package com.solution.baekjoon.dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ14502 {
    public static int n, m;
    public static int[][] maps;
    public static boolean[][] visited;
    public static int[] dx = {1, -1, 0, 0};
    public static int[] dy = {0, 0 ,1 ,-1};
    public static int cnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        maps = new int[n][m];
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<m; j++) {
                maps[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0);
        System.out.println(cnt);
    }

    public static void bfs() {
        Queue<Node> queue = new LinkedList<>();
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (maps[i][j] == 2) {
                    queue.add(new Node(i, j));
                }
            }
        }

        int[][] copyMap = new int[n][m];
        for (int i=0; i<n; i++) {
            copyMap[i] = maps[i].clone();
        }
        while(!queue.isEmpty()) {
            Node node = queue.poll();
            int nx, ny;
            for (int i=0; i<4; i++) {
                nx = node.x + dx[i];
                ny = node.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                    continue;
                }

                if (copyMap[nx][ny] == 0) {
                    queue.add(new Node(nx, ny));
                    copyMap[nx][ny] = 2;
                }
            }
        }

        int c = 0;
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (copyMap[i][j] == 0) {
                    c++;
                }
            }
        }
        cnt = Math.max(c, cnt);
    }

    public static void dfs(int d) {
        if (d == 3) {
            bfs();
            return;
        }

        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (maps[i][j] == 0) {
                    maps[i][j] = 1;
                    dfs(d+1);
                    maps[i][j] = 0;
                }
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
