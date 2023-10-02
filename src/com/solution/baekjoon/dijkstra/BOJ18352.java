package com.solution.baekjoon.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 백준 18532, 특정 거리의 도시 찾기, 실버 2
 */
public class BOJ18352 {
	public static class Node {
		int x, d;

		public Node(int x, int d) {
			this.x = x;
			this.d = d;
		}
	}
	static ArrayList<Integer>[] list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		list = new ArrayList[N+1];
		boolean[] visited = new boolean[N+1];

		for(int i=0; i<N+1; i++) {
			list[i] = new ArrayList<>();
		}

		for(int i=1; i<=M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			list[x].add(y);
		}

		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(X, 0));

		boolean check = false;
		while (!queue.isEmpty()) {
			Node node = queue.poll();

			if(node.d == K) {
				check = true;
				System.out.println(node.x);
			}

			for (int i = 0; i < list[node.x].size(); i++) {
				int x = list[node.x].get(i);
				if(!visited[x]) {
					queue.add(new Node(x, node.d+1));
					visited[x] = true;
				}
			}
		}
		if(!check) {
			System.out.println(-1);
		}
	}
}
