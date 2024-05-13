package com.solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ1446 {
	static int n, d;
	static int[] distance;
	static List<List<Node>> list = new ArrayList<>();
	public static class Node {
		int y, z;

		public Node(int y, int z) {
			this.y = y;
			this.z = z;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		distance = new int[10001];
		for(int i=0; i<=10000; i++) {
			list.add(new ArrayList<>());
			distance[i]=i;
		}
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			list.get(x).add(new Node(y, z));
		}
		dijkstra(0);
		System.out.println(distance[d]);
	}
	public static void dijkstra(int start) {
		if(start>d) return;

		if(distance[start+1] > distance[start] + 1) {
			distance[start+1] = distance[start] + 1;
		}

		for (Node node : list.get(start)) {
			if(distance[node.y] > distance[start] + node.z) {
				distance[node.y] = distance[start] + node.z;
			}
		}
		dijkstra(start+1);
	}
}