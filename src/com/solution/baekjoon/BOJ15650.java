package com.solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ15650 {
    static int n, m;
    static boolean[] visited;
    static StringBuffer sb = new StringBuffer();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        visited = new boolean[n+1];
        com(1, 0, new int[m]);

        System.out.println(sb);
    }
    public static void com(int x, int d, int[] temp) {
        if(d==m) {
            for (int i : temp) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=x; i<=n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                temp[d] = i;
                com(i+1, d+1, temp);
                visited[i] = false;
            }
        }
    }
}

