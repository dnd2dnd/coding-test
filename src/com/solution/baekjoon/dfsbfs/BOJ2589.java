package com.solution.baekjoon.dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2589 {
    public static int[] dx = {1,0,-1,0};
    public static int[] dy = {0,1,0,-1};
    public static int k;
    public static int n;
    public static int time = Integer.MIN_VALUE;

    public static class Node {
        int x;
        int y;
        int cnt;

        public Node(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        k  = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        String[][] arr = new String[k][n];
        for(int i=0; i<k; i++) {
            String[] strs = br.readLine().split("");
            for(int j=0; j<n; j++) {
                arr[i][j] = strs[j];
            }
        }

        for (int i = 0; i < k; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j].equals("L")) {
                    bfs(i, j, arr);
                }
            }
        }
        System.out.println(time);
    }

    public static void bfs(int x, int y, String[][] arr) {
        boolean[][] visited = new boolean[k][n];
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x, y, 0));

        while(!q.isEmpty()) {
            Node current = q.poll();
            time = Math.max(time, current.cnt);
            for (int i=0; i<4; i++) {
                int nx = current.x+dx[i];
                int ny = current.y+dy[i];

                if (nx < 0 || nx >= k || ny < 0 || ny >= n || visited[nx][ny] || arr[nx][ny].equals("W")) {
                    continue;
                }
                visited[nx][ny] = true;
                q.add(new Node(nx, ny, current.cnt+1));
            }
        }
    }
}
