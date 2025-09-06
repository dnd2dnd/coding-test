package com.solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ13975 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        for (int i=0; i<T; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());

            PriorityQueue<Long> pq = new PriorityQueue<>();
            String[] strs = br.readLine().split(" ");
            for (int j=0; j<k; j++) {
                pq.add(Long.parseLong(strs[j]));
            }

            long sum = 0;
            while (!pq.isEmpty()) {
                long x = pq.poll();

                if (pq.isEmpty()) {
                    System.out.println(sum);
                    break;
                }
                long y = pq.poll();

                long z = x+y;
                pq.add(z);
                sum += z;
            }
        }

    }
}
