package com.solution.baekjoon.dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 백준 2617, 구슬 찾기, 골드 4
 */
public class BOJ2617 {
    static ArrayList<ArrayList<Integer>> list;
    static ArrayList<ArrayList<Integer>> list2;
    static boolean[] check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();
        for(int i=0; i<=n; i++) {
            list.add(new ArrayList<>());
        }

        list2 = new ArrayList<>();
        for(int i=0; i<=n; i++) {
            list2.add(new ArrayList<>());
        }

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            list.get(y).add(x);
            list2.get(x).add(y);
        }

        int ans = 0;
        for(int i=1; i<=n; i++) {
            check = new boolean[n+1];
            if(dfs(i)>n/2) {
                ans++;
            } else {
                check = new boolean[n+1];
                if(dfs2(i)>n/2) {
                    ans++;
                }
            }
        }
        System.out.println(ans);
    }
    public static int dfs(int x) {
        int d = 0;
        check[x] = true;

        for(Integer i : list.get(x)) {
            if(!check[i]) {
                d++;
                d += dfs(i);
            }
        }
        return d;
    }

    public static int dfs2(int x) {
        int d = 0;
        check[x] = true;

        for(Integer i : list2.get(x)) {
            if(!check[i]) {
                d++;
                d += dfs2(i);
            }
        }
        return d;
    }
}
