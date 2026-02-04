package com.solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2252 {
    public static List<List<Integer>> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] nodes = new int[n+1];
        for (int i=0; i<=n; i++) {
            list.add(new ArrayList<>());
        }

        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            nodes[b]++;
        }

        StringBuilder sb = new StringBuilder();
        Queue<Integer> queue = new LinkedList<>();
        for (int i=1; i<=n; i++) {
            if (nodes[i] == 0) {
                queue.add(i);
                sb.append(i + " ");
            }
        }

        while (!queue.isEmpty()) {
            int x = queue.poll();

            for (Integer i : list.get(x)) {
                nodes[i]--;
                if (nodes[i] == 0) {
                    queue.add(i);
                    sb.append(i+ " ");
                }
            }
        }

        System.out.println(sb);
    }
}
