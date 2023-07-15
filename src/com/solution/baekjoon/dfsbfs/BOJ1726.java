package com.solution.baekjoon.dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 백준 1726 로봇, 골드 3
 */
public class BOJ1726 {
	static int m, n;
	static int[][] space;
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	static int[] dxy = {0, 2, 1, 3};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		space = new int[m][n];
		boolean[][][] check = new boolean[m][n][4];

		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				space[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int[][] move = new int[2][3];
		for(int i=0; i<2; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<3;j++) {
				move[i][j] = Integer.parseInt(st.nextToken())-1;
			}
		}

		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(move[0][0], move[0][1], move[0][2], 0));

		while(!queue.isEmpty()) {
			Node node = queue.poll();
			// System.out.println(node.x+ " "+ node.y + " " + node.d + " " + node.command);
			int nx, ny;

			if(node.x == move[1][0] && node.y == move[1][1] && node.d == move[1][2]) {
				System.out.println(node.command);
				// System.out.println(node.command + getTurn(node.d, move[1][2]+1));
				break;
			}

			for(int i=1; i<=3; i++) {
				nx = node.x + dx[node.d]*i;
				ny = node.y + dy[node.d]*i;
				if(nx<0 || ny<0 || nx>=m || ny>=n) continue;
				if(space[nx][ny]==1) break;

				if(!check[nx][ny][node.d]) {
					check[nx][ny][node.d] = true;
					queue.add(new Node(nx, ny, node.d, node.command+1));
				}
			}
			int left =0, right = 0;
			switch (node.d) {
				case 0 : left=3;right=2; break;
				case 1 : left=2;right=3; break;
				case 2 : left=0;right=1; break;
				case 3 : left=1;right=0; break;

			}

			if(!check[node.x][node.y][left]) {
				check[node.x][node.y][left] = true;
				queue.add(new Node(node.x, node.y, left, node.command+1));
			}
			if(!check[node.x][node.y][right]) {
				check[node.x][node.y][right] = true;
				queue.add(new Node(node.x, node.y, right, node.command+1));
			}
			// for(int i=0; i<4; i++) {
			// 	int k = getTurn(dxy[node.d], dxy[i]);
			// 	if(!check[node.x][node.y][dxy[i]]) {
			// 		check[node.x][node.y][dxy[i]] = true;
			// 		queue.add(new Node(node.x, node.y, dxy[i], node.command+k));
			// 	}
			// }
			// for(int i=0; i<4; i++) {
			// 	nx = node.x + dx[dxy[i]];
			// 	ny = node.y + dy[dxy[i]];
			//
			// 	if(nx<0 || ny<0 || nx>=m || ny>=n) continue;
			//
			// 	if(!check[nx][ny] && space[nx][ny]==0) {
			// 		if(dxy[i] == node.d) {
			// 			if(node.count==0 || node.count==3) {
			// 				queue.add(new Node(nx, ny, node.d, 1, node.command+1));
			// 			} else {
			// 				queue.add(new Node(nx, ny, node.d, node.count+1, node.command));
			// 			}
			// 		} else {
			// 			int k = getTurn(node.d, dxy[i]);
			// 			queue.add(new Node(nx, ny, dxy[i], 0, node.command+k));
			// 		}
			// 		check[nx][ny] = true;
			// 	}
			// }
		}
	}

	public static int getTurn(int from, int to) {
		// int dxy[] = {0, 2, 1, 3};//동서남북 => 동남서북
		int x = Math.abs(to - from);
		if(x==3) {
			return 1;
		}
		return x;
	}


	public static class Node {
		int x, y, d, command;

		public Node(int x, int y, int d, int command) {
			this.x = x;
			this.y = y;
			this.d = d;
			this.command = command;
		}
	}
}
