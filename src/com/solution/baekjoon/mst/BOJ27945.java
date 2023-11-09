package com.solution.baekjoon.mst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 백준 27945, 슬슬 가지를 먹지 않으면 죽는다, 골드 3
 */
public class BOJ27945 {
	public static class Node implements Comparable<Node> {
		int x, y, c;

		public Node(int x, int y, int c) {
			this.x = x;
			this.y = y;
			this.c = c;
		}


		@Override
		public int compareTo(Node node) {
			return this.c - node.c;
		}
	}
	public static int[] parent;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = br.readLine().split(" ");
		int n = Integer.parseInt(strs[0]);
		int m = Integer.parseInt(strs[1]);


		parent = new int[n+1];
		for(int i=1; i<=n; i++) {
			parent[i] = i;
		}

		Queue<Node> queue = new PriorityQueue<>();
		StringTokenizer st;
		int u, v, t;
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			u = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());
			t = Integer.parseInt(st.nextToken());
			queue.add(new Node(u, v, t));
		}

		int day=1;
		while(!queue.isEmpty()) {
			Node node = queue.poll();

			if(!union(node) && day == node.c) {
				day++;
			}
		}
		System.out.println(day);
	}
	public static int find(int v) {
		if(parent[v] == v) return v;
		return parent[v] = find(parent[v]);
	}
	public static boolean union(Node node) {
		int x = find(node.x);
		int y = find(node.y);

		if(x==y) {
			return true;
		} else {
			parent[y] = x;
		}
		return false;
	}
}
