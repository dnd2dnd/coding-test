package com.solution.baekjoon.dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2589 {
	public static class Node {
		int x, y, v;

		public Node(int x, int y, int v) {
			this.x = x;
			this.y = y;
			this.v = v;
		}
	}
	static String[][] maps;
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	static int l,w;
	static int time = Integer.MIN_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		l = Integer.parseInt(st.nextToken());
		w = Integer.parseInt(st.nextToken());

		maps = new String[l][w];
		for(int i=0; i<l; i++) {
			maps[i] = br.readLine().split("");
		}

		for(int i=0; i<l; i++) {
			for(int j=0; j<w; j++) {
				if(maps[i][j].equals("L")) {
					bfs(i, j);
				}
			}
		}
		System.out.println(time);
	}
	public static void bfs(int x, int y) {
		boolean[][] visited = new boolean[l][w];
		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(x, y, 0));
		visited[x][y] = true;

		while(!queue.isEmpty()) {
			Node node = queue.poll();
			time = Math.max(time, node.v);
			int nx, ny;
			for(int i=0; i<4; i++) {
				nx = node.x + dx[i];
				ny = node.y + dy[i];

				if(nx < 0 || ny < 0 || nx >= l || ny >= w || visited[nx][ny] || maps[nx][ny].equals("W")) {
					continue;
				}

				visited[nx][ny] = true;
				queue.add(new Node(nx, ny, node.v+1));
			}
		}
	}
}
