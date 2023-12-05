package com.solution.baekjoon.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 *  백준 14938, 서강그라운드, 골드 5
 */
public class BOJ14938 {
	public static class Node {
		int y, c;

		public Node(int y, int c) {
			this.y = y;
			this.c = c;
		}
	}
	static int n, m, r, max = Integer.MIN_VALUE;
	static int[] area;
	static ArrayList<ArrayList<Node>> list;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());

		list = new ArrayList<>();
		area = new int[n+1];
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=n; i++) {
			area[i] = Integer.parseInt(st.nextToken());
		}

		for(int i=0; i<=n; i++) {
			list.add(new ArrayList<>());
		}

		for(int i=0; i<r; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			list.get(a).add(new Node(b, c));
			list.get(b).add(new Node(a, c));
		}

		for(int i=1; i<=n; i++) {
			visited = new boolean[n+1];
			max = Math.max(max, rec(i));
		}

		System.out.println(max);

	}
	public static int rec(int x) {
		int cnt = 0;
		int[] recArea = new int[n+1];
		for(int i=1; i<=n; i++) {
			recArea[i] = m+1;
		}
		PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.c));
		queue.add(new Node(x, 0));
		recArea[x] = 0;

		while (!queue.isEmpty()) {
			Node node = queue.poll();

			if(visited[node.y]) continue;

			visited[node.y] = true;
			cnt += area[node.y];
			for (Node next : list.get(node.y)) {
				if(recArea[node.y] + next.c < recArea[next.y] && !visited[next.y]) {
					recArea[next.y] = recArea[node.y] + next.c;
					queue.add(new Node(next.y, recArea[next.y]));
				}
			}
		}

		return cnt;
	}
}
