package com.solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14503 {
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, 1, 0, -1};
    public static int[][] arr;
    static int n, m, ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        arr = new int[n][m];

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bfs(r, c, d);
        System.out.println(ans);
    }
    public static void bfs(int x, int y, int d) {
        if(arr[x][y]==0) {
            ans++;
            arr[x][y] = 2;
        }
        for(int i=0; i<4; i++) {
            int dd = (d+3-i)%4;
            int nx = x + dx[dd];
            int ny = y + dy[dd];

            if(nx>=0 && ny>=0 && nx<n && ny<m && arr[nx][ny]==0) {
                bfs(nx, ny, dd);
                return;
            }
        }

        int dd = (d+2)%4;
        int nx = x + dx[dd];
        int ny = y + dy[dd];
        if(nx>=0 && ny>=0 && nx<n && ny<m && arr[nx][ny]!=1) {
            bfs(nx, ny, d);
        }
    }
}

