package com.solution.baekjoon.dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 백준 9205, 맥주 마시면서 걸어가기, 골드 5
 */
public class BOJ9205 {
	public static class Node {
		int x, y, d;

		public Node(int x, int y, int d) {
			this.x = x;
			this.y = y;
			this.d = d;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		for(int i=0; i<t; i++) {
			int n = Integer.parseInt(br.readLine());
			int[][] map = new int[n+2][2];
			boolean[] visited = new boolean[n+2];
			for(int j=0; j<n+2; j++) {
				String[] strs = br.readLine().split(" ");
				map[j][0] = Integer.parseInt(strs[0]);
				map[j][1] = Integer.parseInt(strs[1]);
			}

			Queue<Node> queue = new LinkedList<>();
			queue.add(new Node(map[0][0], map[0][1], 0));
			while(!queue.isEmpty()) {
				Node node = queue.poll();
				visited[node.d] = true;
				if(node.x==map[n+1][0] && node.y==map[n+1][1]) {
					break;
				}

				int nx, ny;
				for(int k=1; k<n+2; k++) {
					if(!visited[k]) {
						nx = Math.abs(map[k][0] - node.x);
						ny = Math.abs(map[k][1] - node.y);

						if(nx+ny<=1000) {
							queue.add(new Node(map[k][0], map[k][1], k));
						}
					}
				}
			}
			if(!visited[n+1]) {
				System.out.println("sad");
			} else {
				System.out.println("happy");
			}
		}
	}
}

