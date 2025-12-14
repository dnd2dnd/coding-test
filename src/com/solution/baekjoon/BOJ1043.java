package com.solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ1043 {
    public static int[] parent;
    public static boolean[] truth;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        parent = new int[n+1];
        truth = new boolean[n+1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        st = new StringTokenizer(br.readLine());
        int truthCount = Integer.parseInt(st.nextToken());
        for (int i = 0; i < truthCount; i++) {
            int person = Integer.parseInt(st.nextToken());
            truth[person] = true;
        }

        ArrayList<ArrayList<Integer>> partyList = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int partySize = Integer.parseInt(st.nextToken());

            ArrayList<Integer> party = new ArrayList<>();
            int firstPerson = Integer.parseInt(st.nextToken());
            party.add(firstPerson);

            for (int j = 1; j < partySize; j++) {
                int nextPerson = Integer.parseInt(st.nextToken());
                union(firstPerson, nextPerson);
                party.add(nextPerson);
            }
            partyList.add(party);
        }

        int cnt = 0;
        for (ArrayList<Integer> party : partyList) {
            boolean safe = true;

            for (int p : party) {
                if(truth[find(p)]) {
                    safe = false;
                    break;
                }
            }

            if (safe) {
                cnt++;
            }
        }
        System.out.println(cnt);

    }

    public static int find(int x) {
        if (parent[x] == x) {
            return x;
        }

        return parent[x] = find(parent[x]);
    }

    public static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA != rootB) {
            parent[rootA] = rootB;
        }
        if (truth[rootA] || truth[rootB]) {
            truth[rootB] = true;
        }
    }

}
