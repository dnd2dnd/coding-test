package com.solution.baekjoon.dfsbfs;

import javax.print.DocFlavor;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ2644 {
    static ArrayList<ArrayList<Integer>> list;
    static boolean[] check;
    static int a, b;
    static boolean t;
    static int cnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();
        check = new boolean[n+1];
        for(int i=1; i<=n+1; i++) {
            list.add(new ArrayList<>());
        }

        int m = Integer.parseInt(br.readLine());

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            list.get(x).add(y);
            list.get(y).add(x);
        }
        t=false;
        dfs(a, 1);
        System.out.println(cnt>0 ? cnt : -1);
    }
    public static void dfs(int x, int d) {
        check[x] = true;

        for (Integer i : list.get(x)) {
            if(i == b){
                cnt = d;
                return;
            }

            if(!check[i] && !t) {
                dfs(i, d+1);
            }
        }
    }
}
