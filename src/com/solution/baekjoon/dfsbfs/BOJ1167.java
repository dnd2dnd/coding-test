package com.solution.baekjoon.dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 백준 1167, 트리의 지름, 골드 2
 */
public class BOJ1167 {
	public static class Node {
		int next, value;

		public Node(int next, int value) {
			this.next = next;
			this.value = value;
		}
	}
	public static int max = Integer.MIN_VALUE;
	public static int maxNode;
	public static boolean[] visited;
	public static ArrayList<ArrayList<Node>> list = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int v = Integer.parseInt(br.readLine());

		for(int i=0; i<=v; i++) {
			list.add(new ArrayList<>());
		}

		StringTokenizer st;
		for(int i=1; i<=v; i++) {
			st = new StringTokenizer(br.readLine());
			int idx = Integer.parseInt(st.nextToken());
			while (true) {
				int x = Integer.parseInt(st.nextToken());
				if (x==-1) {
					break;
				}
				int y = Integer.parseInt(st.nextToken());

				list.get(idx).add(new Node(x, y));
			}
		}

		visited = new boolean[v+1];
		dfs(1, 0);
		visited = new boolean[v+1];
		dfs(maxNode, 0);
		System.out.println(max);
	}
	public static void dfs(int x, int sum) {
		visited[x] = true;
		for (Node node : list.get(x)) {
			if(!visited[node.next]) {
				dfs(node.next, sum + node.value);
			}
		}
		if(max < sum) {
			max = sum;
			maxNode = x;
		}
	}
}

