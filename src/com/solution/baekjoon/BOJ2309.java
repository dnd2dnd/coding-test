package com.solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2309 {
    public static int[] nums;
    public static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        nums = new int[9];
        visited = new boolean[9];
        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            nums[i] = x;
        }
        Arrays.sort(nums);

        dfs(0, 0, 0);
    }

    public static void dfs(int i, int d, int count) {
        if (d == 7){
            if(count == 100) {
                for(int j=0; j<9; j++){
                    if (visited[j]) {
                        System.out.println(nums[j]);
                    }
                }
                System.exit(0);
            }
            return;
        }


        for (int j=i; j<9; j++) {
            visited[j] = true;
            dfs(j+1, d+1, count+nums[j]);
            visited[j] = false;
        }

    }
}
