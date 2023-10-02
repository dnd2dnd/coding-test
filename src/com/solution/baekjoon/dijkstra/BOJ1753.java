package com.solution.baekjoon.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 백준 1753, 최단경로, 골드 4
 */
public class BOJ1753 {
	public static class Node implements Comparable<Node> {
		int x, cost;

		public Node(int x, int cost) {
			this.x = x;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			return cost - o.cost;
		}
	}

	static ArrayList<Node>[] list;
	static int[] dist;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(br.readLine()) - 1;

		list = new ArrayList[V];
		dist = new int[V];

		for(int i=0; i<V; i++) {
			list[i] = new ArrayList<>();
			dist[i] = Integer.MAX_VALUE;
		}

		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken()) - 1;
			int v = Integer.parseInt(st.nextToken()) - 1;
			int w = Integer.parseInt(st.nextToken());
			list[u].add(new Node(v, w));
		}

		dijkstra(K);
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i<V; i++){
			if(dist[i] == Integer.MAX_VALUE)
				sb.append("INF").append("\n");
			else
				sb.append(dist[i]).append("\n");
		}

		System.out.print(sb);
	}
	static void dijkstra(int s) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		dist[s] = 0;
		pq.add(new Node(s, 0));

		while (!pq.isEmpty()) {
			Node node = pq.poll();
			for (int i = 0; i < list[node.x].size(); i++) {
				Node next = list[node.x].get(i);

				if(dist[next.x] > node.cost + next.cost) {
					dist[next.x] = node.cost + next.cost;
					pq.add(new Node(next.x, dist[next.x]));
				}
			}
		}
	}
}
