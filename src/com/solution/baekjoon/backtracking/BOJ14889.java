package com.solution.baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 14889, 스타트와 링크, 실버 2
 */
public class BOJ14889 {
    static int n, answer;
    static int[][] point;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        point = new int[n+1][n+1];
        visited = new boolean[n+1];
        for(int i=1; i<=n; i++) {
            String[] strings = br.readLine().split(" ");
            for(int j=1; j<=n; j++) {
                point[i][j] = Integer.parseInt(strings[j-1]);
            }
        }

        answer = Integer.MAX_VALUE;
        com(1, 0);
        System.out.println(answer);

    }
    public static void com(int x, int d) {
        if(d==n/2) {
            dfs();
            return;
        }

        for(int i=x; i<=n; i++) {
            visited[i] = true;
            com( i+1, d+1);
            visited[i] = false;
        }
    }

    public static void dfs() {
        int start=0;
        int link=0;

        for(int i=1; i<=n-1; i++) {
            for(int j=i+1; j<=n; j++) {
                if(visited[i] && visited[j]) {
                    start += point[i][j];
                    start += point[j][i];
                }else if(!visited[i] && !visited[j]) {
                    link += point[i][j];
                    link += point[j][i];
                }
            }
        }
        answer = Math.min(answer, Math.abs(start-link));
    }
}
