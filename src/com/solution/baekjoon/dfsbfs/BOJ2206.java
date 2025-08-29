package com.solution.baekjoon.dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2206 {
    public static int N, M;
    public static int[] dx = {1, -1, 0 ,0};
    public static int[] dy = {0, 0, 1, -1};
    public static int[][] maps;
    public static int min = Integer.MAX_VALUE;

    public static class Node {
        int x;
        int y;
        int cnt;
        boolean b;

        public Node(int x, int y, int cnt, boolean b) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.b = b;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N  = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        maps = new int[N][M];
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            String a[] = st.nextToken().split("");
            for(int j=0; j<M; j++) {
                maps[i][j] = Integer.parseInt(a[j]);
            }
        }

        bfs(0, 0);
    }

    public static void bfs(int x, int y) {
        boolean[][][] visited = new boolean[N][M][2];
        visited[x][y][0] = true;

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(x, y, 1, false));
        while(!queue.isEmpty()) {
            Node node = queue.poll();
            int nx, ny;
            if (node.x == N-1 && node.y == M-1) {
                System.out.println(node.cnt);
                break;
            }
            for (int i=0; i<4; i++) {
                nx = node.x + dx[i];
                ny = node.y + dy[i];

                if (nx<0 || ny<0 || nx>=N || ny >=M) {
                    continue;
                }

                if (maps[nx][ny] == 1) {
                    if (!node.b) {
                        visited[nx][ny][1] = true;
                        queue.add(new Node(nx, ny, node.cnt+1, true));
                    }
                } else if (maps[nx][ny] == 0) {
                    if (!visited[nx][ny][0] && !node.b) {
                        visited[nx][ny][0] = true;
                        queue.add(new Node(nx, ny, node.cnt+1, node.b));
                    } else if (!visited[nx][ny][1] && node.b) {
                        visited[nx][ny][1] = true;
                        queue.add(new Node(nx, ny, node.cnt+1, node.b));
                    }
                }

            }
        }

    }
}
