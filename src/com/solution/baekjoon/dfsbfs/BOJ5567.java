package com.solution.baekjoon.dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 백준 5567, 결혼식, 실버 2
 */
public class BOJ5567 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();

		for(int i=0; i<=n; i++) {
			arrayList.add(new ArrayList<>());
		}

		for(int i=0; i<m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			arrayList.get(x).add(y);
			arrayList.get(y).add(x);
		}

		boolean[] visited = new boolean[n+1];
		int cnt = 0;
		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(1, 0));
		visited[1] = true;
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			for (Integer i : arrayList.get(node.x)) {
				if(!visited[i] && node.d<=1) {
					queue.add(new Node(i, node.d+1));
					visited[i] = true;
					cnt++;
				}
			}
		}
		System.out.println(cnt);
	}
	public static class Node {
		int x, d;

		public Node(int x, int d) {
			this.x = x;
			this.d = d;
		}
	}
}
