package com.solution.baekjoon.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 백준 22865, 가장 먼 곳, 골드 4
 */
public class BOJ22865 {
	static class Node {
		int next, value;

		public Node(int next, int value) {
			this.next = next;
			this.value = value;
		}
	}
	static int n;
	static boolean[] visited;
	static ArrayList<ArrayList<Node>> list = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		for(int i=0; i<=n; i++) {
			list.add(new ArrayList<>());
		}
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		int m = Integer.parseInt(br.readLine());
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			list.get(d).add(new Node(e, v));
			list.get(e).add(new Node(d, v));
		}

		int[] tempA = dfs(a);
		int[] tempB = dfs(b);
		int[] tempC = dfs(c);
		int v = 0;
		int cnt = 0;
		for(int i=1; i<=n; i++) {
			int minD = Math.min(tempA[i], Math.min(tempB[i], tempC[i]));

			if(minD > cnt) {
				cnt = minD;
				v = minD;
			}
		}

		System.out.println(v);
	}
	public static int[] dfs(int x) {
		int[] temp = new int[n+1];
		for(int i=1; i<=n; i++) {
			temp[i] = Integer.MAX_VALUE;
		}
		temp[x] = 0;
		PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(o->o.value));
		queue.add(new Node(x, 0));

		while (!queue.isEmpty()) {
			Node node = queue.poll();
			for (Node next : list.get(node.next)) {
				if(temp[node.next] + next.value < temp[next.next]) {
					temp[next.next] = temp[node.next] + next.value;
					queue.add(new Node(next.next, temp[next.next]));
				}
			}
		}

		return temp;
	}
}
