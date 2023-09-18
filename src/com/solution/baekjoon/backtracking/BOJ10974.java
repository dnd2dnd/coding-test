package com.solution.baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준 10974, 모든 순열, 실버 3
 */
public class BOJ10974 {
    static int n;
    static boolean[] visited;
    static int[] nums;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        nums = new int[n];
        visited = new boolean[n];

        per(0);

    }
    public static void per(int d) {
        if(d==n) {
            for (int i : nums) {
                System.out.print(i+" ");
            }
            System.out.println();
        }

        for(int i=0; i<n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                nums[d] = i+1;
                per(d+1);
                visited[i] = false;
            }
        }
    }
}

