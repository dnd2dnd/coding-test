package com.solution.baekjoon.dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ1068 {
    static boolean[] checks;
    static ArrayList<Integer>[] list;
    static int m, ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        list = new ArrayList[n+1];
        for(int i=0; i<=n; i++) {
            list[i] = new ArrayList<>();
        }

        int root = -1;
        for(int i=0; i<n; i++) {
            int x = Integer.parseInt(st.nextToken());
            if (x==-1) {
                root = i;
            } else {
                list[i].add(x);
                list[x].add(i);
            }
        }
        checks = new boolean[n+1];

        m = Integer.parseInt(br.readLine());
        ans = 0;
        if(m==root) {
            System.out.println(0);
        } else {
            dfs(root);
            System.out.println(ans);
        }
    }

    public static void dfs(int x) {
        checks[x] = true;
        int cnt = 0;
        for(int i : list[x]) {
            if(i != m && !checks[i]) {
                cnt++;
                dfs(i);
            }
        }
        if(cnt==0) {
            ans++;
        }
    }
}
