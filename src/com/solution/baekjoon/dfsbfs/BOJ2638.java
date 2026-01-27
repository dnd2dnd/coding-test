package com.solution.baekjoon.dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2638 {
    public static int[] dx = {1, -1, 0, 0};
    public static int[] dy = {0, 0, 1, -1};
    public static int[][] maps;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        maps = new int[n][m];
        boolean[][][] visited = new boolean[n][m][2];

        for (int i=0; i<n; i++) {
            String[] strs = br.readLine().split("");
            for (int j=0; j<m; j++) {
                maps[i][j] = Integer.parseInt(strs[j]);
            }
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0, 0, 1, false));
        visited[0][0][0] = true;
        int cnt = -1;
        while(!queue.isEmpty()) {
            Node node = queue.poll();
            if (node.x == n-1 && node.y == m-1) {
                cnt = node.z;
                break;
            }

            int nx, ny;
            for (int i=0; i<4; i++) {
                nx = node.x + dx[i];
                ny = node.y + dy[i];

                if (nx<0 || ny<0 || nx>=n || ny>=m) {
                    continue;
                }

                if (maps[nx][ny] == 1) {
                    if (!node.broken) {
                        visited[nx][ny][1] = true;
                        queue.add(new Node(nx, ny, node.z+1, true));
                    }
                } else if (maps[nx][ny] == 0){
                    if (!visited[nx][ny][0] && !node.broken) {
                        visited[nx][ny][0] = true;
                        queue.add(new Node(nx, ny, node.z+1, node.broken));
                    } else if (!visited[nx][ny][1] && node.broken) {
                        visited[nx][ny][1] = true;
                        queue.add(new Node(nx, ny, node.z+1, node.broken));
                    }
                }
            }
        }
        System.out.println(cnt);
    }

    public static class Node {
        int x, y, z;
        boolean broken;

        public Node(int x, int y, int z, boolean broken) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.broken = broken;
        }
    }
}
