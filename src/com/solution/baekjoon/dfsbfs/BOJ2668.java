package com.solution.baekjoon.dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class BOJ2668 {
    static int[] nums;
    static boolean[] visited;
    static ArrayList<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        nums = new int[n+1];
        visited = new boolean[n+1];
        for(int i=1; i<=n; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        for(int i=1; i<=n; i++) {
            visited[i] = true;
            dfs(nums[i], i);
            visited[i] = false;
        }

        Collections.sort(list);
        System.out.println(list.size());
        for(int i=0; i<list.size(); i++) {
            System.out.println(list.get(i));
        }

    }
    public static void dfs(int next, int start) {
        if(!visited[next]) {
            visited[next] = true;
            dfs(nums[next], start);
            visited[next] = false;
        }

        if(nums[next] == start) {
            list.add(start);
        }
    }
}
