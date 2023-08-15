package com.solution.baekjoon.dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ16437 {
    static int[] animals;
    static boolean[] checks;
    static ArrayList<ArrayList<Integer>> list;
    static long ans = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        animals = new int[n+1];

        list = new ArrayList<>();
        for(int i=0; i<=n+1; i++) {
            list.add(new ArrayList<>());
        }


        for(int i=2; i<=n; i++) {
            st = new StringTokenizer(br.readLine());
            String t = st.nextToken();
            int a = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());

            list.get(p).add(i);
            if(t.equals("S")) {
                animals[i] = a;
            } else {
                animals[i] = -a;
            }
        }
        System.out.println(dfs(1));
//        for(int i=2; i<=n; i++) {
//            checks = new boolean[n+1];
//            if(animals[i]>=1) {
//                dfs(i, animals[i]);
//                animals[i] = 0;
//            }
//        }
//        System.out.println(ans);
    }
    public static long dfs(int x) {
        long ans = 0;

        for (Integer i : list.get(x)) {
            ans += dfs(i);
        }

        if(ans + animals[x] >= 0) {
            return ans+animals[x];
        } else {
            return 0;
        }
    }
//    public static void dfs(int x, int animal) {
//        checks[x] = true;
//
//        if(x==1) {
//            checks[1] = false;
//            ans += animal;
//            return;
//        }
//
//        for(Integer i : list.get(x)) {
//            if(!checks[i]) {
//                if (animal + animals[i] >= 0) {
//                    dfs(i, animal+animals[i]);
//                }
//            }
//        }
//    }
}
