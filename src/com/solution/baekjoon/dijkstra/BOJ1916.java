package com.solution.baekjoon.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 *  백준 1916, 최소 비용 구하기, 골드 5
 */
public class BOJ1916 {
	public static class Node {
		int y, c;

		public Node(int y, int c) {
			this.y = y;
			this.c = c;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		int[] city = new int[n+1];
		for(int i=0; i<=n; i++) {
			city[i] = Integer.MAX_VALUE;
		}
		ArrayList<ArrayList<Node>> list = new ArrayList<>();
		for(int i=0; i<=n; i++) {
			list.add(new ArrayList<>());
		}

		StringTokenizer st;
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			list.get(a).add(new Node(b, c));
		}

		PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(o->o.c));
		st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		queue.add(new Node(A, 0));
		city[A] = 0;

		boolean[] visited = new boolean[n+1];
		while(!queue.isEmpty()) {
			Node node = queue.poll();

			if(visited[node.y]) continue;

			visited[node.y] = true;
			for (Node next : list.get(node.y)) {
				if(city[node.y] + next.c < city[next.y]) {
					city[next.y] = city[node.y] + next.c;
					queue.add(new Node(next.y, city[next.y]));
				}
			}
		}
		System.out.println(city[B]);
	}
}

