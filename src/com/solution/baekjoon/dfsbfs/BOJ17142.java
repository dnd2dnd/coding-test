package com.solution.baekjoon.dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 백준 17142, 연구소 3, 골드 3
 */
public class BOJ17142 {
	static int n, m, zero_cnt = 0;
	static int[][] map;
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	static int max = Integer.MAX_VALUE;
	static ArrayList<Node> virus = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][n];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());

				if(map[i][j]==0) {
					zero_cnt++;
				} else if(map[i][j]==2) {
					virus.add(new Node(i, j, 0));
				}
			}
		}

		dfs(0, 0, new Node[m]);
		System.out.println(max == Integer.MAX_VALUE ? -1 : max);
	}

	public static void dfs(int d, int s, Node[] nodes) {
		if(d==m) {
			int v = bfs(nodes);

			if(v!=-1) {
				max =Math.min(max, v);
			}

			return;
		}

		for (int i = s; i < virus.size(); i++) {
			nodes[d] = virus.get(i);
			dfs(d+1, i+1, nodes);
		}
	}

	public static int bfs(Node[] nodes) {
		boolean[][] visited = new boolean[n][n];

		Queue<Node> queue = new LinkedList<>();
		for (Node node : nodes) {
			queue.add(node);
			visited[node.x][node.y] = true;
		}
		int cnt = 0;
		int time = 0;
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			int nx, ny;
			for(int i=0; i<4; i++) {
				nx = node.x + dx[i];
				ny = node.y + dy[i];

				if(nx<0 || ny<0 || nx>=n || ny>=n || visited[nx][ny]) continue;

				if(map[nx][ny]==0 || map[nx][ny]==2) {
					if(map[nx][ny]==0){
						cnt++;
						time = Math.max(time, node.t+1);
					}
					queue.add(new Node(nx, ny, node.t+1));
					visited[nx][ny] = true;
				}
			}
		}
		System.out.println(time);
		if(zero_cnt == cnt) return time;
		else return -1;
	}
	public static class Node {
		int x, y, t;

		public Node(int x, int y, int t) {
			this.x = x;
			this.y = y;
			this.t = t;
		}
	}
}