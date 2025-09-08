package com.solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ15655 {
    static int N, M;
    public static int[] arr;
    public static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];

        String[] strs  = br.readLine().split(" ");
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(strs[i]);
        }
        Arrays.sort(arr);

        visited = new boolean[N];
        back(0, 0, new int[M]);
    }
    public static void back(int x, int d, int[] temp) {
        if (M==d) {
            for (int v : temp) {
                System.out.print(v + " ");
            }
            System.out.println();
            return;
        }
        for (int i =x; i < N; i++) {
            if (!visited[i]) {
                temp[d] = arr[i];
                visited[i] = true;
                back(i+1, d+1, temp);
                visited[i] = false;
            }
        }
    }
}
