package com.solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ1753 {
	public static int[] distance;
	public static boolean[] visited;
	public static List<List<Node>> list = new ArrayList<>();
	public static class Node {
		int v, w;

		public Node(int v, int w) {
			this.v = v;
			this.w = w;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int v = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());

		distance = new int[v+1];
		for(int i=0; i<=v; i++) {
			list.add(new ArrayList<>());
			distance[i] = Integer.MAX_VALUE;
		}

		int k = Integer.parseInt(br.readLine());

		for(int i=0; i<e; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			list.get(a).add(new Node(b, c));
		}

		visited = new boolean[v+1];
		distance[k] = 0;
		dijkstra(k);

		for (int i = 1; i < distance.length; i++) {
			if(distance[i] == Integer.MAX_VALUE) {
				System.out.println("INF");
			} else {
				System.out.println(distance[i]);
			}
		}
	}
	public static void dijkstra(int x) {
		for (Node node : list.get(x)) {
			if(distance[node.v] > distance[x] + node.w) {
				visited[node.v] = true;
				distance[node.v] = distance[x] + node.w;
				dijkstra(node.v);
			}
		}
	}
}
