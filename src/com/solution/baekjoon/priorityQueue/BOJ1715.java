package com.solution.baekjoon.priorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ1715 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(st.nextToken());

        int sum = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            pq.add(a);
        }

        while(!pq.isEmpty()) {
            int x = pq.poll();

            if (pq.isEmpty()) {
                System.out.println(sum);
                break;
            }

            int y = pq.poll();
            sum += (x + y);
            pq.add(x + y);
        }
    }
}
