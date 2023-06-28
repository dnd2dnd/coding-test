package com.solution.baekjoon.dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 백준 2206 벽 부수고 이동하기, 골드 3
 */
public class BOJ2206 {
	static int n, m;
	static int[][] map;
	static int[] sx = {1, -1, 0, 0};
	static int[] sy = {0, 0, 1, -1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			String a[] = st.nextToken().split("");
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(a[j]);
			}
		}

		int ans = Integer.MAX_VALUE;
		boolean[][][] visited = new boolean[n][m][2];
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(0,0,1, false));

		while(!q.isEmpty()) {
			Node node = q.poll();

			if(node.x == n-1 && node.y == m-1) {
				System.out.println(node.d);
				return;
			}

			int dx, dy;
			for(int i=0; i<4; i++) {
				dx = node.x + sx[i];
				dy = node.y + sy[i];

				if(dx<0 || dy<0 || dx>=n || dy>=m) continue;

				if(map[dx][dy]==0) {
					if(!visited[dx][dy][0] && !node.c) {
						q.add(new Node(dx, dy, node.d+1, false));
						visited[dx][dy][0]=true;
					} else if(!visited[dx][dy][1] && node.c) {
						q.add(new Node(dx, dy, node.d+1, true));
						visited[dx][dy][1]=true;
					}
				} else if (map[dx][dy]==1) {
					if(!node.c) {
						q.add(new Node(dx, dy, node.d+1, true));
						visited[dx][dy][1]=true;
					}
				}
			}

		}
		System.out.println(-1);
	}


	static class Node {
		int x, y, d;
		boolean c;

		public Node(int x, int y, int d, boolean c) {
			this.x = x;
			this.y = y;
			this.d = d;
			this.c = c;
		}
	}
}
