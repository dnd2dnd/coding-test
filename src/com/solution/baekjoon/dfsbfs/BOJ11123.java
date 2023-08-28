package com.solution.baekjoon.dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 11123번 양 한마리... 양 두마리..., 실버 2
 */
public class BOJ11123 {
    static String[][] map;
    static int h, w;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for(int i=0; i<t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            h = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            map = new String[h][w];
            for(int k=0; k<h; k++) {
                String[] strs = br.readLine().split("");
                for(int j=0; j<w; j++) {
                    map[k][j] = strs[j];
                }
            }
            int cnt = 0;
            for(int k=0; k<h; k++) {
                for(int j=0; j<w; j++) {
                    if(map[k][j].equals("#")) {
                        dfs(k,j);
                        cnt++;
                    }
                }
            }
            System.out.println(cnt);
        }
    }
    public static void dfs(int x, int y) {
        int nx, ny;
        for(int i=0; i<4; i++) {
            nx = x + dx[i];
            ny = y + dy[i];

            if(nx<0 || ny<0 || nx>=h || ny>=w || map[nx][ny].equals(".")) continue;

            if(map[nx][ny].equals("#")){
                map[nx][ny] = ".";
                dfs(nx, ny);
            }
        }
    }
}
