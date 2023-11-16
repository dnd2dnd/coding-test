package com.solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 백준 1238, 파티, 골드 3
 */
public class BOJ1238 {
	static int n, m, x;
	public static class Node {
		int v, c;

		public Node(int v, int c) {
			this.v = v;
			this.c = c;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken())-1;

		ArrayList<ArrayList<Node>> goList = new ArrayList<>();
		ArrayList<ArrayList<Node>> backList = new ArrayList<>();
		for(int i=0; i<n; i++) {
			goList.add(new ArrayList<>());
			backList.add(new ArrayList<>());
		}


		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken());

			goList.get(a).add(new Node(b, c));
			backList.get(b).add(new Node(a, c));
		}

		int[] go = rec(goList);
		int[] back = rec(backList);

		int cnt = Integer.MIN_VALUE;
		for(int i=0; i<n; i++) {
			cnt = Math.max(cnt, go[i] + back[i]);
		}
		System.out.println(cnt);

	}
	public static int[] rec(ArrayList<ArrayList<Node>> list) {
		PriorityQueue<Node> queue = new PriorityQueue<>((Comparator.comparingInt(o -> o.c)));
		queue.add(new Node(x, 0));
		int[] move = new int[n];
		for(int i=0; i<n; i++) {
			move[i] = 10000001;
		}
		move[x] = 0;
		boolean[] visited = new boolean[n];
		while(!queue.isEmpty()) {
			Node node = queue.poll();

			if(visited[node.v]) continue;

			visited[node.v] = true;
			for (Node next : list.get(node.v)) {
				if(move[node.v] + next.c < move[next.v]) {
					move[next.v] = move[node.v] + next.c;
					queue.add(new Node(next.v, move[next.v]));
				}
			}
		}
		return move;
	}
}
