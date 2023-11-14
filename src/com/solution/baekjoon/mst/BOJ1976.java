package com.solution.baekjoon.mst;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 백준 1976, 여행 가자, 골드 4
 */
public class BOJ1976 {
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        parent = new int[n+1];
        for(int i=1; i<=n; i++) {
            parent[i] = i ;
        }
        StringTokenizer st;
        for(int i=1; i<=n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=n; j++) {
                if(Integer.parseInt(st.nextToken())==1) {
                    union(i, j);
                }
            }
        }

        ArrayList<Integer> list = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        String answer = "YES";
        int check = find(list.get(0));
        for(int i=1; i<list.size(); i++) {
            if(check != find(list.get(i))) {
                answer = "NO";
                break;
            }
        }
        System.out.println(answer);
    }
    public static int find(int x) {
        if(parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }
    public static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if(x==y) return;
        parent[y] = x;
    }
}
