package com.solution.baekjoon.mst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 백준 1197, 최소 스패닝 트리, 골드 4
 */
public class BOJ1197 {
	static int cnt = 0;
	public static class Node implements Comparable<Node> {
		int y, c;

		public Node(int y, int c) {
			this.y = y;
			this.c = c;
		}

		@Override
		public int compareTo(Node o) {
			return this.c - o.c;
		}
	}
	static boolean[] visited;
	static ArrayList<ArrayList<Node>> list = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = br.readLine().split(" ");
		int v = Integer.parseInt(strs[0]);
		int e = Integer.parseInt(strs[1]);

		visited = new boolean[v+1];
		for(int i=0; i<v+1; i++) {
			list.add(new ArrayList<>());
		}

		int a, b, c;
		for(int i=0; i<e; i++) {
			strs = br.readLine().split(" ");
			a = Integer.parseInt(strs[0]);
			b = Integer.parseInt(strs[1]);
			c = Integer.parseInt(strs[2]);
			list.get(a).add(new Node(b, c));
			list.get(b).add(new Node(a, c));
		}

		spanning(1);

		System.out.println(cnt);
	}
	public static void spanning(int x) {
		Queue<Node> queue = new PriorityQueue<>();
		queue.add(new Node(x, 0));

		while (!queue.isEmpty()) {
			Node node = queue.poll();

			if(!visited[node.y]) {
				visited[node.y] = true;
				cnt += node.c;
				for (Node next : list.get(node.y)) {
					if(!visited[next.y]) {
						queue.add(next);
					}
				}
			}
		}
	}
}
