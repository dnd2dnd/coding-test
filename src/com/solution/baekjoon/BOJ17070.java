package com.solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ17070 {
    public static int N, cnt;
    public static int[][] maps;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        maps = new int[N][N];
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<N; j++) {
                maps[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0, 1, 0);
        System.out.println(cnt);
    }

    public static void dfs(int x, int y, int direction) {
        if (x < 0 || y < 0 || x>=N || y>=N || maps[x][y] == 1) {
            return;
        }

        if (direction == 0) {
            dfs(x, y+1, 0);
            dfs(x+1, y+1, 2);
        } else if (direction == 1) {
            dfs(x+1, y, 1);
            dfs(x+1, y+1, 2);
        } else if (direction == 2) {
            if (maps[x-1][y] == 1 || maps[x][y-1] == 1) {
                return;
            }

            dfs(x, y+1, 0);
            dfs(x+1, y, 1);
            dfs(x+1, y+1, 2);
        }

        if (x==N-1 && y==N-1) {
            cnt++;
        }
    }
}

