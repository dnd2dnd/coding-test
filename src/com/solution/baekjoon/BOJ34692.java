package com.solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ34692 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        long[] t = new long[n];
        for (int i = 0; i < n; i++) {
            t[i] = Long.parseLong(st.nextToken());
        }

        // 최소 힙: 각 기기의 현재 총 대기 시간 저장
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for (int i = 0; i < m; i++) {
            pq.offer(0L); // 처음엔 모든 기기 대기 시간 0
        }

        // N명의 사람을 순서대로 배치
        for (int i = 0; i < n; i++) {
            long minWait = pq.poll();           // 현재 가장 짧은 대기 시간 기기 선택
            pq.offer(minWait + t[i]);           // 그 기기에 자신의 플레이 시간 추가 후 다시 넣기
        }

        if (pq.peek() <= k) {
            System.out.println("WAIT");
        } else {
            System.out.println("GO");
        }
    }

}
