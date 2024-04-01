package com.solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ17136 {
    static int[][] map = new int[10][10];
    static int ans = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i=0; i<10; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<10; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int k=5; k>=1; k--) {
            for(int i=0; i<=10-k; i++) {
                for(int j=0; j<=10-k; j++) {
                    if(map[i][j]==1) {
                        rec(i, j, k);
                    }
                }
            }
        }
        System.out.println(ans);
    }

    public static void rec(int x, int y, int n) {
        for(int i=x; i<x+n; i++) {
            for(int j=y; j<y+n; j++) {
                if(map[i][j]==0) {
                    return;
                }
            }
        }

        for(int i=x; i<x+n; i++) {
            for(int j=y; j<y+n; j++) {
                map[i][j] = 0;
            }
        }
        ans++;
    }
}
