package com.solution.baekjoon.dfsbfs;

/**
 * 백준 14502 연구소, 골드 4
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ14502 {
	static int n, m;
	static int[][] map;
	static int[] sx = {1,-1,0,0};
	static int[] sy = {0,0,1,-1};
	static int max = -1;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n][m];

		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int k=0; k<m; k++) {
				map[i][k] = Integer.parseInt(st.nextToken());
			}
		}

		dfs(0);

		System.out.println(max);
	}

	static public void dfs(int c) {
		if(c==3) {
			bfs();
			return;
		}

		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(map[i][j]==0) {
					map[i][j] = 1;
					dfs(c+1);
					map[i][j] = 0;
				}
			}
		}
	}

	static public void bfs() {
		Queue<Node> q = new LinkedList<>();

		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(map[i][j] == 2) {
					q.add(new Node(i, j));
				}
			}
		}

		int[][] copyMap = new int[n][m];
		for (int i=0; i<n; i++) {
			copyMap[i] = map[i].clone();
		}

		while(!q.isEmpty()) {
			Node nd = q.poll();

			for(int i=0; i<4; i++) {
				int dx = nd.x + sx[i];
				int dy = nd.y + sy[i];

				if(dx<0 || dy<0 || dx>=n || dy>=m) continue;

				if(copyMap[dx][dy] == 0) {
					q.add(new Node(dx, dy));
					copyMap[dx][dy] = 2;
				}
			}
		}

		int sum=0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(copyMap[i][j]==0) {
					sum+=1;
				}
			}
		}

		if (max<sum) max=sum;
	}

	static class Node {
		int x,y;
		Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}

