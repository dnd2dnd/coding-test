package com.solution.baekjoon;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ19580 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        PriorityQueue<long[]> pq = new PriorityQueue<>((o1, o2) -> {
            if(o1[1]==o2[1]) {
                return Long.compare(o2[0], o1[0]);
            } else {
                return Long.compare(o1[1], o2[1]);
            }
        });

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            long l = Long.parseLong(st.nextToken());
            long r = Long.parseLong(st.nextToken());
            pq.offer(new long[]{l, r});
        }

        TreeMap<Long, Integer> map = new TreeMap<>();
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            long p = Long.parseLong(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            map.put(p, map.getOrDefault(p, 0) + x);
        }

        int cnt = 0;
        while(!pq.isEmpty() && !map.isEmpty()) {
            long[] p = pq.poll();
            long l = p[0];
            long r = p[1];

            Map.Entry<Long,Integer> x = map.ceilingEntry(l);
            if(x==null) continue;

            if(x.getKey() <= r) {
                int count = x.getValue();
                cnt++;
                count--;
                if(count == 0) {
                    map.remove(x.getKey());
                } else {
                    map.replace(x.getKey(), count);
                }
            }
        }
        System.out.println(cnt);
    }
}
