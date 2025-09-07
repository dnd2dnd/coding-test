package com.solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ15661 {
    public static int N;
    public static int[][] arr;
    public static boolean[] visited;
    public static int cnt = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        arr = new int[N][N];
        visited = new boolean[N];
        for (int i=0; i<N; i++) {
            String[] strs = br.readLine().split(" ");
            for (int j=0; j<N; j++) {
                arr[i][j] = Integer.parseInt(strs[j]);
            }
        }

        for (int i=1; i<N; i++) {
            back(0, i, new ArrayList<>());
        }
        System.out.println(cnt);
    }

    public static void back(int x, int d, List<Integer> temp) {
        if (temp.size() == d) {
            int sumX = 0;
            int sumY = 0;

            List<Integer> list = new ArrayList<>();
            for(int i=0; i<N; i++) {
                list.add(i);
            }
            list.removeAll(temp);

            for (Integer i : temp) {
                for(Integer j : temp) {
                    sumX += arr[i][j];
                }
            }

            for (Integer i : list) {
                for(Integer j : list) {
                    sumY += arr[i][j];
                }
            }

            cnt = Math.min(cnt, Math.abs(sumX - sumY));
            return;
        }

        for (int i=x; i<N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                temp.add(i);
                back(i+1, d, temp);
                temp.remove(temp.size()-1);
                visited[i] = false;
            }
        }
    }

    public static void sum(int x, int d, List<Integer> temp) {

    }
}
