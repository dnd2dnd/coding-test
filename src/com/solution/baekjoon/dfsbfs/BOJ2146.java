package com.solution.baekjoon.dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 백준 2146, 다리 만들기, 골드 3
 * https://www.acmicpc.net/problem/2146
 */
public class BOJ2146 {
	public static class Node {
		int x, y, v;

		public Node(int x, int y, int v) {
			this.x = x;
			this.y = y;
			this.v = v;
		}
	}
	static int n, value = 2, min = Integer.MAX_VALUE;
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	static int[][] maps;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		maps = new int[n+1][n+1];

		StringTokenizer st;
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				maps[i][j] = Integer.parseInt(st.nextToken());
			}
		}


		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(maps[i][j] == 1) {
					dfs(i, j);
					value++;
				}
			}
		}

		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(maps[i][j] != 0) {
					createLadder(i, j, maps[i][j]);
				}
			}
		}

		System.out.println(min);
	}
	public static void dfs(int x, int y) {
		maps[x][y] = value;
		int nx, ny;
		for(int i=0; i<4; i++) {
			nx = x + dx[i];
			ny = y + dy[i];

			if(nx<0 || ny<0 || nx>=n || ny>=n) continue;

			if(maps[nx][ny]==1) {
				dfs(nx, ny);
			}
		}
	}
	public static void createLadder(int x, int y, int v) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(x, y, 0));
		boolean[][] visited = new boolean[n+1][n+1];
		visited[x][y] = true;

		while (!queue.isEmpty()) {
			Node node = queue.poll();

			int nx, ny;
			for(int i=0; i<4; i++) {
				nx = node.x + dx[i];
				ny = node.y + dy[i];

				if(nx<0 || ny<0 || nx>=n || ny>=n || maps[nx][ny]==v || visited[nx][ny]) continue;

				visited[nx][ny] = true;
				if(maps[nx][ny]==0) {
					queue.add(new Node(nx, ny, node.v+1));
				} else {
					min = Math.min(min, node.v);
				}
			}
		}
	}
}
