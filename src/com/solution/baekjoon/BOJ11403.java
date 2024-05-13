package com.solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ11403 {
    static int[][] arr;
    static boolean[] visited;
    static List<List<Integer>> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        visited = new boolean[n];
        for(int i=0; i<n; i++) {
            list.add(new ArrayList<>());
        }

        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                int x = Integer.parseInt(st.nextToken());
                if(i==j || x==0) {
                    continue;
                }
                list.get(i).add(j);
            }
        }

        for(int i=0; i<n; i++) {
            dfs(i, i);
        }

        StringBuffer sb = new StringBuffer();
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
    public static void dfs(int x, int start) {
        for (Integer i : list.get(x)) {
            if(arr[start][i] == 0) {
                arr[start][i] = 1;
                dfs(i, start);
            }
        }
    }
}

