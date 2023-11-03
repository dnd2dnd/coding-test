package com.solution.baekjoon.dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 백준 7569, 토마토, 골드 5
 */
public class BOJ7569 {
    static int m,n,h;
    static int[][][] box;
    static int[] dx = {1, -1, 0, 0, 0, 0};
    static int[] dy = {0, 0, 1, -1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};
    public static class Node {
        int z, y, x, c;

        public Node(int z, int y, int x, int c) {
            this.z = z;
            this.y = y;
            this.x = x;
            this.c = c;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = br.readLine().split(" ");
        m = Integer.parseInt(strs[0]);
        n = Integer.parseInt(strs[1]);
        h = Integer.parseInt(strs[2]);

        box = new int[h][n][m];
        StringTokenizer st;

        Queue<Node> queue = new LinkedList<>();
        for(int i=0; i<h; i++) {
            for(int j=0; j<n; j++) {
                st = new StringTokenizer(br.readLine());
                for(int k=0; k<m; k++) {
                   box[i][j][k] = Integer.parseInt(st.nextToken());
                   if(box[i][j][k] == 1){
                        queue.add(new Node(i, j, k, 0));
                   }
                }
            }
        }
        int max = Integer.MIN_VALUE;
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if(check()) {
                if(max == Integer.MIN_VALUE) {
                    System.out.println(0);
                } else {
                    System.out.println(max);
                }
                System.exit(0);
            }
            int nx, ny, nz;
            for(int i=0; i<6; i++) {
                nx = node.x + dx[i];
                ny = node.y + dy[i];
                nz = node.z + dz[i];

                if(nz<0 || ny<0 || nx<0 || nx>=m || ny>=n || nz>=h) continue;

                if(box[nz][ny][nx] == 0) {
                    box[nz][ny][nx] = 1;
                    max = Math.max(node.c+1, max);
                    queue.add(new Node(nz, ny, nx, node.c+1));
                }
            }
        }
        System.out.println(-1);
    }
    public static boolean check() {
        for(int i=0; i<h; i++) {
            for(int j=0; j<n; j++) {
                for(int k=0; k<m; k++) {
                    if(box[i][j][k] == 0){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
