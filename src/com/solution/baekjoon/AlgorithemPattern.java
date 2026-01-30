package com.solution.baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class AlgorithemPattern {

    /**
     * "가장 작은 값부터 처리"
     * "최댓값을 계속 뽑는다"
     * "상위 K개 유지"
     * "시간 순으로 작업 처리"
     * "최단 거리 갱신"
     */
    public static void dijkstra(int start) {
        int n = 4;
        int[] dist= new int[n+1];
        List<List<Node>> graph = new ArrayList<>();

        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.w, b.w));
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (dist[cur.v] < cur.w) continue;

            for (Node next : graph.get(cur.v)) {
                if (dist[next.v] > cur.w + next.w) {
                    dist[next.v] = cur.w + next.w;
                    pq.offer(new Node(next.v, dist[next.v]));
                }
            }
        }

    }

    public static class Node {
        int v, w;

        public Node(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }
}
