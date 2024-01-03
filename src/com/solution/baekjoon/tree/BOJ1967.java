package com.solution.baekjoon.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 백준 1967, 트리의 지름, 골드 4
 */
public class BOJ1967 {
	public static class Node {
		int next, value;

		public Node(int next, int value) {
			this.next = next;
			this.value = value;
		}
	}
	public static int maxNode = 1;
	public static int max = Integer.MIN_VALUE;
	public static boolean[] visited;
	public static ArrayList<ArrayList<Node>> list = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		visited = new boolean[n+1];
		for(int i=0; i<=n; i++) {
			list.add(new ArrayList<>());
		}

		StringTokenizer st;
		for(int i=0; i<n-1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			list.get(a).add(new Node(b, c));
			list.get(b).add(new Node(a, c));
		}

		dfs(1, 0);
		visited = new boolean[n+1];
		dfs(maxNode, 0);
		System.out.println(max);
	}
	public static void dfs(int start, int sum) {
		visited[start] = true;
		for (Node node : list.get(start)) {
			if(!visited[node.next]) {
				dfs(node.next, sum + node.value);
			}
		}

		if(max<sum) {
			max = sum;
			maxNode = start;
		}
	}
}
