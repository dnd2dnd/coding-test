package com.solution.baekjoon.dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 백준 2638번 치즈, 골드 3
 */
public class BOJ2638 {
	static int n, m;
	static int[][] place;
	static int cheese;
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		place = new int[n][m];
		cheese = 0;
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				place[i][j] = Integer.parseInt(st.nextToken());
				if(place[i][j] == 1) {
					cheese++;
				}
			}
		}

		int lastCheese = 0;
		int cnt =0;
		while(cheese!=0) {
			lastCheese = cheese;
			bfs();
			cnt++;
		}
		System.out.println(cnt);
	}

	public static void bfs() {
		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(0, 0));
		int[][] check = new int[n][m];
		while(!queue.isEmpty()) {
			Node node = queue.poll();

			int nx, ny;
			for(int i=0; i<4; i++) {
				nx = node.x + dx[i];
				ny = node.y + dy[i];
				
				if(nx<0 || ny<0 || nx>=n || ny>=m) continue;

				if(check[nx][ny]!=2) {
					if(place[nx][ny]==0) {
						queue.add(new Node(nx, ny));
						check[nx][ny]=2;
					} else if (place[nx][ny]==1) {
						check[nx][ny]+=1;
						if(check[nx][ny]==2) {
							place[nx][ny]=0;
							cheese--;
						}
					}
				}
			}
		}
	}


	public static class Node {
		int x, y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
