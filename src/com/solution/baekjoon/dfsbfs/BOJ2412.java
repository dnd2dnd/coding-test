package com.solution.baekjoon.dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class BOJ2412 {
	public static class Node implements Comparable<Node>{
		int x, y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Node o) {
			if(this.y == o.y) {
				return this.x - o.x;
			}
			return this.y - o.y;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());

		Node[] nodes = new Node[n+1];
		nodes[0] = new Node(0, 0);
		for(int i=1; i<=n; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			nodes[i] = new Node(x, y);
		}

		Arrays.sort(nodes);
		Queue<Integer> queue = new LinkedList<>();
		queue.add(0);
		int[] visited = new int[n+1];
		visited[0] = 0;
		while (!queue.isEmpty()) {
			int nodeIndex = queue.poll();

			if(nodes[nodeIndex].y == t) {
				System.out.println(visited[nodeIndex]);
				System.exit(-1);
			}

			int nx = nodes[nodeIndex].x;
			int ny = nodes[nodeIndex].y;

			for(int i=nodeIndex+1; i<=n; i++) {
				if(visited[i] != 0) {
					continue;
				}

				int dx = nodes[i].x;
				int dy = nodes[i].y;

				if(dy-ny > 2) {
					break;
				}
				if(Math.abs(dx-nx) > 2) {
					continue;
				}
				visited[i] = visited[nodeIndex]+1;
				queue.add(i);
			}

			for(int i=nodeIndex-1; i>0; i--) {
				if(visited[i] != 0) {
					continue;
				}

				int dx = nodes[i].x;
				int dy = nodes[i].y;

				if(dy-ny < -2) {
					break;
				}
				if(Math.abs(dx-nx) > 2) {
					continue;
				}
				visited[i] = visited[nodeIndex]+1;
				queue.add(i);
			}
		}
		System.out.println(-1);
	}
}
